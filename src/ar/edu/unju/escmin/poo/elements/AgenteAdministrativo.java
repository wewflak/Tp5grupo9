package ar.edu.unju.escmin.poo.elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import ar.edu.unju.escmin.poo.collections.CollectionCliente;
import ar.edu.unju.escmin.poo.collections.CollectionFactura;
import ar.edu.unju.escmin.poo.collections.CollectionProducto;
import ar.edu.unju.escmin.poo.collections.CollectionStock;

public class AgenteAdministrativo extends Empleado implements Comparable<Empleado> {

	public AgenteAdministrativo() {
		// TODO Auto-generated constructor stub
	}
	
	public AgenteAdministrativo(String nombre, String apellido, String domicilio, Long dni, Long legajo, String cargo) {
		super(nombre, apellido, domicilio, dni, legajo, cargo);
		// TODO Auto-generated constructor stub
	}
	public static void altaProducto() {
		Scanner scan = new Scanner(System.in);
		int answer = 0;
		Optional<Producto> existeProducto = Optional.empty();
		boolean encontradoProducto = false;
		CollectionProducto.getProductos();
		String nom =" ", desc=" ";
		double pr=0;
		int des=0, cod=0;
		boolean band=false;
		//while(band!=true) {
		System.out.println("Ingrese el codigo: ");
		cod = scan.nextInt();	
		existeProducto = CollectionProducto.buscarProducto(cod);
		if(existeProducto.isPresent()) {System.out.println("El producto ya fue cargado"); band=true;}else {
		System.out.println("Ingrese el nombre del producto: ");
		nom = scan.next();
		System.out.println("Ingrese la descripcion: ");
		desc = scan.next();
		System.out.println("Ingrese el precio unitario: ");
		pr = scan.nextDouble();
		System.out.println("Ingrese el descuento del producto: ");
		des = scan.nextInt();

		Producto prod = new Producto(cod, nom, desc, pr, des);
		CollectionProducto.agregarProducto(prod);
		}
	}
	public static void cargarStock() {
		Scanner scan = new Scanner(System.in);
		int answer = 0;
		Optional<Stock> existe = Optional.empty();
		Stock registro = new Stock();
		System.out.println("Crear stock de producto");
		System.out.println("Ingresar el codigo del producto");
		int code= scan.nextInt();
		Producto product =  new Producto();
		product = CollectionProducto.buscarProductoPorCodigo(code);
		existe = CollectionStock.buscarStock(code);
		if(product != null && existe.isEmpty()) {
			registro.setProd(product);
			System.out.println("Cuantos productos va agregar al stock");
			int cant = scan.nextInt();

			CollectionStock.agregarStockDeProducto(registro);
			CollectionStock.incrementarStockDeProducto(product.getCodigo(), cant);
		} 
		if(existe.isPresent()) {
			System.out.println("El producto ya tiene un stock creado");
		}
	}
	public static void realizarVenta() {
		Scanner scan = new Scanner(System.in);
		int op = 0;
		String newLine = System.getProperty("line.separator");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		int answer = 0;
		boolean terminar = false;
		Optional<Producto> existeProducto = Optional.empty();
		Optional<FacturaEncabezado> existeFactura = Optional.empty();
		boolean encontradoProducto = false;
		System.out.println("Ingrese el numero de dni del cliente");
	long documento = scan.nextLong();
		FacturaEncabezado factura = new FacturaEncabezado();
		Cliente cli = CollectionCliente.buscarCliente(documento);
			if(cli instanceof ClienteMinorista) {
				System.out.println("---------_Factura_--------");
				System.out.println("Ingrese el numero de factura");

				int codig = scan.nextInt();
				factura.setNumeroFactura(codig);
				existeFactura = CollectionFactura.buscarFactura(codig);
				if(existeFactura.isPresent()) {System.out.println("La factura ya existe");}else {
				System.out.println("Ingrese la fecha de la factura [dd/mm/aaaa]");
				String fecha = scan.next();
				LocalDate date = LocalDate.parse(fecha, formato);
				factura.setFecha(date);
				factura.setCliente(cli);
				answer=0;
					while(answer!=2){
					Scanner respuesta = new Scanner(System.in);
					System.out.println("Ingrese el producto comprado por el cliente");
					Producto produc = CollectionProducto.buscarProductoPorCodigo(scan.nextInt());
					Stock stock = CollectionStock.buscarStockPorCodigo(produc.getCodigo());
					encontradoProducto = factura.comprobarExistencia(produc);		
					if(produc != null && stock != null && encontradoProducto != true) {
					Detalle detalle = new Detalle();	
					detalle.setProducto(produc);
					System.out.println("Cuantos de estos productos son comprados");
					detalle.setCantidad(scan.nextInt());
					if(detalle.getCantidad() > stock.getCantidad()) {
						System.out.println("La cantidad ingresada es mayor a la disponible");
					}else {
					CollectionStock.decrementarStockDeProducto(produc.getCodigo(), detalle.getCantidad());
					factura.agregarDetalle(detalle);
					System.out.println(detalle.getProducto().getNombre());
					}}else if(encontradoProducto==true) {
						System.out.println("El producto ya existe en la factura");
					}
					
					System.out.println("Quiere agregar mas productos? no=2");
					answer = respuesta.nextInt();
					if(answer == 2) {terminar=true;}
					}

					factura.setSubtotal(factura.calcularSubtotal());
					factura.setTotal(factura.calcularTotal());
					CollectionFactura.agregarFactura(factura);
					System.out.println("Numero: " + factura.getNumeroFactura() + "                             .... Fecha ..../ " + factura.getFecha());
					System.out.println("N y A: " + factura.getCliente().getNombre()+ " " +factura.getCliente().getApellido() + "  DNI:" + factura.getCliente().getDni());
					System.out.println("Nombre Producto                            Descripcion                    Cantidad                     Importe");
					System.out.println("_________________________________________________________________"+ newLine); 
					factura.mostrarDetalle();
					System.out.println("_________________________________________________________________");
					System.out.println("                                        Subtotal: "+ factura.getSubtotal());
					System.out.println("_________________________________________________________________");
					System.out.println(                                         "Total: " + factura.getTotal());
			}
			
			}else if(cli instanceof ClienteMayorista) {
				System.out.println("---------_Factura_--------");
				System.out.println("Ingrese el numero de factura");
				int codig = scan.nextInt();
				factura.setNumeroFactura(codig);
				existeFactura = CollectionFactura.buscarFactura(codig);
				if(existeFactura.isPresent()) {System.out.println("La factura ya existe");}else {
				System.out.println("Ingrese la fecha de la factura [dd/mm/aaaa]");
				String fecha = scan.next();
				LocalDate date = LocalDate.parse(fecha, formato);
				factura.setFecha(date);
				factura.setCliente(cli);
				answer=0;
					while(answer!=2){
					Scanner respuesta = new Scanner(System.in);
					System.out.println("Ingrese el producto comprado por el cliente");
					Producto produc = CollectionProducto.buscarProductoPorCodigo(scan.nextInt());
					Stock stock = CollectionStock.buscarStockPorCodigo(produc.getCodigo());
					if(produc != null && stock != null) {
					Detalle detalle = new Detalle();	
					detalle.setProducto(produc);
					System.out.println("Cuantos de estos productos son comprados");
					detalle.setCantidad(scan.nextInt());
					if(detalle.getCantidad() > stock.getCantidad()) {
						System.out.println("La cantidad ingresada es mayor a la disponible");
					}else if(detalle.getCantidad() %10 !=0){
						System.out.println("Los productos deben ser comprados en paquetes de 10");
					}else {
					CollectionStock.decrementarStockDeProducto(produc.getCodigo(), detalle.getCantidad());
					factura.agregarDetalle(detalle);
					}}
					System.out.println("Quiere agregar mas productos? no=2");
					answer = respuesta.nextInt();
					if(answer == 2) {terminar=true;}
					}
					factura.setSubtotal(factura.calcularSubtotal());
					factura.setTotal(factura.calcularTotal());
					CollectionFactura.agregarFactura(factura);
					System.out.println("Numero: " + factura.getNumeroFactura() + "                             .... Fecha ..../ " + factura.getFecha());
					System.out.println("N y A: " + factura.getCliente().getNombre()+ " " +factura.getCliente().getApellido() + "  DNI:" + factura.getCliente().getDni());
					System.out.println("Nombre Producto                            Descripcion                    Cantidad                     Importe");
					System.out.println("_________________________________________________________________"+ newLine); 
					factura.mostrarDetalle();
					System.out.println("_________________________________________________________________");
					System.out.println("                                        Subtotal: "+ factura.getSubtotal());
					System.out.println("_________________________________________________________________");
					System.out.println(                                         "Total: " + factura.getTotal());
			}
			}
	}
	@Override
	public int compareTo(Empleado o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "AgenteAdministrativo [nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", dni=" + dni + ", legajo=" + legajo + ", cargo=" + cargo + "]";
	}
	
}
