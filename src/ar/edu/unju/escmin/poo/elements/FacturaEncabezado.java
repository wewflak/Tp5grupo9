package ar.edu.unju.escmin.poo.elements;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaEncabezado {

	private LocalDate fecha;
	private int numeroFactura;
	private double total;
	private Cliente cliente;
	private List <Detalle> detalles = new ArrayList<Detalle>();
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public FacturaEncabezado(LocalDate fecha, int numeroFactura, double total, Cliente cliente,
			List<Detalle> detalles) {
		super();
		this.fecha = fecha;
		this.numeroFactura = numeroFactura;
		this.total = total;
		this.cliente = cliente;
		this.detalles = detalles;
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
		return "FacturaEncabezado [fecha=" + fecha + ", numeroFactura=" + numeroFactura + ", total=" + total
				+ ", cliente=" + cliente + ", detalles=" + detalles + "]";
	}
	
	public List<Detalle> agregarDetalle(Detalle detail) {
		if(detail.getCantidad()>0) {
			detalles.add(detail);
		}else {
			System.out.println("   ");
		}
		return detalles;
		
	}
	
	public double calcularTotal() {
		double precio = 0; 
		for(int i=0; i<detalles.size(); i++) {
			
			precio = precio + detalles.get(i).calcularImporte();
		}
		return total;
	}
}
