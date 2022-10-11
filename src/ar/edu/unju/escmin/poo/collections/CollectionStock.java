package ar.edu.unju.escmin.poo.collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
			registro.add(stock);
	}
	public static void incrementarStockDeProducto(int codigo, int cantidad) {
		Stock stock;
		stock = buscarStockPorCodigo(codigo);
		stock.setCantidad(stock.getCantidad()+cantidad);
		
	}
	public static void decrementarStockDeProducto(int codigo, int cantidad) {
		Stock stock;
		stock = buscarStockPorCodigo(codigo);
		stock.setCantidad(stock.getCantidad()-cantidad);
	}

public static Stock buscarStockPorCodigo(int codigo) {
	Stock product = null; 
	try {
	product = registro.stream().filter(p -> p.getProd().getCodigo() == codigo).findFirst().get();
	}catch(Exception e) {
		System.out.println("No existe el producto a stockear");
	}

	return product;
}
public static Optional<Stock> buscarStock (int codigo){
	Optional<Stock> encontrado = Optional.empty();
	encontrado = registro.stream().filter(s -> s.getProd().getCodigo() == codigo).findFirst();
	return encontrado;
}
//public static Optional<Producto> buscarProducto(int codigo) {
//Optional<Producto> encontrado= Optional.empty();
//encontrado = productos.stream().filter(p -> p.getCodigo() == codigo).findFirst();
//
//return encontrado;
//}
//
//public static void agregarProducto(Producto producto) {
//	if(buscarProductoPorCodigo(producto.getCodigo()).equals(null)) {
//	productos.add(producto);
//	}else {
//		System.out.println("El producto ya existe en el sistema");
//	}
//}

	
}
