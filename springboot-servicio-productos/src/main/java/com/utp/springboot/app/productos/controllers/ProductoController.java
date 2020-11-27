package com.utp.springboot.app.productos.controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.utp.springboot.app.productos.models.entity.Producto;
import com.utp.springboot.app.productos.models.service.IProductoService;
@RestController
public class ProductoController {
@Value("${server.port}")
private Integer port;

@Autowired
private IProductoService productoService;
@GetMapping("/listar")
public List<Producto> listar(){
	return productoService.findAll().stream().map(producto ->{
		producto.setPort(port);
		return producto;
	}).collect(Collectors.toList());
	
}
@GetMapping("/ver/{id}")
 public Producto detalle(@PathVariable Long id) {
	Producto producto = productoService.findById(id);
	producto.setPort(port);
	return producto;
	 
 }


}
