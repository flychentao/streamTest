package com.chen.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chen.ssm.po.ItemsCustom;
import com.chen.ssm.po.ItemsQueryVo;
import com.chen.ssm.service.ItemsService;
import com.chen.ssm.utils.group.GroupA;
import com.chen.ssm.utils.group.GroupB;

@Controller
@RequestMapping("/items") // 窄化请求，分类管理Controller
public class ItemsController{
	
	@Resource
	private ItemsService itemsService;
	
	@ModelAttribute("itemsType")
	public Map<String, String> itemsType(){
		Map<String, String> itemsType = new HashMap<String, String>();
		itemsType.put("t001", "大家电");
		itemsType.put("t002", "母婴产品");
		return itemsType;
	}

	/**
	 * 查询商品列表
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryItems.action",method={RequestMethod.POST,RequestMethod.GET})  // url名称与方法名一致
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception{
		
		// 查询商品的列表信息
		System.out.println("2---queryItems");
		List<ItemsCustom> itemsList = itemsService.queryItems(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemsList"); //  items/itemsList:逻辑地址 
		
		return modelAndView;
	}
	
	/**
	 * 修改商品
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editItems.action")
	public String editItems(Model model, @RequestParam("id") Integer items_id) throws Exception{
		
		ItemsCustom itemsCustom = itemsService.queryItemsById(items_id); // id硬编码   参数绑定在解决    model
		model.addAttribute("items", itemsCustom);
		
		return "items/editItems";
	}
	
	/**
	 * 更新商品信息
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updateItems.action")
	public String updateItems(Model model,
//				@ModelAttribute("items")
				@Validated(value={GroupA.class,GroupB.class}) ItemsCustom itemsCustom, BindingResult bindingResult,
				MultipartFile pictureFile) throws Exception{
//		String name = new String(itemsCustom.getName().getBytes("ISO-8859-1"), "UTF-8");
		
		// 判读bindingResult对象中是否有错误信息
		if(bindingResult.hasErrors()){ // 有错误信息，将错误信息放到model域中并在页面展示
			List<ObjectError> objectErrors = bindingResult.getAllErrors();
			model.addAttribute("objectErrors", objectErrors);
			model.addAttribute("items", itemsCustom);
			return "items/editItems";
		}
		
		// 文件上传
		if(pictureFile!=null && pictureFile.getSize()>0){
			// 修改文件名称 
			String fileName = pictureFile.getOriginalFilename(); // 文件名称
			String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 文件的后缀名
			String newName = UUID.randomUUID().toString().replace("-", "")+suffixName;
			
			// 上传操作
			File file = new File("F:\\upload\\pic\\"+newName);
			pictureFile.transferTo(file); // 上传
			
			itemsCustom.setPic(newName);
		}
		
		itemsService.updateItems(itemsCustom);
		return "redirect:queryItems.action"; // 返回redirect
//		return "forward:queryItems.action";
	}
	
	/**
	 * 批量删除商品信息
	 */
	@RequestMapping("/deleteBatchItems.action")
	public String deleteBatchItems(Integer[] itemsIds){
		System.out.println("删除商品的个数："+itemsIds.length);
		return "success";
	}
	
	/**
	 * 批量删除商品信息
	 * @throws Exception 
	 */
	@RequestMapping("/editBatchItems.action")
	public String editBatchItems(Model model, Integer[] itemsIds) throws Exception{
		List<ItemsCustom> itemsList = itemsService.queryItems(null);
		model.addAttribute("itemsList", itemsList);
		return "items/editBatchItems";
	}
	
	/**
	 * 批量更新操作
	 * @param itemsQueryVo
	 * @return
	 */
	@RequestMapping("/updateBatchItems.action")
	public String updateBatchItems(ItemsQueryVo itemsQueryVo){
		System.out.println("更新的商品个数为："+itemsQueryVo.getItemList().size());
		return "success";
	}
	
	/**
	 * springmvc支持的RESTful风格
	 * @param id
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/requestRESTful/{id}/{name}")
	public @ResponseBody ItemsCustom requestRESTful(@PathVariable Integer id,@PathVariable String name) throws Exception{
		
		ItemsCustom itemsCustom = itemsService.queryItemsById(id);
		return itemsCustom;
	}

}
