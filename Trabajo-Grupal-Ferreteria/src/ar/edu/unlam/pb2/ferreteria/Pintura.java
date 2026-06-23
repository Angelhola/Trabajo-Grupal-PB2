package ar.edu.unlam.pb2.ferreteria;

public class Pintura extends Producto {
	
	private String color;
	private Double litros;
	
	public Pintura(String descripcion, String marca, Double precio, String color, Double litros) {
		super(descripcion, marca, precio, "P");
		this.color = color;
		this.litros = litros;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getLitros() {
		return litros;
	}

	public void setLitros(Double litros) {
		this.litros = litros;
	}
	
	public void resetearContador() {
		setContadorId(1);
	}
	
	
	

}
