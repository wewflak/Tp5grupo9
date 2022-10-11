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
import ar.edu.unju.escmin.poo.elements.FacturaEncabezado;
import ar.edu.unju.escmin.poo.elements.Producto;
import ar.edu.unju.escmin.poo.elements.Stock;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int op = 0;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		int answer = 0;
		boolean terminar = false;
		Optional<Stock> existe = Optional.empty();
		CollectionProducto.getProductos();
		CollectionFactura.getFacturas();
		CollectionCliente.getClientes();
		CollectionStock.getStock();
		CollectionEmpleado.getEmpleados();
		Detalle detalle = new Detalle();
		Stock stock = new Stock();
		FacturaEncabezado factura = new FacturaEncabezado();
		do {
			System.out.println("+*+*+*+*+*+*+*  Menu  +*+*+*+*+*+*+*");
			System.out.println("1. Crear un empleado");
			System.out.println("2. Crear un cliente");
			System.out.println("3. Crear un producto");
			System.out.println("4. Realizar Venta");
			System.out.println("5. Verificar Stock de producto");
			System.out.println("6. Cargar Stock de producto");
			System.out.println("7. Buscar Factura por codigo");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
			op=scan.nextInt();
			switch(op) {
			case 1:
					AgenteAdministrativo employee = new AgenteAdministrativo();
					System.out.println("Ingrese el nombre del empleado");
					employee.setNombre(scan.next());
					System.out.println("Ingrese el apellido del empleado");
					employee.setApellido(scan.next());
					System.out.println("Ingrese el dni del empleado");
					employee.setDni(scan.nextLong());
					System.out.println("Ingrese el legajo del empleado");
					employee.setLegajo(scan.nextLong());
					System.out.println("Ingrese el cargo del empleado");
					employee.setCargo(scan.next());
					System.out.println("Ingrese el domicilio del empleado");
					employee.setDomicilio(scan.next());
					CollectionEmpleado.agregarEmpleado(employee);
					Iterator<Empleado> it = CollectionEmpleado.empleados.iterator();
					while (it.hasNext()) {						it.next().toString();}
				break;
			
			case 2:
				ClienteMinorista client = new ClienteMinorista();
				
				System.out.println("Ingrese el Nombre del Cliente");
				client.setNombre(scan.next());
				System.out.println("Ingrese el Apellido del Cliente");
				client.setApellido(scan.next());
				System.out.println("Ingrese el DNI del Cliente");
				client.setDni(scan.nextLong());
				System.out.println("Ingrese el Domicilio del Cliente");
				client.setDomicilio(scan.next());
				System.out.println("Ingrese el Codigo de PAMI del Cliente");
				client.setCodPami(scan.nextLong());
			break;
			case 3:
				Producto prod = new Producto();
				System.out.println("ingrese el codigo: ");
				prod.setCodigo(scan.nextInt());	
				System.out.println("ingrese el nombre del producto: ");
				prod.setNombre(scan.next());
				System.out.println("ingrese la descripcion: ");
				prod.setDescripcion(scan.next());
				System.out.println("ingrese el precio unitario: ");
				prod.setPrecioUnitario(scan.nextDouble());
				System.out.println("ingrese el descuento del producto: ");
				prod.setDescuento(scan.nextInt());
				CollectionProducto.agregarProducto(prod);
				break;
			case 4:
				System.out.println("Ingrese el numero de dni del cliente");
			long documento = scan.nextLong();
				Cliente cli = CollectionCliente.buscarCliente(documento);
					if(cli instanceof ClienteMinorista) {
						System.out.println("---------_Factura_--------");
						System.out.println("Ingrese el numero de factura");
						factura.setNumeroFactura(scan.nextInt());
						System.out.println("Ingrese la fecha de la factura");
						String fecha = scan.next();
						LocalDate date = LocalDate.parse(fecha);
						factura.setFecha(date);
						factura.setCliente(cli);
							while(answer!=2){
							Scanner respuesta = new Scanner(System.in);
							System.out.println("Ingrese el producto comprado por el cliente");
							Producto product = CollectionProducto.buscarProductoPorCodigo(scan.nextInt());
							stock = CollectionStock.buscarStockPorCodigo(product.getCodigo());
							if(product != null && stock != null) {
							detalle.setProducto(product);
							System.out.println("Cuantos de estos productos son comprados");
							detalle.setCantidad(scan.nextInt());
							if(detalle.getCantidad() > stock.getCantidad()) {
								System.out.println("La cantidad ingresada es mayor a la disponible");
							}else {
							CollectionStock.decrementarStockDeProducto(product.getCodigo(), detalle.getCantidad());
							factura.agregarDetalle(detalle);
							}}
							
							System.out.println("Quiere agregar mas productos? no=2");
							answer = respuesta.nextInt();
							if(answer == 2) {terminar=true;}
							}

							System.out.println(factura.getDetalles().get(0).getProducto().getNombre());
							System.out.println(factura.calcularTotal(factura.getDetalles()));
						//Calculardescuento
						factura.getDetalles().stream().forEach(d -> System.out.println(d.getProducto().getNombre() + " |||| " + d.getCantidad() + " _-_-_ " + d.calcularImporte()));
						System.out.println(factura.toString());
					}else if(cli instanceof ClienteMayorista) {
						System.out.println("---------_Factura_--------");
						System.out.println("Ingrese el numero de factura");
						factura.setNumeroFactura(scan.nextInt());
						System.out.println("Ingrese la fecha de la factura");
						String fecha = scan.next();
						LocalDate date = LocalDate.parse(fecha);
						factura.setFecha(date);
						factura.setCliente(cli);
							while(answer!=2){
							Scanner respuesta = new Scanner(System.in);
							System.out.println("Ingrese el producto comprado por el cliente");
							Producto product = CollectionProducto.buscarProductoPorCodigo(scan.nextInt());
							stock = CollectionStock.buscarStockPorCodigo(product.getCodigo());
							if(product != null && stock != null) {
							detalle.setProducto(product);
							System.out.println("Cuantos de estos productos son comprados");
							detalle.setCantidad(scan.nextInt());
							if(detalle.getCantidad() > stock.getCantidad()) {
								System.out.println("La cantidad ingresada es mayor a la disponible");
							}else {
							CollectionStock.decrementarStockDeProducto(product.getCodigo(), detalle.getCantidad());
							factura.agregarDetalle(detalle);
							}}
							System.out.println("Quiere agregar mas productos? no=2");
							answer = respuesta.nextInt();
							if(answer == 2) {terminar=true;}
							}
								System.out.println(factura.getDetalles().get(0).getProducto().getNombre());
							
							System.out.println(factura.calcularTotal(factura.getDetalles()));
						//Calculardescuento
						factura.getDetalles().stream().forEach(d -> System.out.println(d.getProducto().getNombre() + " |||| " + d.getCantidad() + " _-_-_ " + d.calcularImporte()));
						
					}
				break;
			case 5:
				System.out.println("Ingrese el codigo del producto");
				int code = scan.nextInt();
				stock = CollectionStock.buscarStockPorCodigo(code);
				if(stock != null) {
					System.out.println("El stock del producto es: " + stock.getCantidad());
				}
				break;
			case 6:
				System.out.println("Crear stock de producto");
				System.out.println("Ingresar el codigo del producto");
				code= scan.nextInt();
				Producto product = CollectionProducto.buscarProductoPorCodigo(code);
				existe = CollectionStock.buscarStock(code);
				if(product != null && existe.isEmpty()) {
					stock.setProd(product);
					CollectionStock.agregarStockDeProducto(stock);
					System.out.println("Cuantos productos va agregar al stock");
					int cant = scan.nextInt();
					CollectionStock.incrementarStockDeProducto(product.getCodigo(), cant);
				} 
				if(existe.isPresent()) {
					System.out.println("El producto ya tiene un stock creado");
				}
				break;
			case 7:
				System.out.println("Ingrese el codigo de la factura que esta buscando");
				code = scan.nextInt();
				CollectionFactura.buscarFacturaPorCodigo(code);
				if(factura!= null) {
					System.out.println(factura.toString());
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
