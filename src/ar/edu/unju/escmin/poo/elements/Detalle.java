package ar.edu.unju.escmin.poo.elements;

public class Detalle {
	private int cantidad;
	private Producto producto;
	
	
	
	public Detalle(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}



	public Detalle() {
		// TODO Auto-generated constructor stub
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public double calcularImporte() {
		double total = producto.getPrecioUnitario() * cantidad;
		return total;
	}



	@Override
	public String toString() {
		return "Detalle [cantidad=" + cantidad + ", producto=" + producto + ", calcularImporte()=" + calcularImporte()
				+ "]";
	}
	
}
