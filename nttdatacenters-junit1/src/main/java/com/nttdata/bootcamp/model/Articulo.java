package com.nttdata.bootcamp.model;

public class Articulo {

	private String name;
	
	private double price;

	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Articulo(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Articulo [name=" + name + ", price=" + price + "]";
	}
	
}
