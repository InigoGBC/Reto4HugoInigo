package modelo;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

	protected String direccion;

	public Cliente() {
		super();
	}

	


	public Cliente(String dni, String nombre, String direccion) {
		super(dni, nombre);
		this.direccion = direccion;
	}




	public Cliente(int id, String dni, String nombre, String direccion) {
		super(id, dni, nombre);
		this.direccion = direccion;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", direccion=" + direccion + "]";
	}

}
