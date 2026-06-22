package ar.edu.unlam.pb2.ferreteria;

public class Producto implements Comparable<Producto>{
	
	private static Integer contadorId = 1;
	private String id;
	private String descripcion;
	private String marca;
	private Double precio;
	private String prefijo;
	
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

	@Override
	public int compareTo(Producto o) {
		return this.id.compareTo(o.getId());
	}
	
	
	
	
	

}
