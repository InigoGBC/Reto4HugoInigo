package modelo;

import java.io.Serializable;

/**
 * @author HugoIñigo
 * @since 2026
 * @version 1.0
 * 
 */
public class Persona implements Serializable {
	/**
	 * Atributos de persona id,dni,nombre
	 */
	protected int id;
	protected String dni;
	protected String nombre;

	/**
	 * Constructor vacio.
	 */
	public Persona() {
		super();
	}

	/**
	 * constructor con dni y nombre.
	 * 
	 * @param dni
	 * @param nombre
	 */
	public Persona(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	/**
	 * Constructor con id, dni y nombre.
	 * 
	 * @param id
	 * @param dni
	 * @param nombre
	 */
	public Persona(int id, String dni, String nombre) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve una representación en texto de la persona.
	 * 
	 * @return cadena con id,dni y nombre de la persona.
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
	}

}
