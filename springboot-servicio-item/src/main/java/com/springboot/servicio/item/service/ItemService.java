package com.springboot.servicio.item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.servicio.item.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	
	public Item findById(Long id,Integer cantidad);
	

}
