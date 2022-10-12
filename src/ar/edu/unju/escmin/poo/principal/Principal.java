package ar.edu.unju.escmin.poo.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

import ar.edu.unju.escmin.poo.collections.CollectionCliente;
import ar.edu.unju.escmin.poo.collections.CollectionEmpleado;
import ar.edu.unju.escmin.poo.collections.CollectionFactura;
import ar.edu.unju.escmin.poo.collections.CollectionProducto;
import ar.edu.unju.escmin.poo.collections.CollectionStock;
import ar.edu.unju.escmin.poo.elements.AgenteAdministrativo;
import ar.edu.unju.escmin.poo.elements.Cliente;
import ar.edu.unju.escmin.poo.elements.ClienteMayorista;
import ar.edu.unju.escmin.poo.elements.ClienteMinorista;
import ar.edu.unju.escmin.poo.elements.Detalle;
import ar.edu.unju.escmin.poo.elements.Empleado;
import ar.edu.unju.escmin.poo.elements.EncargadoVentas;
import ar.edu.unju.escmin.poo.elements.FacturaEncabezado;
import ar.edu.unju.escmin.poo.elements.Producto;
import ar.edu.unju.escmin.poo.elements.Stock;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int op = 0;
		String newLine = System.getProperty("line.separator");
		int j=0;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		int answer = 0;
		boolean terminar = false;
		Optional<Stock> existe = Optional.empty();
		Optional<Producto> existeProducto = Optional.empty();
		Optional<FacturaEncabezado> existeFactura = Optional.empty();
		boolean encontradoProducto = false;
		CollectionProducto.getProductos();
		CollectionFactura.getFacturas();
		CollectionCliente.getClientes();
		CollectionStock.getStock();
		CollectionEmpleado.getEmpleados();
		AgenteAdministrativo administrativo = (AgenteAdministrativo)CollectionEmpleado.empleados.stream().filter(e -> e.getCargo().equals("Administrativo")).findFirst().get();
	    EncargadoVentas encargadoVentas=(EncargadoVentas)CollectionEmpleado.empleados.stream().filter(e->e.getCargo().equals("Encargado")).findFirst().get();
		do {
			System.out.println("+*+*+*+*+*+*+*  Menu  +*+*+*+*+*+*+*");
			System.out.println("1. Crear un producto");
			System.out.println("2. Cargar Stock de producto");
			System.out.println("3. Realizar Venta");
			System.out.println("*********  Encargado de Ventas  *********");
			System.out.println("4. Verificar Stock de producto");
			System.out.println("5. Mostrar total de ventas");
			System.out.println("6. Mostrar todas las ventas");
			System.out.println("*********  Cliente  *********");
			System.out.println("7. Buscar Factura por codigo");
			op=scan.nextInt();
			switch(op) {
		case 1:
			AgenteAdministrativo.altaProducto();
				break;
			case 2:
				AgenteAdministrativo.cargarStock();
				break;
			case 3:
				AgenteAdministrativo.realizarVenta();
				break;
			case 4:
				System.out.println("Ingrese el codigo del producto");
				int codig = scan.nextInt();
				encargadoVentas.verificarStock(codig);
				break;
			case 5:
				double total;
				total = encargadoVentas.totalVentas(CollectionFactura.facturas);
				System.out.println("El total de las ventas es: " + total);
				break;
			case 6:
				encargadoVentas.mostrarVentas(CollectionFactura.facturas);
				break;
			case 7:
				FacturaEncabezado fact = new FacturaEncabezado();
				System.out.println("Ingrese el codigo de la factura que esta buscando");
				int code = scan.nextInt();
				fact = CollectionFactura.buscarFacturaPorCodigo(code);
				if(fact!= null) {
					System.out.println("Numero: " + fact.getNumeroFactura() + "                             .... Fecha ..../ " + fact.getFecha());
					System.out.println("N y A: " + fact.getCliente().getNombre()+ " " +fact.getCliente().getApellido() + "  DNI:" + fact.getCliente().getDni());
					System.out.println("Nombre Producto                            Descripcion                    Cantidad                     Importe");
					System.out.println("_________________________________________________________________"+ newLine); 
					fact.mostrarDetalle();
					System.out.println("_________________________________________________________________");
					System.out.println("                                        Subtotal: "+ fact.getSubtotal());
					System.out.println("_________________________________________________________________");
					System.out.println(                                         "Total: " + fact.getTotal());
				}
				break;
				
			}
			
		}while(op!=13);
		
	}
	  boolean isInstanceOf(Empleado empleado, Class<?> clazz){
		    boolean minorista = clazz.isAssignableFrom(empleado.getClass());
		    return minorista;
		    }


	    public static boolean isInstanceOf2(Empleado emp, Class<?> clazz){
	    	boolean mayorista = clazz.isAssignableFrom(emp.getClass());
	        return mayorista;}
}
