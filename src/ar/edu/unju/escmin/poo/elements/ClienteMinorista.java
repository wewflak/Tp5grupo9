package ar.edu.unju.escmin.poo.elements;

public class ClienteMinorista extends Cliente {

	private long codPami;
	
	public ClienteMinorista(String nombre, String apellido, String domicilio, Long dni, long codPami) {
		super(nombre, apellido, domicilio, dni);
		codPami = this.codPami;
		// TODO Auto-generated constructor stub
	}

}
