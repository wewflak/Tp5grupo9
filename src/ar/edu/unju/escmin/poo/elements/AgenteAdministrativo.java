package ar.edu.unju.escmin.poo.elements;

public class AgenteAdministrativo extends Empleado implements Comparable<Empleado> {

	public AgenteAdministrativo() {
		// TODO Auto-generated constructor stub
	}
	
	public AgenteAdministrativo(String nombre, String apellido, String domicilio, Long dni, Long legajo, String cargo) {
		super(nombre, apellido, domicilio, dni, legajo, cargo);
		// TODO Auto-generated constructor stub
	}
	public static void altaProducto() {
		
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
