package ar.edu.unju.escmin.poo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.elements.AgenteAdministrativo;
import ar.edu.unju.escmin.poo.elements.Empleado;
import ar.edu.unju.escmin.poo.elements.EncargadoVentas;

public abstract class CollectionEmpleado {
	
	public static List <Empleado> empleados;
	public static List<Empleado> getEmpleados(){
		if(empleados == null || empleados.isEmpty()) {
			empleados = new ArrayList<Empleado>();
			empleados.add(new EncargadoVentas("aaa", "ppp", "asdasd", (long) 4444, (long) 4141, "Encargado"));
			empleados.add(new AgenteAdministrativo("aaa", "ppp", "asdasd", (long) 5555, (long) 5151, "Administrativo"));
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
	public static Empleado buscarEmpleadoPorCodigo(int codigo) {
		Empleado employee = null;
		try {
		employee = empleados.stream().filter(e -> e.getLegajo() == codigo).findFirst().get();
		}catch(Exception e) {
			System.out.println("El legajo que ingreso no corresponde a ningun empleado");
		}
		return employee;
	}
	//]public static Stock buscarStockPorCodigo(int codigo) {
//	Stock product = registro.stream().filter(p -> p.getProd().getCodigo() == codigo).findFirst().get();
//	return product;
//}
}
