package ar.edu.unju.escmin.poo.elements;

public abstract class Cliente {
	protected String nombre;
	protected String apellido;
	protected String domicilio;
	protected Long dni;
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
	public Cliente(String nombre, String apellido, String domicilio, Long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", dni=" + dni
				+ "]";
	}
	

}
