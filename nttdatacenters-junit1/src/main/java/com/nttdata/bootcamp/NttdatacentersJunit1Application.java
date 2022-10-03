package com.nttdata.bootcamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.bootcamp.bbdd.BaseDatosI;
import com.nttdata.bootcamp.model.Articulo;
import com.nttdata.bootcamp.services.CarritoCompraServiceI;

@SpringBootApplication
public class NttdatacentersJunit1Application implements CommandLineRunner {

	@Autowired
	BaseDatosI baseDatos;
	
	@Autowired
	CarritoCompraServiceI carritoService;
	
	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersJunit1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		baseDatos.iniciarBBDD();
		List<Articulo> listArticulos = baseDatos.getArticulos();
//		System.out.println(baseDatos.insertNewArticulo(new Articulo("camisa",20.00))); 
//		System.out.println(baseDatos.getArticulos());
		
		carritoService.addArticulo(baseDatos.getArticuloById(baseDatos.insertNewArticulo(new Articulo("camisaNegra",20.00))));
		System.out.println(baseDatos.getArticulos());
		
	}

}
