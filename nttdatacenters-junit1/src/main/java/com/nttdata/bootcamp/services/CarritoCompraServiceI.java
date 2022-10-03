package com.nttdata.bootcamp.services;

import java.util.List;

import com.nttdata.bootcamp.model.Articulo;

public interface CarritoCompraServiceI {

	public void limpiarCesta();
	
	public void addArticulo(Articulo articulo);
	
	public int getNumArticulo();
	
	public List<Articulo> getArticulos();
	
	public double totalPrice();
	
	public double calculadorDescuento(double precio, double porcentajeDescuento);
	
	public List<Articulo> getArticulosBaseDatos();
	
	public double aplicarDescuentoArticuloDB(Integer id, int porcentajeDescuento);
	
	public void insertarArticuloDB(final Articulo newArticulo);
	
	public void addArticoById(final Integer id);
	
}
