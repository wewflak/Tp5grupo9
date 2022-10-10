package ar.edu.unju.escmin.poo.principal;

import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.escmin.poo.collections.CollectionCliente;
import ar.edu.unju.escmin.poo.collections.CollectionEmpleado;
import ar.edu.unju.escmin.poo.collections.CollectionFactura;
import ar.edu.unju.escmin.poo.collections.CollectionProducto;
import ar.edu.unju.escmin.poo.collections.CollectionStock;
import ar.edu.unju.escmin.poo.elements.AgenteAdministrativo;
import ar.edu.unju.escmin.poo.elements.ClienteMinorista;
import ar.edu.unju.escmin.poo.elements.Empleado;
import ar.edu.unju.escmin.poo.elements.Producto;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int op = 0;
		CollectionProducto.getProductos();
		CollectionFactura.getFacturas();
		CollectionCliente.getClientes();
		CollectionStock.getStock();
		CollectionEmpleado.getEmpleados();
		do {
			System.out.println("+*+*+*+*+*+*+*  Menu  +*+*+*+*+*+*+*");
			System.out.println("1. Crear un empleado");
			System.out.println("2. Crear un cliente");
			System.out.println("3. Crear un producto");
			System.out.println("4. Realizar Venta");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
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
					employee.toString();
					CollectionEmpleado.agregarEmpleado(employee);
					employee.toString();
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
				CollectionCliente.agregarCliente(client);
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
			

				
			}
			
		}while(op!=13);
		
	}

}