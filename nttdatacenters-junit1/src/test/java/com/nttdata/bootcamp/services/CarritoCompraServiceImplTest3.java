package com.nttdata.bootcamp.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nttdata.bootcamp.bbdd.BaseDatosI;
import com.nttdata.bootcamp.model.Articulo;

@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceImplTest3 {

	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();

	@Mock
	private BaseDatosI baseDatos;

	@Test
	public void testLimpiarCesta() {
		carritoService.limpiarCesta();
		assertTrue(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testAddArticulo() {
		carritoService.addArticulo(new Articulo("Shampoo", 4.99));
		assertFalse(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testGetNumArticulo() {
		carritoService.addArticulo(new Articulo("Shampoo", 4.99));
		carritoService.addArticulo(new Articulo("Camisa", 15.99));
		assertEquals(2, carritoService.getNumArticulo());
	}

	@Test
	public void testGetArticulos() {
		carritoService.addArticulo(new Articulo("Shampoo", 4.99));
		carritoService.addArticulo(new Articulo("Camisa", 15.99));
		List<Articulo> listArticulo = carritoService.getArticulos();

		assertEquals(2, carritoService.getNumArticulo());
		assertEquals("Camisa", listArticulo.get(1).getName());
	}

	@Test
	public void testTotalPrice() {
		carritoService.addArticulo(new Articulo("Shampoo", 4.99));
		carritoService.addArticulo(new Articulo("Camisa", 15.99));

		assertEquals(20.98, carritoService.totalPrice());
	}

	@Test
	public void testCalculadorDescuento() {
		carritoService.addArticulo(new Articulo("Shampoo", 5));
		carritoService.addArticulo(new Articulo("Camisa", 15));

		assertEquals(18, carritoService.calculadorDescuento(carritoService.totalPrice(), 10), 0);
	}
	
	@Test
	public void testGetArticulosBaseDatos() {
		List<Articulo> lista = new ArrayList<>();
		lista.add(new Articulo("Sueter",15D));
		lista.add(new Articulo("Camisa",25D));
		lista.add(new Articulo("Pantalonr",35D));
		lista.add(new Articulo("Jersei",18D));
		when(baseDatos.getArticulos()).thenReturn(lista);
		List<Articulo> listado = carritoService.getArticulosBaseDatos();
		assertEquals(4, listado.size());
	}
	
	@Test
	public void testaplicarDescuentoArticuloDB() {
		
		Articulo articulo = new Articulo("Camiseta", 20.00);
		
		when(baseDatos.getArticuloById(any(Integer.class))).thenReturn(articulo);
		double res = carritoService.aplicarDescuentoArticuloDB(1, 50);
		assertEquals(10, res);
		verify(baseDatos).getArticuloById(any(Integer.class));
	}
	
	@Test
    public void testAplicarDescuento() {
        Articulo articulo = new Articulo("Camiseta", 9.8);
        when(baseDatos.getArticuloById(any(Integer.class))).thenReturn(articulo);
        Double res = carritoService.calculadorDescuento(baseDatos.getArticuloById(any(Integer.class)).getPrice(), 10);
        assertEquals(8.82, res, 0);
        verify(baseDatos).getArticuloById(any(Integer.class));
    }
	
	@Test
	public void testInsertarArticuloDB() {
		Articulo articulo = new Articulo("Camiseta", 20.00);
	}
	
	@Test
	public void testAddArticuloById() {
		Articulo articulo = new Articulo("Coche Juguete", 20.00);
		when(baseDatos.insertNewArticulo(any(Articulo.class))).thenReturn(1);
		when(baseDatos.getArticuloById(any(Integer.class))).thenReturn(articulo);

		carritoService.addArticoById(baseDatos.insertNewArticulo(articulo));
		assertEquals(1, baseDatos.insertNewArticulo(articulo));
		
		List<Articulo> list = carritoService.getArticulos();
		assertTrue(list.contains(articulo));
//		verify(carritoService).addArticoById(baseDatos.insertNewArticulo(articulo));
	}


}
