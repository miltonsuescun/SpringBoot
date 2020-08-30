package com.springboot.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.productos.models.entity.Producto;
import com.springboot.app.productos.models.service.IProductoService;
import com.springboot.app.productos.models.service.ProductoServiceImpl;

@RestController
public class ProductoContoller {
	
	@Autowired
	private ProductoServiceImpl productoService;
	@GetMapping("/producto/listar")
	public List<Producto> listar(){
		return productoService.findAll();
			};
	@GetMapping("/producto/{id}")		
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
			};

	

}
