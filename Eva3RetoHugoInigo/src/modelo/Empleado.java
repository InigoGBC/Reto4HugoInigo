package modelo;

/**
 * @author HugoIñigo
 * @since 2026
 * @version 1.0
 */
public class Empleado {
	/**
	 * Atributos de Empleado id,puesto,salario.
	 */
	protected int id;
	protected String puesto;
	protected double salario;

	/**
	 * Constructor vacío.
	 */
	public Empleado() {
		super();
	}

	/**
	 * Constructor con puesto y salario.
	 * 
	 * @param puesto
	 * @param salario
	 */
	public Empleado(String puesto, double salario) {
		super();
		this.puesto = puesto;
		this.salario = salario;
	}

	/**
	 * Construcor con id,puesto,salario.
	 * 
	 * @param id
	 * @param puesto
	 * @param salario
	 */
	public Empleado(int id, String puesto, double salario) {
		super();
		this.id = id;
		this.puesto = puesto;
		this.salario = salario;
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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Devuelve una representación en texto del empleado.
	 * 
	 * @return cadena con id, puesto y salario del empleado.
	 */
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", puesto=" + puesto + ", salario=" + salario + ", getId()=" + getId()
				+ ", getPuesto()=" + getPuesto() + ", getSalario()=" + getSalario() + "]";
	}

	

}
