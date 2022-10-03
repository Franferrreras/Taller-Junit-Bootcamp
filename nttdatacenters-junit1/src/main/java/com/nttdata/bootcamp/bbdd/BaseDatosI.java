package com.nttdata.bootcamp.bbdd;

import java.util.List;

import com.nttdata.bootcamp.model.Articulo;

public interface BaseDatosI {

	public void iniciarBBDD();
	
	public List<Articulo> getArticulos();
	
	public Articulo getArticuloById(final Integer id);
	
	public int insertNewArticulo(final Articulo newArticulo);
}
