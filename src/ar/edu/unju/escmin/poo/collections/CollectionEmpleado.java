package ar.edu.unju.escmin.poo.collections;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.elements.Empleado;

public abstract class CollectionEmpleado {
	
	public static Set <Empleado> empleados;
	public static Set<Empleado> getEmpleados(){
		if(empleados == null || empleados.isEmpty()) {
			empleados = new TreeSet<Empleado>();
		}
		return empleados;
	}
	public static void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
//	public static Set <FacturaEncabezado> facturas;
//	public static Set<FacturaEncabezado> getFacturas(){
//		if(facturas == null || facturas.isEmpty()) {
//			facturas = new TreeSet<FacturaEncabezado>();
//		}
//		return facturas;
//		
//	}
}
