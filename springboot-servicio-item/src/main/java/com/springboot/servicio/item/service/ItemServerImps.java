package com.springboot.servicio.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.servicio.item.models.Item;import com.springboot.servicio.item.models.Producto;

@Service
public class ItemServerImps implements ItemService {
	@Autowired
	private RestTemplate resttemplate;
	@Override
	public List<Item> findAll() {
		List<Producto> productos =Arrays.asList(resttemplate.getForObject("http://localhost:8080/producto/listar", Producto[].class)) ;
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id",id.toString());
		
		Producto producto = resttemplate.getForObject("http://localhost:8080/producto/{id}",Producto.class,pathVariables);
		
		return new Item(producto,cantidad);
	}

}
