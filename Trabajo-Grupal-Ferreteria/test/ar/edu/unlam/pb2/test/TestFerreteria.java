package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdABuscarException;
import ar.edu.unlam.pb2.exceptions.NoExisteProductoConElIdAEliminarException;
import ar.edu.unlam.pb2.exceptions.NoSeEncontroClienteBuscadoException;
import ar.edu.unlam.pb2.exceptions.NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException;
import ar.edu.unlam.pb2.exceptions.NoSePuedeAgregarVentaSinProductoException;
import ar.edu.unlam.pb2.exceptions.NoSePuedeAgregarVentaconIdYaExistentException;
import ar.edu.unlam.pb2.exceptions.NoSePuedeAsignarPrecioNegativoException;
import ar.edu.unlam.pb2.exceptions.NoSePuedeDevolverProductoException;
import ar.edu.unlam.pb2.exceptions.NoSePuedeRegistrarClienteSiYaEstaRegistradoException;
import ar.edu.unlam.pb2.exceptions.NoSePuedeRegistrarCodigosDuplicadosException;
import ar.edu.unlam.pb2.exceptions.NoSePuedenVenderProductosSinStockException;
import ar.edu.unlam.pb2.ferreteria.Cliente;
import ar.edu.unlam.pb2.ferreteria.Ferreteria;
import ar.edu.unlam.pb2.ferreteria.Herramienta;
import ar.edu.unlam.pb2.ferreteria.Maquina;
import ar.edu.unlam.pb2.ferreteria.Pintura;
import ar.edu.unlam.pb2.ferreteria.Venta;

public class TestFerreteria {

	@Test
	public void DadoQueExisteUnaFerreteriaYSeAgregaUnProductoSeRegistraCorrectamente()  //1
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException {
		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("pintura", "lokepinte", 200.0, "rojo", 10.0);
		ferreteria.registrarProducto(pintura);

		assertEquals(ferreteria.getProductos().size(), 1);
	}

	@Test(expected = NoSePuedeRegistrarCodigosDuplicadosException.class)  //2
	public void dadoQueExisteUnaFerreteriaCuandoSeAgregaUnProductoConCodigoRepetidoEntoncesSeLanzaUnaExcepcion()
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException {
		Ferreteria ferreteria = new Ferreteria();
		Herramienta herramienta = new Herramienta("martillo", "bremen", 12.00, "domestico", "hierro");
		String id = herramienta.getId();
		ferreteria.registrarProducto(herramienta);
		Herramienta herramienta2 = new Herramienta("martillo", "stanley", 12.00, "domestico", "hierro");
		herramienta2.setId(id);
		ferreteria.registrarProducto(herramienta2);
	}

	@Test  //3
	public void dadoQueExisteUnaFerreteriaCuandoSeBuscaUnProductoExistenteEntoncesSeObtieneElProducto()
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoExisteProductoConElIdABuscarException,
			NoSePuedeAsignarPrecioNegativoException {
		Ferreteria ferreteria = new Ferreteria();
		Herramienta cajaDeTubos = new Herramienta("caja de tubos", "stanley", 18.00, "profesional", "bronce");
		ferreteria.registrarProducto(cajaDeTubos);
		ferreteria.buscarProductoPorIdEnLaLista(cajaDeTubos.getId());

	}

	@Test(expected = NoExisteProductoConElIdABuscarException.class)  //4
	public void DadoQueExisteUnaFerreteriaYBuscaUnProductoInexistenteEntoncesSeLanzaExcepcion()
			throws NoExisteProductoConElIdABuscarException, NoSePuedeRegistrarCodigosDuplicadosException,
			NoSePuedeAsignarPrecioNegativoException {
		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("deBalde", "lokepinte", 200.0, "azul", 10.0);
		pintura.resetearContador();
		ferreteria.registrarProducto(pintura);
		ferreteria.buscarProductoPorIdEnLaLista("P2");
	}

	@Test
	public void DadoQueExisteUnaFerreteriaYSeEliminaUnProductoDeLaLista()   //5
			throws NoExisteProductoConElIdABuscarException, NoExisteProductoConElIdAEliminarException, NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException {
			Ferreteria ferreteria = new Ferreteria();
			Herramienta herramienta = new Herramienta("pico", "pick", 1000.0, "manual", "hierro");
			ferreteria.registrarProducto(herramienta);
	
			ferreteria.buscarProductoPorIdEnLaLista("H8");  //verifica que el producto fue agregado a la lista y existe en la misma
			
			ferreteria.borrarProductoPorIdEnLaLista("H8");  //borra el producto
			
	}

	@Test
	public void DadoQueExisteUnaFerreteriaSeDevuelveUnaListaOrdenadaPorDescripcion()  //6
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException {
		Ferreteria ferreteria = new Ferreteria();
		Maquina maquina = new Maquina("taladro", "laburo", 200.0, 2.0, 1000);
		maquina.resetearContador();
		ferreteria.registrarProducto(maquina);
		Pintura pintura = new Pintura("balde", "pinturillo", 200.0, "naranja", 5.0);
		ferreteria.registrarProducto(pintura);
		Herramienta herramienta = new Herramienta("hacha", "hachaxd", 199.0, "manual", "madera");
		ferreteria.registrarProducto(herramienta);

		ferreteria.listaOrdenadaPorDescripcion();
		assertTrue(ferreteria.listaOrdenadaPorDescripcion().first().getDescripcion().equals("balde"));
		assertTrue(ferreteria.listaOrdenadaPorDescripcion().last().getDescripcion().equals("taladro"));
	}

	@Test(expected = NoSePuedeAsignarPrecioNegativoException.class)   //7
	public void dadoQueExisteUnaFerreteriaCuandoSeRegistraUnProductoConPrecioNegativoEntoncesSeLanzaUnaExcepcion()
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException {
		Ferreteria ferreteria = new Ferreteria();
		Maquina maquina = new Maquina("Rotopercutor", "nebraska", (-12.99), 1.5, 800);
		ferreteria.registrarProducto(maquina);
	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoAgregoUnCLienteSeRegistraCorrectamente()   //8
			throws NoSePuedeRegistrarClienteSiYaEstaRegistradoException {
		Ferreteria ferreteria = new Ferreteria();
		Cliente cliente = new Cliente("victor", "fernandez", 12136789);
		ferreteria.agregarCliente(cliente);
		assertEquals(1, ferreteria.getClientes().size(), 0.01);
	}

	@Test(expected = NoSePuedeRegistrarClienteSiYaEstaRegistradoException.class)    //9
	public void dadoQueExisteUnaFerreteriaNoSePermitaAgregarClienteConElMismoDni()
			throws NoSePuedeRegistrarClienteSiYaEstaRegistradoException {
		Ferreteria ferreteria = new Ferreteria();
		Cliente cliente = new Cliente("victor", "fernandez", 12136789);
		ferreteria.agregarCliente(cliente);
		Cliente cliente2 = new Cliente("Mirtha", "Hernandez", 12136789);
		ferreteria.agregarCliente(cliente2);
	}

	@Test      //10
	public void dadoQueExisteUnaFerreteriaCuandoBuscoClientePorIdLoObtengo() throws NoSePuedeRegistrarClienteSiYaEstaRegistradoException, NoSeEncontroClienteBuscadoException {
Ferreteria ferreteria = new Ferreteria();
Cliente cliente= new Cliente("Geronimo","Benavides",12136789);
ferreteria.agregarCliente(cliente);
Cliente cliente2= new Cliente("Ariana","Mbappe",12136900);
ferreteria.agregarCliente(cliente2);
Cliente IdclienteBuscado=ferreteria.buscarClientePorID(cliente2.getId());
assertEquals(cliente2.getId(),IdclienteBuscado.getId(),0.01);
	}

	@Test(expected = NoSeEncontroClienteBuscadoException.class)  //11
	public void dadoQueExisteUnaFerreteriaCuandoBuscoUnClienteInexistenteEntoncesSeLanzaUnaExcepcion() throws NoSeEncontroClienteBuscadoException {
		Ferreteria ferreteria = new Ferreteria();
		ferreteria.buscarClientePorID(9);
	}

	
	public void dadoQueExisteUnaFerreteriaSeRegistraUnaVentaCorrectamente()  //12
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException,
			NoSePuedeAgregarVentaconIdYaExistentException, NoSePuedeRegistrarClienteSiYaEstaRegistradoException,
			NoSePuedenVenderProductosSinStockException, NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException, NoSePuedeAgregarVentaSinProductoException {
		Ferreteria ferreteria = new Ferreteria();

		Herramienta herramienta = new Herramienta("taladro", "black and decker", 12.00, "domestico", "acero");
		ferreteria.registrarProducto(herramienta);
		Cliente cliente = new Cliente("Leonardo", "Mechi", 46789807);
		ferreteria.agregarCliente(cliente);
		Venta venta = new Venta(cliente, herramienta);
		ferreteria.agregarVenta(venta);
	}

	@Test    //13
	public void dadoQueExisteUnaFerreteriaSeObtienenClientesOrdenadosPorDNI()
			throws NoSePuedeRegistrarClienteSiYaEstaRegistradoException  {
		Ferreteria ferreteria = new Ferreteria();
		Cliente cliente1 = new Cliente("Ana", "Lopez", 11121211);
	    Cliente cliente2 = new Cliente("Bruno", "Garcia", 22524272);
	    Cliente cliente3 = new Cliente("Carlos", "Perez", 313635433);
	    
	    ferreteria.agregarCliente(cliente1);
	    ferreteria.agregarCliente(cliente2);
	    ferreteria.agregarCliente(cliente3);
	    List<Cliente> ordenados = new ArrayList<>(ferreteria.getClientesOrdenadosPorDni().values());
	    assertEquals(cliente1.getDni(), ordenados.get(0).getDni()); 
	    assertEquals(cliente2.getDni(), ordenados.get(1).getDni()); 
	    assertEquals(cliente3.getDni(), ordenados.get(2).getDni()); 

	}

	@Test       //14
	public void dadoQueExisteUnaFerreteriaSeObtienenVentasOrdenadas() 
			throws NoSePuedeRegistrarClienteSiYaEstaRegistradoException,
			NoSePuedeAgregarVentaconIdYaExistentException,
			NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException, 
			NoSePuedeAgregarVentaSinProductoException, NoSePuedenVenderProductosSinStockException {
		Ferreteria ferreteria = new Ferreteria();
	    Cliente cliente = new Cliente("Ana", "Lopez", 11111111);
	    ferreteria.agregarCliente(cliente);
	    Herramienta producto1 = new Herramienta("Martillo", "Stanley", 1500.0, "Manual", "Acero");
	    Herramienta producto2 = new Herramienta("Llave", "Bahco", 800.0, "Manual", "Hierro");
	    Herramienta producto3 = new Herramienta("Destornillador", "Philips", 300.0, "Manual", "Acero");
	    
	    Venta venta = new Venta(3, cliente, producto1);
	    Venta venta2 = new Venta(1, cliente, producto2);
	    Venta venta3 = new Venta(2, cliente, producto3);
	    
	    ferreteria.agregarVenta(venta);
	    ferreteria.agregarVenta(venta2);
	    ferreteria.agregarVenta(venta3);
	    
	    List<Venta> ventas = new ArrayList<>(ferreteria.getVentas().values());
	    assertEquals(venta2.getId(), ventas.get(0).getId()); 
	    assertEquals(venta3.getId(), ventas.get(1).getId()); 
	    assertEquals(venta.getId(), ventas.get(2).getId()); 

	}

	@Test (expected = NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException.class)     //15
	public void dadoQueExisteUnaFerreteriaNoSePermiteVentaSiElClienteNoEstaRegistrado() 
			throws NoSePuedeAgregarVentaconIdYaExistentException, 
    NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException, NoSePuedeAgregarVentaSinProductoException, NoSePuedenVenderProductosSinStockException {
		Ferreteria ferreteria = new Ferreteria();
		Cliente cliente = new Cliente("Ana", "Lopez", 11111111); 
		Herramienta producto1 = new Herramienta("Martillo", "Stanley", 1500.0, "Manual", "Acero");
	    
	    Venta venta1 = new Venta(1, cliente, producto1);
	    
	    ferreteria.agregarVenta(venta1);
		

	}

	@Test (expected = NoSePuedeAgregarVentaconIdYaExistentException.class)      //16
	public void dadoQueExisteUnaFerreteriaCuandoSeRegistraVentaaConElMismoCodigoEntoncesSeLanzaUnaExcepcion()  
			throws NoSePuedeAgregarVentaconIdYaExistentException,
    NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException,
    NoSePuedeRegistrarClienteSiYaEstaRegistradoException, NoSePuedeAgregarVentaSinProductoException, 
    NoSePuedenVenderProductosSinStockException{
		
		 Ferreteria ferreteria = new Ferreteria();
	     Cliente cliente = new Cliente("Ana", "Lopez", 11111111);
		 ferreteria.agregarCliente(cliente);
		    
		 Herramienta producto1 = new Herramienta("Martillo", "Stanley", 1500.0, "Manual", "Acero");
		 Herramienta producto2 = new Herramienta("Martillo", "Stanley", 1500.0, "Manual", "Acero");

		 Venta v1 = new Venta(1, cliente, producto1);
		 Venta v2 = new Venta(1, cliente, producto2);
		 
		 ferreteria.agregarVenta(v1);
		 ferreteria.agregarVenta(v2);
		
	}

	@Test(expected = NoSePuedenVenderProductosSinStockException.class)    //17
	public void dadoQueExisteUnaFerreteriaCuandoSeVendeUnProductoSinStockEntoncesSeLanzaUnaExcepcion()
			throws NoSePuedenVenderProductosSinStockException, NoSePuedeAgregarVentaconIdYaExistentException,
			NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException,
			NoSePuedeRegistrarClienteSiYaEstaRegistradoException, NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException, NoSePuedeAgregarVentaSinProductoException {

		Ferreteria ferreteria = new Ferreteria();
		Herramienta herramienta = new Herramienta("martillo", "stanley", 12.00, "domestico", "hierro");

		herramienta.setStock(0);
		ferreteria.registrarProducto(herramienta);

		Cliente cliente = new Cliente("Juan", "Perez", 12345678);
		ferreteria.agregarCliente(cliente);

		Venta venta = new Venta(cliente, herramienta);
		ferreteria.agregarVenta(venta);
	}

	@Test (expected = NoSePuedeAgregarVentaSinProductoException.class)     //18
	public void dadoQueExisteUnaFerreteriaCuandoSeRegistraUnaVentaSinProductosEntoncesSeLanzaUnaExcepcion() 
			throws NoSePuedeAgregarVentaconIdYaExistentException,
    NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException,
    NoSePuedeRegistrarClienteSiYaEstaRegistradoException,
    NoSePuedeAgregarVentaSinProductoException, NoSePuedenVenderProductosSinStockException {
		
		 Ferreteria ferreteria = new Ferreteria();
		  Cliente cliente = new Cliente("Ana", "Lopez", 11224411);
		 ferreteria.agregarCliente(cliente);
		 Venta venta1 = new Venta(1, cliente, null);
		 ferreteria.agregarVenta(venta1);

	}

	@Test(expected = NoSeEncontroClienteBuscadoException.class)   //19
	public void dadoQueExisteUnaFerreteriaCuandoBuscoUnClienteInexistenteEntoncesSeLanzaUnaExcepcion1()
			throws NoSePuedeRegistrarClienteSiYaEstaRegistradoException, NoSeEncontroClienteBuscadoException {
		Ferreteria ferreteria = new Ferreteria();
		Cliente cliente = new Cliente("Juan", "Perez", 12345678);
		ferreteria.buscarClientePorID(cliente.getId());
	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeDevuelveUnProductoEntoncesElStockAumenta()       //20
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException,
			NoSePuedeAgregarVentaconIdYaExistentException, NoSePuedeRegistrarClienteSiYaEstaRegistradoException,
			NoSePuedenVenderProductosSinStockException, NoSePuedeDevolverProductoException, NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException, NoSePuedeAgregarVentaSinProductoException {

		Ferreteria ferreteria = new Ferreteria();
		Herramienta herramienta = new Herramienta("martillo", "stanley", 12.00, "domestico", "hierro");

		ferreteria.registrarProducto(herramienta);
		Cliente cliente = new Cliente("Juan", "Perez", 12345678);
		ferreteria.agregarCliente(cliente);

		Venta venta = new Venta(cliente, herramienta);
		ferreteria.agregarVenta(venta);

		Integer stockAntes = herramienta.getStock();
		ferreteria.procesarDevolucion(venta);
		assertEquals(stockAntes + 1, (int) herramienta.getStock());
	}

	@Test(expected = NoSePuedeDevolverProductoException.class)     //21
	public void dadoQueExisteUnaFerreteriaCuandoSeDevuelveUnaPinturaEntoncesSeLanzaExcepcion()
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException,
			NoSePuedeAgregarVentaconIdYaExistentException, NoSePuedeRegistrarClienteSiYaEstaRegistradoException,
			NoSePuedenVenderProductosSinStockException, NoSePuedeDevolverProductoException, NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException, NoSePuedeAgregarVentaSinProductoException {

		Ferreteria ferreteria = new Ferreteria();
		Pintura pintura = new Pintura("pintura", "lokepinte", 200.0, "rojo", 10.0);
		ferreteria.registrarProducto(pintura);

		Cliente cliente = new Cliente("Juan", "Perez", 12345678);
		ferreteria.agregarCliente(cliente);

		Venta venta = new Venta(cliente, pintura);
		ferreteria.agregarVenta(venta);
		ferreteria.procesarDevolucion(venta);
	}

	@Test
	public void dadoQueExisteUnaFerreteriaCuandoSeDevuelveUnProductoLaVentaSeElimina()          //23
			throws NoSePuedeRegistrarCodigosDuplicadosException, NoSePuedeAsignarPrecioNegativoException,
			NoSePuedeAgregarVentaconIdYaExistentException, NoSePuedeRegistrarClienteSiYaEstaRegistradoException,
			NoSePuedenVenderProductosSinStockException, NoSePuedeDevolverProductoException, NoSePuedeAgregarVentaSiElClienteNoEstaRegistradoException, NoSePuedeAgregarVentaSinProductoException {
		Ferreteria ferreteria = new Ferreteria();
		Herramienta herramienta = new Herramienta("martillo", "stanley", 12.00, "domestico", "hierro");

		ferreteria.registrarProducto(herramienta);
		Cliente cliente = new Cliente("Juan", "Perez", 12345678);
		ferreteria.agregarCliente(cliente);

		Venta venta = new Venta(cliente, herramienta);
		ferreteria.agregarVenta(venta);
		ferreteria.procesarDevolucion(venta);

		assertEquals(0, ferreteria.getVentas().size());
	}

}
