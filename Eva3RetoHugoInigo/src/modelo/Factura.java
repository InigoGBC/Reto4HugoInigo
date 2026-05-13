package modelo;

import java.time.LocalDate;

public class Factura {
	protected int id;
	protected LocalDate fecha;
	protected int idCliente;
	protected int idEmpleado;
	protected double subtotal;
	protected double iva;
	protected double total;
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
	public Factura() {
		super();
	}
	public Factura(LocalDate fecha, int idCliente, int idEmpleado, double subtotal, double iva, double total) {
		super();
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}
	public int getId() {
		return id;
	}
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
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + "]";
	}

}
