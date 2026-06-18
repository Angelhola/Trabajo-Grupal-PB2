package ar.edu.unlam.pb2.test;

import java.util.TreeSet;

import ar.edu.unlam.pb2.ferreteria.Producto;

public class Ferreteria{

	TreeSet<Producto> producto;
	
	public Ferreteria() {
		this.producto = new TreeSet<>();
	}

	public TreeSet<Producto> getProducto() {
		return producto;
	}

	public void setProducto(TreeSet<Producto> producto) {
		this.producto = producto;
	}
	
	public Boolean registrarProducto(Producto producto) {
		return this.producto.add(producto);
	}

	
	

}
