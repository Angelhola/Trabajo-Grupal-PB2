package ar.edu.unlam.pb2.ferreteria;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdABuscarException;
import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdAEliminarException;

public class Ferreteria {

	TreeSet<Producto> productos;
	TreeMap<Integer, Cliente> clientes;
	TreeMap<Integer, Venta> ventas;

	public Ferreteria() {
		this.productos = new TreeSet<>();
		this.clientes=new TreeMap<>();
		this.ventas=new TreeMap<>();
	}

	public TreeSet<Producto> getProductos() {
		return productos;
	}

	public void setProductos(TreeSet<Producto> productos) {
		this.productos = productos;
	}

	public TreeMap<Integer, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(TreeMap<Integer, Cliente> clientes) {
		this.clientes = clientes;
	}

	public TreeMap<Integer, Venta> getVentas() {
		return ventas;
	}

	public void setVentas(TreeMap<Integer, Venta> ventas) {
		this.ventas = ventas;
	}

	//metodos
	
	public Boolean registrarProducto(Producto producto)
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException {
		if (producto.getPrecio() < 0) {
			throw new NoSePuedeAsignarPrecioNegativoException("No se puede poner precio negativo");
		}
		for (Producto productoo : productos) {
			if (productoo.getId().equals(producto.getId())) {
				throw new NoSePuedeRegistrarCodigosDuplicadosException("No Se Puede Registrar Codigos Duplicados");
			}

		}
		return productos.add(producto);

	}

	public Producto buscarProductoPorIdEnLaLista(String id) throws NoExisteProductoConElIdABuscarException {
		for (Producto p : productos) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		throw new NoExisteProductoConElIdABuscarException("No se encontro algun producto existente con este id");
	}

	public Boolean borrarProductoPorIdEnLaLista(String id) throws NoExisteProductoConElIdAEliminarException {
		Producto productoAEliminar = null;
		for (Producto p : productos) {
			if (p.getId().equals(id)) {
				productoAEliminar = p;
				break;
			}
		}
		if (productoAEliminar == null) {
			throw new NoExisteProductoConElIdAEliminarException("No se encontro el producto buscado para eliminar");
		}
		return this.productos.remove(productoAEliminar);
	}

	public TreeSet<Producto> listaOrdenadaPorDescripcion() {
		TreeSet<Producto> productosOrdenados = new TreeSet<>(Comparator.comparing(Producto::getDescripcion)); // relacionado
																												// con
																												// 'Comparator'
		productosOrdenados.addAll(this.productos);
		return productosOrdenados;
	}

	public void agregarCliente(Cliente cliente) throws NoSePuedeRegistrarClienteSiYaEstaRegistradoException {
		// TODO Auto-generated method stub
		if (clientes.containsKey(cliente.getId())) {
			throw new NoSePuedeRegistrarClienteSiYaEstaRegistradoException(
					"No se puede registrar cliente si ya esta registrado");
		}
		for (Cliente clienteExistente : clientes.values()) {
	        if (clienteExistente.getDni().equals(cliente.getDni())) {
	            throw new NoSePuedeRegistrarClienteSiYaEstaRegistradoException(
	                    "No se puede registrar cliente: El DNI ya está registrado.");
	        }}
		clientes.put(cliente.getId(), cliente);
	}

}
