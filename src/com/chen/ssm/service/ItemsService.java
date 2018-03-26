package com.chen.ssm.service;

import java.util.List;

import com.chen.ssm.po.ItemsCustom;
import com.chen.ssm.po.ItemsQueryVo;

public interface ItemsService {

	/**
	 * 根据条件查询商品列表信息
	 * @param itemsQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) throws Exception;
	
	/**
	 * 根据id查询商品信息
	 * @param id   
	 * @return
	 * @throws Exception
	 */
	public ItemsCustom queryItemsById(Integer id) throws Exception;
	
	/**
	 * 更新商品信息
	 * @param itemsCustom
	 * @throws Exception
	 */
	public void updateItems(ItemsCustom itemsCustom) throws Exception;
}
