package com.springboot.servicio.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.springboot.app.item.clientes.IProductoClienteRest;
import com.springboot.servicio.item.models.Item;


@Service("serviceFeing")

public  class ItemServiceFeing implements ItemService {
	
	@Autowired
	private IProductoClienteRest productoFeing;

	@Override
	public List<Item> findAll() {
		
		return productoFeing.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new Item(productoFeing.detalle(id),cantidad) ;
	}


}
