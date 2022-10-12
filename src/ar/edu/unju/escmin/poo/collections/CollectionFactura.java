package ar.edu.unju.escmin.poo.collections;

import java.util.Optional;
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
		
		FacturaEncabezado factura = null;
		try {
			
		factura = facturas.stream().filter(f -> f.getNumeroFactura() == codigo).findFirst().get();	
		}catch(Exception e) {
			System.out.println("La factura no existe");
		}
		return factura;
	}
	public static Optional<FacturaEncabezado> buscarFactura(int codigo) {
	Optional<FacturaEncabezado> encontrado= Optional.empty();
	encontrado = facturas.stream().filter(f -> f.getNumeroFactura() == codigo).findFirst();
	
	return encontrado;
}
}
