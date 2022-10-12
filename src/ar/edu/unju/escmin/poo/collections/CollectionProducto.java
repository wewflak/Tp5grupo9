package ar.edu.unju.escmin.poo.collections;

import java.util.Optional;
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
		Producto product = null;
		try {
		product = productos.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
		
		}catch(Exception e) {
			System.out.println("El producto no existe");
		}

		return product;
		}
	public static Optional<Producto> buscarProducto(int codigo) {
		Optional<Producto> encontrado= Optional.empty();
		encontrado = productos.stream().filter(p -> p.getCodigo() == codigo).findFirst();
		
		return encontrado;
	}
	public static void agregarProducto(Producto producto) {
		//if(buscarProductoPorCodigo(producto.getCodigo()).equals(null)) {
		productos.add(producto);
		System.out.println("Se agrego el producto");
		//}else {
			//System.out.println("El producto ya existe en el sistema");
		//}
	}
public static void mostrarProductos() {
	productos.stream().forEach(p -> System.out.println(p.getNombre()));
}
}
