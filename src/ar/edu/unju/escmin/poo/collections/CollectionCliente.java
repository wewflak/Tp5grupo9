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
//	public static void agregarCliente(Cliente cliente) {
//		Cliente client = clientes.stream().filter(c -> c.getDni() == cliente.getDni()).findFirst().get();
//		if(client.equals(null)) {
//		clientes.add(cliente);
//		}else {
//			System.out.println("El cliente ya estaba registrado");
//		}
//	}
	public static Cliente buscarCliente(long documento) {

		Cliente clienteEncontrado = null;
		try {
		clienteEncontrado = clientes.stream().filter(c-> c.getDni() == documento).findFirst().get();
//		for(int i=0; i<clientes.size(); i++) {
//			if(documento == clientes.get(i).getDni()) {
//				encontrado = true;
//				clienteEncontrado = clientes.get(i);
//			}else {
//				encontrado = false;
//				System.out.println("No");
//			}
//		}
		}catch(Exception e) {
			System.out.println("El cliente no existe");
		}
		return clienteEncontrado;
	}

}
