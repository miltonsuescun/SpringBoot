package com.springboot.app.productos.models.service;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.productos.models.dao.ProductoRepository;
import com.springboot.app.productos.models.entity.Producto;
 @Service
public class ProductoServiceImpl implements IProductoService {
	 
	@Autowired
	ProductoRepository productorepo;
	 
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>)productorepo.findAll();
	}

	@Override
	@Transactional
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return productorepo.findById(id).orElse(null);
	}

}
