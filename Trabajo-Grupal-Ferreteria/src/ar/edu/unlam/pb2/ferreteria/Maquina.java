package ar.edu.unlam.pb2.ferreteria;

import ar.edu.unlam.pb2.interfaces.Devolvible;

public class Maquina extends Producto implements Devolvible{
	
	private Double pesoKg;
	private Integer watts;
	 private static final Double IVA = 0.21;
	
	public Maquina(String descripcion, String marca, Double precio, Double pesoKg, Integer watts) {
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

	public Integer getWatts() {
		return watts;
	}

	public void setWatts(Integer watts) {
		this.watts = watts;
	}
	
	public void resetearContador() {
		setContadorId(1);
	}

	@Override
	public Boolean esDevolbible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		return this.getPrecio()+(this.getPrecio()*IVA);
	}

	
	
	
	

}
