package ar.edu.unlam.pb2.ferreteria;

public class NoSePuedeAgregarVentaSinProductoException extends Exception {
	
	public NoSePuedeAgregarVentaSinProductoException(String mensaje) {
        super(mensaje);
    }
	
	
}
