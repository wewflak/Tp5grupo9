package ar.edu.unju.escmin.poo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escmin.poo.elements.Cliente;
import ar.edu.unju.escmin.poo.elements.ClienteMayorista;
import ar.edu.unju.escmin.poo.elements.ClienteMinorista;

public abstract class CollectionCliente {

	
	public static List <Cliente> clientes;
	public static List<Cliente> getClientes(){
		if(clientes == null || clientes.isEmpty()) {
			clientes = new ArrayList<Cliente>();
			clientes.add(new ClienteMayorista("aaa","bbb","ccc", 111, 222));
			clientes.add(new ClienteMinorista("ddd", "eee", "fff", (long) 333, 444));
		}
		
		return clientes;
		
	}
	public static Cliente buscarCliente(long documento) {

		Cliente clienteEncontrado = null;
		try {
		clienteEncontrado = clientes.stream().filter(c-> c.getDni() == documento).findFirst().get();

		}catch(Exception e) {
			System.out.println("El cliente no existe");
		}
		return clienteEncontrado;
	}

}
