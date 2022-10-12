package ar.edu.unju.escmin.poo.elements;

public class Producto implements Comparable<Producto> {

	private int codigo;
	private String nombre;
	private String descripcion;
	private double precioUnitario;
	private int descuento;
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precioUnitario=" + precioUnitario + ", descuento=" + descuento + "]";
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public double getPrecioUnitario() {
		return precioUnitario;
	}



	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	public int getDescuento() {
		return descuento;
	}



	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}



	public Producto(int codigo, String nombre, String descripcion, double precioUnitario, int descuento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.descuento = descuento;
	}



	public double calcularDescuento() {
		
		double nuevoPrecio;
		
		nuevoPrecio = (descuento*precioUnitario)/100;
		
		return nuevoPrecio;
		
	}



	@Override
	public int compareTo(Producto o) {
		if(this.codigo == o.getCodigo()) {
		return 0;
		}else if(this.codigo > o.getCodigo())
			return 1;
		else return -1;
	}
}
