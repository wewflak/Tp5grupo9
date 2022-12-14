package ar.edu.unju.escmin.poo.elements;

import java.util.Objects;

public abstract class Empleado implements Comparable<Empleado>{

	protected String nombre;
	protected String apellido;
	protected String domicilio;
	protected Long dni;
	protected Long legajo;
	protected String cargo;
	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public Long getLegajo() {
		return legajo;
	}
	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Empleado(String nombre, String apellido, String domicilio, Long dni, Long legajo, String cargo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.dni = dni;
		this.legajo = legajo;
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", dni=" + dni
				+ ", legajo=" + legajo + ", cargo=" + cargo + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(cargo, other.cargo) && legajo == other.legajo
				&& Objects.equals(apellido, other.apellido);
	}
}
