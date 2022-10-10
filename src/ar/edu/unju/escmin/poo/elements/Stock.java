package ar.edu.unju.escmin.poo.elements;

public class Stock {

	public Stock() {
		// TODO Auto-generated constructor stub
	}
	private Producto prod;
	private int cantidad;
	public Producto getProd() {
		return prod;
	}
	public void setProd(Producto prod) {
		this.prod = prod;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Stock(Producto prod, int cantidad) {
		super();
		this.prod = prod;
		this.cantidad = cantidad;
	}
	
	
}
