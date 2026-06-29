package ar.edu.unlam.pb2.ferreteria;

import java.util.Comparator;
import java.util.Objects;

public abstract class Producto implements Comparable<Producto>, Comparator{
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
	}

	private static Integer contadorId = 1;
	private String id;
	private String descripcion;
	private String marca;
	private Double precio;
	private String prefijo;
	private Integer stock = 10;
	
	public Producto(String descripcion, String marca, Double precio, String prefijo) {
		            //P          //1
		this.id = prefijo + (contadorId++);
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.prefijo = prefijo;
	
	}

	public static Integer getContadorId() {
		return contadorId;
	}

	public static void setContadorId(Integer contadorId) {
		Producto.contadorId = contadorId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Boolean estaEnStock() {
		return stock > 0;
	}

	@Override
	public int compareTo(Producto o) {
		return this.id.compareTo(o.getId());
	}

	@Override
	public int compare(Object o1, Object o2) {       //compara descripciones y las ordena
		Producto p1 = (Producto) o1;
		Producto p2 = (Producto) o2;
		p1.getDescripcion().compareTo(p2.getDescripcion());
		return 0;
	}
	
	
	
	
	

}
