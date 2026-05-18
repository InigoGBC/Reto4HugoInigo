package modelo;

/**
 * @author HugoIñigo
 * @since 2026
 * @version 1.0
 */
public class LineaFactura {
	/**
	 * Atributos de LineaFactura: id,idFactura,idProducto,cantidad,precioUnitario,importe.
	 */
	protected int id;
	protected int idFactura;
	protected int idProducto;
	protected int cantidad;
	protected double precioUnitario;
	protected double importe;
	/**
	 * Constructor con id,idFactura,idProducto,cantidad,precioUnitario,importe.
	 * @param id
	 * @param idFactura
	 * @param idProducto
	 * @param cantidad
	 * @param precioUnitario
	 * @param importe
	 */
	public LineaFactura(int id, int idFactura, int idProducto, int cantidad, double precioUnitario, double importe) {
		super();
		this.id = id;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.importe = importe;
	}
	/**
	 * Constructor vacío.
	 */
	public LineaFactura() {
		super();
	}
	/**
	 * Constructor con idFactura,idProducto,cantidad,precioUnitario,importe.
	 * @param idFactura
	 * @param idProducto
	 * @param cantidad
	 * @param precioUnitario
	 * @param importe
	 */
	public LineaFactura(int idFactura, int idProducto, int cantidad, double precioUnitario, double importe) {
		super();
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.importe = importe;
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

	/**
	 * Devuelve una representación en texto de la Lineafactura.
	 * 
	 * @return cadena con id, idFactura,idProdcuto,cantidad,precioUnitario e importe
	 *         de la LineaFactura.
	 */
	@Override
	public String toString() {
		return "LineaFactura [id=" + id + ", idFactura=" + idFactura + ", idProducto=" + idProducto + ", cantidad="
				+ cantidad + ", precioUnitario=" + precioUnitario + ", importe=" + importe + "]";
	}
	
	

}
