package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.ferreteria.Pintura;

public class test {
	
	@Test
	public void DadoQueExisteUnaFerreteriaYSeAgregaUnProducto() {
		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("pintura", "lokepinte", 200.0, "rojo", 10.0);
		ferreteria.registrarProducto(pintura);
		
		assertEquals(ferreteria.getProducto().size(), 1);
	}

}
