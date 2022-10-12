package ar.edu.unju.escmin.poo.elements;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.collections.CollectionStock;

public class EncargadoVentas extends Empleado implements Comparable<Empleado>  {

	public EncargadoVentas(String nombre, String apellido, String domicilio, Long dni, Long legajo, String cargo) {
		super(nombre, apellido, domicilio, dni, legajo, cargo);
		// TODO Auto-generated constructor stub
	}
	public EncargadoVentas() {
		// TODO Auto-generated constructor stub
	}
	public void mostrarVentas(Set<FacturaEncabezado> facturas) {
		for (FacturaEncabezado fact : facturas) {
			System.out.println("Numero: " + fact.getNumeroFactura() + "                             .... Fecha ..../ " + fact.getFecha());
			System.out.println("N y A: " + fact.getCliente().getNombre()+ " " + fact.getCliente().getApellido() + "  DNI:" + fact.getCliente().getDni());
			System.out.println("Nombre Producto                            Descripcion                    Cantidad                     Importe");
			System.out.println("_________________________________________________________________"); 
			fact.mostrarDetalle();
			System.out.println("_________________________________________________________________");
			System.out.println("                                        Subtotal: "+ fact.getSubtotal());
			System.out.println("_________________________________________________________________");
			System.out.println(                                         "Total: " + fact.getTotal());
		}
	}
	public double totalVentas(Set<FacturaEncabezado> facturas) {

		double venta=0;
		Iterator<FacturaEncabezado> it = facturas.iterator();
		while (it.hasNext()) {
			venta += it.next().calcularTotal();
		}
		
		
		return venta;
		
	}

	public void verificarStock(int codigo) {
		Stock stock = CollectionStock.buscarStockPorCodigo(codigo);
		if(stock!=null) {
		System.out.println("La cantidad de stock del producto es: " + stock.getCantidad());
		}else {
			System.out.println("No tiene stock");
		}
	}
	@Override
	public int compareTo(Empleado o) {
		// TODO Auto-generated method stub
		return 0;
	}

}