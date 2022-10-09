package ar.edu.unju.escmin.poo.collections;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.elements.FacturaEncabezado;

public class CollectionFactura {

	public static Set <FacturaEncabezado> facturas;
	public static Set<FacturaEncabezado> getFacturas(){
		if(facturas == null || facturas.isEmpty()) {
			facturas = new TreeSet<FacturaEncabezado>();
		}
		return facturas;
		
	}
	public static void agregarFactura(FacturaEncabezado factura) {
		facturas.add(factura);
	}
	public static FacturaEncabezado buscarFacturaPorCodigo(int codigo) {
		
		FacturaEncabezado factura;
		factura = facturas.stream().filter(f -> f.getNumeroFactura() == codigo).findFirst().get();		
		return factura;
	}
}
