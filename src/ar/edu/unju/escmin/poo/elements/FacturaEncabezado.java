package ar.edu.unju.escmin.poo.elements;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaEncabezado {
public FacturaEncabezado() {
	// TODO Auto-generated constructor stub
}
String newLine = System.getProperty("line.separator");
	private LocalDate fecha;
	private int numeroFactura;
	private double total;
	private Cliente cliente;
	private List <Detalle> detalles = new ArrayList<Detalle>();
	private double subtotal;
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public FacturaEncabezado(LocalDate fecha, int numeroFactura, double total, Cliente cliente, long subtotal,
			List<Detalle> detalles) {
		super();
		this.fecha = fecha;
		this.numeroFactura = numeroFactura;
		this.total = total;
		this.cliente = cliente;
		this.detalles = detalles;
		this.subtotal = subtotal;
	}
	public List<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	public int getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Factura" + "[" +"fecha: " + fecha + "  |||||  " + "numeroFactura: " + numeroFactura + " ||||| " +"cliente:" + cliente.nombre+ cliente.apellido +"]" + newLine+ 
				"---------------" + newLine+
				"      "+
				"	Producto		"+	"Descripcion		" + "	Importe		"+ newLine +
				"______________" +
				"detalles: " + mostrarDetalle() + newLine + 
				"				"+ 
				"	"+ "			total=" + total;
	}
	
	public List<Detalle> agregarDetalle(Detalle detail) {
		if(detail.getCantidad()>0) {
			detalles.add(detail);
		}else {
			System.out.println("La cantidad debe ser mayor a 0");
		}
		return detalles;
		
	}
	public String mostrarDetalle() {
		String datos =" ";
		for(int i=0; i<detalles.size(); i++) {
			if(detalles.get(i)!=null) {
				datos = detalles.get(i).getProducto().getNombre() + detalles.get(i).getProducto().getDescripcion() + detalles.get(i).getCantidad() +detalles.get(i).calcularImporte();
			}else {
				
			}
		}
		return datos;
	}
	public boolean comprobarExistencia( Producto prod) {
		if(detalles.isEmpty()) {
			System.out.println("La factura no tiene detalles");
			return false;
		}else {
		for(int i=0; i<detalles.size(); i++) {
			if(detalles.get(i).getProducto().getCodigo() == prod.getCodigo()) {
				return true;
			}
		}
		}
		
		return false;
		
	}
	public double calcularSubtotal() {
		double precio = 0; 
		for(int i=0; i<detalles.size(); i++) {
			
			precio += detalles.get(i).calcularImporte();
		}
		return precio;
	}
	public double calcularTotal() {
		double total=0;
		double detalle=0;
		
		if(cliente instanceof ClienteMinorista) {
			
			total = (subtotal*90)/100;
			
			
		}else if(cliente instanceof ClienteMayorista) {
			
			for(int i=0; i<detalles.size(); i++) {
				
				detalle = detalles.get(i).calcularImporte()/2;
				total += detalle;
			}
			
		}
		
		
		return total;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
