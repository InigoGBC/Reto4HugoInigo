package modelo;

import java.io.Serializable;

/**
 * @author HugoIñigo
 * @since 2026
 * @version 1.0
 */
public class Cliente extends Persona implements Serializable {
	/**
	 * Atributo para cliente direccion
	 */
	protected String direccion;
	/**
	 * Constructor vacío.
	 */
	public Cliente() {
		super();
	}
	/**
	 * Constructor con atributos de la clase persona y direccion:
	 * dni,nombre,direccion.
	 * @param dni
	 * @param nombre
	 * @param direccion
	 */
	public Cliente(String dni, String nombre, String direccion) {
		super(dni, nombre);
		this.direccion = direccion;
	}
	/**
	 * Constructor con atributos de la clase persona y direccion:
	 * dni,nombre,direccion,id.
	 * @param id
	 * @param dni
	 * @param nombre
	 * @param direccion
	 */
	public Cliente(int id, String dni, String nombre, String direccion) {
		super(id, dni, nombre);
		this.direccion = direccion;
	}

	/**
	 * 
	 * @return devuelve el id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve una representación en texto del cliente.
	 * 
	 * @return cadena con id y dirección del cliente
	 */
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", direccion=" + direccion + "]";
	}

}
