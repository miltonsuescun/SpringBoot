package com.springboot.app.item.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.servicio.item.models.Item;
import com.springboot.servicio.item.models.Producto;
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
//@HystrixCommand(fallbackMethod = "metodoAlternativo" )
@GetMapping("item/{id}/cantidad/{cantidad}")
public Item getItem(@PathVariable Long id,@PathVariable  Integer cantidad){
	return itemService.findById(id,cantidad);
};

public Item metodoAlternativo(Long id, Integer cantidad) {
	Item item = new Item();
	Producto producto = new Producto();
	item.setCantidad(cantidad);
	producto.setId(id);
	producto.setNombre("Sony");
	producto.setPrecio(500.000);
	item.setProducto(producto);
	
	return item;
	
}


	
}
