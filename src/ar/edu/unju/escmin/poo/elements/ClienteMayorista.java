package ar.edu.unju.escmin.poo.elements;

public class ClienteMayorista extends Cliente implements Comparable<Cliente> {
	
	private long idCliente;
	
	public ClienteMayorista(String nombre, String apellido, String domicilio, Long dni, long idCliente) {
		super(nombre, apellido, domicilio, dni);
		this.idCliente = idCliente;
		// TODO Auto-generated constructor stub
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public int compareTo(Cliente o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
