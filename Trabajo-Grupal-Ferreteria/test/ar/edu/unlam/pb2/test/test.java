package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdABuscarException;
import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdAEliminarException;
import ar.edu.unlam.pb2.ferreteria.Ferreteria;
import ar.edu.unlam.pb2.ferreteria.Herramienta;
import ar.edu.unlam.pb2.ferreteria.Maquina;
import ar.edu.unlam.pb2.ferreteria.Pintura;

public class test {
	@Test
	public void DadoQueExisteUnaFerreteriaYSeAgregaUnProducto() {
		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("pintura", "lokepinte", 200.0, "rojo", 10.0);
		ferreteria.registrarProducto(pintura);
		
		assertEquals(ferreteria.getProducto().size(), 1);
	}
	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeAgregaUnProductoConCodigoRepetidoEntoncesSeLanzaUnaExcepcion() {

	}
	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeBuscaUnProductoExistenteEntoncesSeObtieneElProducto() {

	}
	@Test (expected = NoExisteProductoConElIdABuscarException.class)
	public void DadoQueExisteUnaFerreteriaYBuscaUnProductoInexistenteEntoncesSeLanzaUnaExcepcion() throws NoExisteProductoConElIdABuscarException {
		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("deBalde", "lokepinte", 200.0, "azul", 10.0);
		pintura.resetearContador();
		ferreteria.registrarProducto(pintura);
		ferreteria.buscarProductoPorIdEnLaLista("P2");
	}
	
	@Test 
	public void DadoQueExisteUnaFerreteriaYSeEliminaUnProductoDeLaListaSeEliminaCorrectamente() throws NoExisteProductoConElIdABuscarException, NoExisteProductoConElIdAEliminarException {
//		Ferreteria ferreteria = new Ferreteria();
//		Herramienta herramienta = new Herramienta("pico", "pick", 1000.0, "manual", "hierro");
//		ferreteria.registrarProducto(herramienta);
//		
//		ferreteria.buscarProductoPorIdEnLaLista("H3");  //verifica que el producto fue agregado a la lista y existe en la misma
//		
//		ferreteria.borrarProductoPorIdEnLaLista("H3");  //borra el producto
//		
	}
	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeIntentaEliminarUnProductoInexistenteEntoncesSeLanzaUnaExcepcion() {

	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeRegistranProductosEntoncesNoSePermitenDuplicados() {
	}

	@Test
	public void DadoQueExisteUnaFerreteriaSeDevuelveUnaListaOrdenadaPorDescripcion() {
		Ferreteria ferreteria = new Ferreteria();   
		Maquina maquina = new Maquina("taladro", "laburo", 200.0, 2.0, 15.5);
		maquina.resetearContador();  //no sirve tener este metodo en la clase padre 'Producto', serviria si estuviese en 'Ferreteria', si alguien sabe como hacerlo
		ferreteria.registrarProducto(maquina);
		Pintura pintura = new Pintura("balde", "pinturillo", 200.0, "naranja", 5.0);
		ferreteria.registrarProducto(pintura);
		Herramienta herramienta = new Herramienta("hacha", "hachaxd", 199.0, "manual", "madera");
		ferreteria.registrarProducto(herramienta);
		
		ferreteria.listaOrdenadaPorDescripcion(); 
		assertTrue(ferreteria.listaOrdenadaPorDescripcion().first().getDescripcion() == "balde");
		assertTrue(ferreteria.listaOrdenadaPorDescripcion().last().getDescripcion() == "taladro");
		//Si tienen una mejor forma de hacer algun metodo o alguna manera de hacerlos mas simples Q LO HAGA
		//      -testamento de AngelDeidad(antes de quedarme sin luz, adios amigos)
	}
	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeRegistraUnProductoConPrecioNegativoEntoncesSeLanzaUnaExcepcion() {
	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeConsultaLaCantidadDeProductosEntoncesSeObtieneLaCantidadCorrecta() {

	}
