package com.chen.ssm.mapper;

import java.util.List;

import com.chen.ssm.po.ItemsCustom;
import com.chen.ssm.po.ItemsQueryVo;

public interface ItemsCustomMapper {

	/**
	 * 根据条件查询商品列表信息
	 * @param itemsQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) throws Exception;
}
