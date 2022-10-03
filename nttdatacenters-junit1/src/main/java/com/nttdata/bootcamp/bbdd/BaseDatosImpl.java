package com.nttdata.bootcamp.bbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.nttdata.bootcamp.model.Articulo;

@Service
public class BaseDatosImpl implements BaseDatosI {

	private Map<Integer, Articulo> baseDatos = new HashMap<>();
	
	@Override
	public void iniciarBBDD() {
		// TODO Auto-generated method stub
		baseDatos.put(1, new Articulo("Pantalón", 20));
		baseDatos.put(2, new Articulo("Camisa", 20));
		baseDatos.put(3, new Articulo("Sueter", 20));
		baseDatos.put(4, new Articulo("Jabón", 20));
	}

	@Override
	public List<Articulo> getArticulos() {
		// TODO Auto-generated method stub
		List<Articulo> listArticulos = new ArrayList<>();
		
		for(Map.Entry<Integer, Articulo> entry : baseDatos.entrySet()) {
			listArticulos.add(entry.getValue());
		}
		return listArticulos;
	}

	@Override
	public Articulo getArticuloById(Integer id) {
		// TODO Auto-generated method stub
		if (baseDatos.get(id) != null) {
			return baseDatos.get(id);
		}
		
		return null;
	}

	@Override
	public int insertNewArticulo(Articulo newArticulo) {
		// TODO Auto-generated method stub
		baseDatos.put(baseDatos.size() + 1, newArticulo);
		
		return baseDatos.size()+1;
	}

}
