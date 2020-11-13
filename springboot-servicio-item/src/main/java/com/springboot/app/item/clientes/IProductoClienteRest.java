package com.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.springboot.servicio.item.models.Producto;

@FeignClient(name = "servicio-productos")
public interface IProductoClienteRest {
	
	
	@GetMapping("/producto/listar")
	public List<Producto> listar();
	
	@GetMapping("/producto/{id}")		
	public Producto detalle(@PathVariable(value="id") Long id);

	
}
