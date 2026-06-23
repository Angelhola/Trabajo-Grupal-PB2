package ar.edu.unlam.pb2.ferreteria;

import java.util.Comparator;
import java.util.TreeSet;

import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdABuscarException;
import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdAEliminarException;

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
	
	public Producto buscarProductoPorIdEnLaLista(String id) throws NoExisteProductoConElIdABuscarException {
		for (Producto p : producto) {
			if (p.getId().equals(id)) {
			   return p;
			}
		}
		throw new NoExisteProductoConElIdABuscarException("No se encontro algun producto existente con este id");
	}
	
	public Boolean borrarProductoPorIdEnLaLista(String id) throws NoExisteProductoConElIdAEliminarException {
		Producto productoAEliminar = null;
		for (Producto p : producto) {
			if (p.getId().equals(id)) {
				productoAEliminar = p;
				break;
			}
		} 
		if (productoAEliminar == null) {
			throw new NoExisteProductoConElIdAEliminarException("No se encontro el producto buscado para eliminar");
		}
		return this.producto.remove(productoAEliminar);
	}
	
	public TreeSet<Producto> listaOrdenadaPorDescripcion() {
		TreeSet<Producto> productosOrdenados = new TreeSet<>(Comparator.comparing(Producto::getDescripcion));   //relacionado con 'Comparator'
		productosOrdenados.addAll(this.producto);
		return productosOrdenados;
	}
	

	
	

}
