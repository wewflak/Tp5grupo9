package ar.edu.unju.escmin.poo.collections;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.elements.Cliente;

public abstract class CollectionCliente {

	public static Set <Cliente> clientes;
	public static Set<Cliente> getClientes(){
		if(clientes == null || clientes.isEmpty()) {
			clientes = new TreeSet<Cliente>();
		}
		
		return clientes;
		
	}
}