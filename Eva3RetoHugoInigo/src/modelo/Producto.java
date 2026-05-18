package modelo;

/**
 * @author HugoIñigo
 * @since 2026
 * @version 1.0
 */
public class Producto {
	/**
	 * Atributos de Prodcuto: id,nombre,precio,stock.
	 */

	protected int id;
	protected String nombre;
	protected double precio;
	protected int stock;

	/**
	 * Constructor con id,nombre,precio,stock.
	 * 
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param stock
	 */
	public Producto(int id, String nombre, double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	/**
	 * Constructor vacío.
	 */
	public Producto() {
		super();
	}

	/**
	 * Constructor con nombre,precio,stock.
	 * 
	 * @param nombre
	 * @param precio
	 * @param stock
	 */
	public Producto(String nombre, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Devuelve una representación en texto de Prodcuto.
	 * 
	 * @return cadena con id, nombre,precio,stock de Producto.
	 */
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}

}
