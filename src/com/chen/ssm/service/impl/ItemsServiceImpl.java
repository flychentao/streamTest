package com.chen.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.chen.ssm.mapper.ItemsCustomMapper;
import com.chen.ssm.mapper.ItemsMapper;
import com.chen.ssm.po.Items;
import com.chen.ssm.po.ItemsCustom;
import com.chen.ssm.po.ItemsQueryVo;
import com.chen.ssm.service.ItemsService;
import com.chen.ssm.utils.exception.CustomException;

public class ItemsServiceImpl implements ItemsService {
	
	@Resource
	private ItemsCustomMapper itemsCustomMapper; // @Resource java本身提供的注解  如果使用@autowride这个注解他是由spring提供（相当于spring提供了更多的服务，让我们的app可一定的性能降低）
	
	@Resource
	private ItemsMapper itemsMapper;

	/**
	 * 查询商品的列表信息
	 */
	@Override
	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo)
			throws Exception {
		List<ItemsCustom> itemsCustom = itemsCustomMapper.queryItems(itemsQueryVo);
		return itemsCustom;
	}

	/**
	 * 根据id查询商品列表信息
	 */
	@Override
	public ItemsCustom queryItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		if(items!=null){
			ItemsCustom itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
			return itemsCustom;
		}else{
			throw new CustomException("您查找的商品不存在");
		}
	}

	/**
	 * 更新商品信息
	 */
	@Override
	public void updateItems(ItemsCustom itemsCustom) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

}
