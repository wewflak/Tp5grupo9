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
		//Empleado employee = empleados.stream().filter(e -> e.getDni() == empleado.getDni()).findFirst().get();
		//if(employee.equals(null)) {
			empleados.add(empleado);
			System.out.println("Fue guardado");
		//}else {
			//System.out.println("El empleado ya esta registrado");
		//}
	}
	
	//public static Stock buscarStockPorCodigo(int codigo) {
//	Stock product = registro.stream().filter(p -> p.getProd().getCodigo() == codigo).findFirst().get();
//	return product;
//}
}
