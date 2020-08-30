package com.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.springboot.app.productos.models.entity.*;
public interface ProductoRepository extends CrudRepository<Producto,Long> {

}
