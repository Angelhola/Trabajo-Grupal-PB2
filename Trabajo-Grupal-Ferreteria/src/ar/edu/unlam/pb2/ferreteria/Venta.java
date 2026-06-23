package ar.edu.unlam.pb2.ferreteria;

public class Venta {
	
	private static Integer contadorId = 1;
	private Integer id;
	private Cliente cliente;
	private Producto productoVendido;
	
	public Venta(Integer id, Cliente cliente, Producto productoVendido) {
		this.id = contadorId++;
		this.cliente = cliente;
		this.productoVendido = productoVendido;
	}
	
	
}
