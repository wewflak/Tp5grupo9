package ar.edu.unju.escmin.poo.collections;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.elements.Producto;

public abstract class CollectionProducto {
	
	public static Set <Producto> productos;
	
	public static Set<Producto> getProductos(){
		if(productos == null || productos.isEmpty()) {
			productos = new TreeSet<Producto>();
		}
		
		return productos;
		
	}
	
	public static Producto buscarProductoPorCodigo(int codigo) {
		Producto product = productos.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
		return product;
	}
	
	public static void agregarProducto(Producto producto) {
		productos.add(producto);
	}
}
