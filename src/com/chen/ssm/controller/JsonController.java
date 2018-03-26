package com.chen.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.ssm.po.ItemsCustom;

/**
 * springmvc与json交互
 * @author JD
 *
 */
@Controller
public class JsonController {

	/**
	 * 发送json格式数据
	 * @param itemsCustom
	 * @return
	 * 
	 * @RequestBody:将json转成pojo
	 * @ResponseBody：将pojo转成json
	 */
	@RequestMapping("requestJson.action")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
	
	/**
	 * 发送key-value数据
	 * @param itemsCustom
	 * @return
	 */
	@RequestMapping("requestKV.action")
	public @ResponseBody ItemsCustom requestKV(ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
	
}
