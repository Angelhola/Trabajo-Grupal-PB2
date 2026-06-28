package ar.edu.unlam.pb2.ferreteria;

public class Venta {

	private static Integer contadorId = 1;
	private Integer id;
	private Cliente cliente;

	private Producto productoVendido;

	public Venta(Integer id, Cliente cliente, Producto productoVendido) {
		this.id = id;
		this.cliente = cliente;
		this.productoVendido = productoVendido;
	}

	public Venta(Cliente cliente, Producto productoVendido) {
		this.id = contadorId++;
		this.cliente = cliente;
		this.productoVendido = productoVendido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProductoVendido() {
		return productoVendido;
	}

	public void setProductoVendido(Producto productoVendido) {
		this.productoVendido = productoVendido;
	}

}
