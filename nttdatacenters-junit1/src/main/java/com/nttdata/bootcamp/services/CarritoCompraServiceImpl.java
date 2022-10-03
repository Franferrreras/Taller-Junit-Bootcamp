package com.nttdata.bootcamp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.bbdd.BaseDatosI;
import com.nttdata.bootcamp.model.Articulo;
@Service
public class CarritoCompraServiceImpl implements CarritoCompraServiceI {

	private List<Articulo> cesta = new ArrayList<>();
	
	@Autowired
	private BaseDatosI baseDatos;
	
	@Override
	public void limpiarCesta() {
		cesta.clear();
		
	}

	@Override
	public void addArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		cesta.add(articulo);
	}

	@Override
	public int getNumArticulo() {
		// TODO Auto-generated method stub
		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		// TODO Auto-generated method stub
		return cesta;
	}

	@Override
	public double totalPrice() {
		double total = 0;
		for (Articulo a : cesta) {
			total += a.getPrice();
		}
		
		return total;
	}

	@Override
	public double calculadorDescuento(double precio, double porcentajeDescuento) {
		// TODO Auto-generated method stub
		
		return precio * (100 - porcentajeDescuento)/100;
	}

	@Override
	public List<Articulo> getArticulosBaseDatos() {
		// TODO Auto-generated method stub
		return baseDatos.getArticulos();
	}

	@Override
	public double aplicarDescuentoArticuloDB(Integer id, int porcentajeDescuento) {
		// TODO Auto-generated method stub
		baseDatos.iniciarBBDD();
		return this.calculadorDescuento(baseDatos.getArticuloById(id).getPrice(), porcentajeDescuento);
	}

	@Override
	public void insertarArticuloDB(Articulo newArticulo) {
		//Inserta un nuevo articulo a la cesta
		this.addArticulo(baseDatos.getArticuloById(baseDatos.insertNewArticulo(newArticulo)));
	}

	@Override
	public void addArticoById(Integer id) {
		// TODO Auto-generated method stub
		cesta.add(baseDatos.getArticuloById(id));
	}

	
}
