package com.utp.springboot.app.item.models.service;
import java.util.List;

import com.utp.springboot.app.item.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);

}
