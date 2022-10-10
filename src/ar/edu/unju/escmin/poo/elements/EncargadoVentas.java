package ar.edu.unju.escmin.poo.elements;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class EncargadoVentas extends Empleado implements Comparable<Empleado>  {

	public EncargadoVentas(String nombre, String apellido, String domicilio, Long dni, Long legajo, String cargo) {
		super(nombre, apellido, domicilio, dni, legajo, cargo);
		// TODO Auto-generated constructor stub
	}
	public void mostrarVentas(TreeSet<FacturaEncabezado> facturas) {

		Iterator<FacturaEncabezado> it = facturas.iterator();
		while (it.hasNext()) {
			it.next().toString();
		}
		
	}
	public double totalVentas(TreeSet<FacturaEncabezado> facturas) {

		double venta=0;
		Iterator<FacturaEncabezado> it = facturas.iterator();
		while (it.hasNext()) {
			venta = venta + it.next().calcularTotal();
		}
		
		
		return venta;
		
	}
	@Override
	public int compareTo(Empleado o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
