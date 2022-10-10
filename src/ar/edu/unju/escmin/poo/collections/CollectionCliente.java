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
	public static void agregarCliente(Cliente cliente) {
		Cliente client = clientes.stream().filter(c -> c.getDni() == cliente.getDni()).findFirst().get();
		if(client.equals(null)) {
		clientes.add(cliente);
		}else {
			System.out.println("El cliente ya estaba registrado");
		}
	}

}
