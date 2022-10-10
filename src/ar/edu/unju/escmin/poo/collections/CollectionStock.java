package ar.edu.unju.escmin.poo.collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.elements.Producto;
import ar.edu.unju.escmin.poo.elements.Stock;
public abstract class CollectionStock {

	public static Set<Stock> registro;
	
	public static Set<Stock> getStock(){
		if(registro == null) {
			registro = new TreeSet<Stock>();
		}
		
		
		return registro;
	}
	
	public static void agregarStockDeProducto(Stock stock) {
		if(buscarStockPorCodigo(stock.getProd().getCodigo())==null) {
			registro.add(stock);
		}else {
			System.out.println("El producto ya esta registrado con su stock");
		}
	}
	
//	public static Set<Producto> getProductos(){
//	if(productos == null || productos.isEmpty()) {
//		productos = new TreeSet<Producto>();
//	}
//	
//	return productos;
//	
//}
//
public static Stock buscarStockPorCodigo(int codigo) {
	Stock product = registro.stream().filter(p -> p.getProd().getCodigo() == codigo).findFirst().get();
	return product;
}
//
//public static void agregarProducto(Producto producto) {
//	if(buscarProductoPorCodigo(producto.getCodigo()).equals(null)) {
//	productos.add(producto);
//	}else {
//		System.out.println("El producto ya existe en el sistema");
//	}
//}

	
}
