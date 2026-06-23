package ar.edu.unlam.pb2.ferreteria;

public class Maquina extends Producto {
	
	private Double pesoKg;
	private Double watts;
	
	public Maquina(String descripcion, String marca, Double precio, Double pesoKg, Double watts) {
		super(descripcion, marca, precio, "M");
		this.pesoKg = pesoKg;
		this.watts = watts;
	}

	public Double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(Double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public Double getWatts() {
		return watts;
	}

	public void setWatts(Double watts) {
		this.watts = watts;
	}
	
	public void resetearContador() {
		setContadorId(1);
	}

	
	
	
	

}
