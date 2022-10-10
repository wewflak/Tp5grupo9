package ar.edu.unju.escmin.poo.elements;

public class ClienteMinorista extends Cliente implements Comparable<Cliente> {

	private long codPami;
	
	public ClienteMinorista(String nombre, String apellido, String domicilio, Long dni, long codPami) {
		super(nombre, apellido, domicilio, dni);
		this.codPami = codPami;
		// TODO Auto-generated constructor stub
	}

	public ClienteMinorista() {
		// TODO Auto-generated constructor stub
	}

	public long getCodPami() {
		return codPami;
	}

	public void setCodPami(long codPami) {
		this.codPami = codPami;
	}

	@Override
	public int compareTo(Cliente o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
