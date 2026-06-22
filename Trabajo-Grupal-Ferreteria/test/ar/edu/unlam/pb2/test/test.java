package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdABuscarException;
import ar.edu.unlam.pb2.ferreteria.Pintura;

public class test {
	//1- Dado que existe una ferretería, cuando se agrega un producto, entonces se registra correctamente.
	@Test
	public void DadoQueExisteUnaFerreteriaYSeAgregaUnProducto() {
		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("pintura", "lokepinte", 200.0, "rojo", 10.0);
		ferreteria.registrarProducto(pintura);
		
		assertEquals(ferreteria.getProducto().size(), 1);
	}

	//2- Dado que existe una ferretería, cuando se agrega un producto con código repetido, entonces se lanza una excepción
	//3- Dado que existe una ferretería, cuando se busca un producto existente, entonces se obtiene el producto.
	//4- Dado que existe una ferretería, cuando se busca un producto inexistente, entonces se lanza una excepción.
	@Test (expected = NoExisteProductoConElIdABuscarException.class)
	public void DadoQueExisteUnaFerreteriaYBuscaUnProductoInexistente() throws NoExisteProductoConElIdABuscarException {
		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("pintura", "lokepinte", 200.0, "rojo", 10.0);
		ferreteria.registrarProducto(pintura);
		ferreteria.buscarProductoPorIdEnLaLista("P2");
	}
	//5- Dado que existe una ferretería, cuando se elimina un producto existente, entonces el producto se elimina correctamente.
	//6- Dado que existe una ferretería, cuando se intenta eliminar un producto inexistente, entonces se lanza una excepción.
	//7- Dado que existe una ferretería, cuando se registran productos, entonces no se permiten duplicados.
	//8- Dado que existe una ferretería, cuando se obtienen los productos, entonces se devuelven ordenados por nombre.
	//9- Dado que existe una ferretería, cuando se registra un producto con precio negativo, entonces se lanza una excepción.
	//10- Dado que existe una ferretería, cuando se consulta la cantidad de productos, entonces se obtiene la cantidad correcta.
}
