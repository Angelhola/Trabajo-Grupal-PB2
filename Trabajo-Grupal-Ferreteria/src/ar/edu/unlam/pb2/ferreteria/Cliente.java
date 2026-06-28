package ar.edu.unlam.pb2.ferreteria;

public class Cliente {
private Integer id;
private String nombre;
private String apellido;
private Integer dni;
private Integer contador=1;
public Cliente( String nombre, String apellido, Integer dni) {
	this.id = contador++;
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public Integer getDni() {
	return dni;
}
public void setDni(Integer dni) {
	this.dni = dni;
}
public Integer getContador() {
	return contador;
}
public void setContador(Integer contador) {
	this.contador = contador;
}

}
