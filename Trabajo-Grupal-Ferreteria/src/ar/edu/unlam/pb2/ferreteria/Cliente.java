package ar.edu.unlam.pb2.ferreteria;

public class Cliente {
private Integer id_cliente;
private String nombre;
private String apellido;
private Integer dni;
private Integer contador=1;
public Cliente( String nombre, String apellido, Integer dni) {
	this.id_cliente = contador++;
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
}
public Integer getId_cliente() {
	return id_cliente;
}
public void setId_cliente(Integer id_cliente) {
	this.id_cliente = id_cliente;
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
