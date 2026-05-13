package modelo;


public class LineaFactura {
	protected int id;
	protected int idFactura;
	protected int idProducto;
	protected int cantidad;
	protected double precioUnitario;
	protected double importe;
	public LineaFactura(int id, int idFactura, int idProducto, int cantidad, double precioUnitario, double importe) {
		super();
		this.id = id;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.importe = importe;
	}
	public LineaFactura() {
		super();
	}
	public LineaFactura(int idFactura, int idProducto, int cantidad, double precioUnitario, double importe) {
		super();
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.importe = importe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return "LineaFactura [id=" + id + ", idFactura=" + idFactura + ", idProducto=" + idProducto + ", cantidad="
				+ cantidad + ", precioUnitario=" + precioUnitario + ", importe=" + importe + "]";
	}
	
	

}
