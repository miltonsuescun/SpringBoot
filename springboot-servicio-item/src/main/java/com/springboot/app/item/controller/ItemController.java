package com.springboot.app.item.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.servicio.item.models.Item;
import com.springboot.servicio.item.service.ItemService;

@ComponentScan({"com.springboot.servicio.item.service"})
@RestController
public class ItemController {

@Autowired
@Qualifier("serviceFeing")
private ItemService itemService;

@GetMapping("/listar")
public List<Item> listar(){
	return itemService.findAll();
};

@GetMapping("item/{id}/cantidad/{cantidad}")
public Item getItem(@PathVariable Long id,@PathVariable  Integer cantidad){
	return itemService.findById(id, cantidad);
};


	
}
