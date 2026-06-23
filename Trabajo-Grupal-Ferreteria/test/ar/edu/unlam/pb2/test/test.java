package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.ferreteria.Ferreteria;
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

	public void dadoQueExisteUnaFerreteriaCuandoSeBuscaUnProductoInexistenteEntoncesSeLanzaUnaExcepcion() {

	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeEliminaUnProductoExistenteEntoncesElProductoSeEliminaCorrectamente() {

	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeIntentaEliminarUnProductoInexistenteEntoncesSeLanzaUnaExcepcion() {

	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeRegistranProductosEntoncesNoSePermitenDuplicados() {
	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeObtienenLosProductosEntoncesSeDevuelvenOrdenadosPorNombre() {
	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeRegistraUnProductoConPrecioNegativoEntoncesSeLanzaUnaExcepcion() {
	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeConsultaLaCantidadDeProductosEntoncesSeObtieneLaCantidadCorrecta() {

	}
}
