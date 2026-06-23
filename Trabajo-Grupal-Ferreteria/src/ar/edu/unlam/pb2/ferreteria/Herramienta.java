package ar.edu.unlam.pb2.ferreteria;

public class Herramienta extends Producto {
	
	private String tipoDeUso;
	private String material;
	
	public Herramienta(String descripcion, String marca, Double precio, String tipoDeUso,
			String material) {
		super(descripcion, marca, precio, "H");
		this.tipoDeUso = tipoDeUso;
		this.material = material;
	}

	public String getTipoDeUso() {
		return tipoDeUso;
	}

	public void setTipoDeUso(String tipoDeUso) {
		this.tipoDeUso = tipoDeUso;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void resetearContador() {
		setContadorId(1);
	}


	
	
	
	

}
