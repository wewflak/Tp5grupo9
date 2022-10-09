package ar.edu.unju.escmin.poo.collections;
import java.util.HashMap;
import java.util.Map;

import ar.edu.unju.escmin.poo.elements.Producto;
public abstract class CollectionStock {

	public static Map<String, Producto> registro;
	public static Map<String, Producto> getStock(){
		if(registro == null || registro.isEmpty()) {
			registro = new HashMap<String, Producto>();
		}
		return registro;
	}
	public static String clave;
	public String code;
	public static Map<String, Producto> addStock(String code, Producto prod){
		if(prod!=null) {
			clave = prod.getCodigo() + code;
		registro.put(clave, prod);
		
		}
		return registro;
	}

	
}
