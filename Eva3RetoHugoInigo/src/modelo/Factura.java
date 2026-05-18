package modelo;

import java.time.LocalDate;

/**
 * @author HugoIñigo
 * @since 2026
 * @version 1.0
 */
public class Factura {
	/**
	 * Atributos de factura: id,fecha,idcliente,idEmpleado,subtotal,iva,total.
	 */
	protected int id;
	protected LocalDate fecha;
	protected int idCliente;
	protected int idEmpleado;
	protected double subtotal;
	protected double iva;
	protected double total;

	/**
	 * Constructor con id,fecha,idCliente,idEmpleado,subtotal,iva,total.
	 * @param id
	 * @param fecha
	 * @param idCliente
	 * @param idEmpleado
	 * @param subtotal
	 * @param iva
	 * @param total
	 */
	public Factura(int id, LocalDate fecha, int idCliente, int idEmpleado, double subtotal, double iva, double total) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}
	/**
	 * Constructor vacío.
	 */
	public Factura() {
		super();
	}
	/**
	 * Constructor con fecha,idCliente,idEmpleado,subtotal,iva,total.
	 * @param fecha
	 * @param idCliente
	 * @param idEmpleado
	 * @param subtotal
	 * @param iva
	 * @param total
	 */
	public Factura(LocalDate fecha, int idCliente, int idEmpleado, double subtotal, double iva, double total) {
		super();
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Devuelve una representación en texto de la factura.
	 * 
	 * @return cadena con id, fecha,idCliente,idEmpleado,subtotal,iva y total de la
	 *         factura.
	 */
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + "]";
	}

}
