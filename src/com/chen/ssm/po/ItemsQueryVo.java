package com.chen.ssm.po;

import java.util.List;

public class ItemsQueryVo {

	private ItemsCustom itemsCustom; // 包装items
	
	private List<ItemsCustom> itemList; // 将多个商品绑定到该属性上
	
	public List<ItemsCustom> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemsCustom> itemList) {
		this.itemList = itemList;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
	
}
