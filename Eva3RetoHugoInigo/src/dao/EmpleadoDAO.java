package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Empleado;
import util.ConexionBD;

public class EmpleadoDAO implements GenericDAO<Empleado>{

	@Override
	public boolean insertar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Empleado> obtenerTodos() {
		List<Empleado> empleados = new ArrayList<>();
		String sql = """ 
				
				SELECT id, puesto,salario
				FROM empleado 
		
				""";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				empleados.add(mapearFila(rs));
			}

		} catch (SQLException e) {
			System.err.println("Error SQL al obtener todos los empleados: " + e.getMessage());
		}
		return empleados;
	}
	

	@Override
	public Empleado obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	protected Empleado mapearFila(ResultSet rs) throws SQLException {
		Empleado a = new Empleado();
		a.setId(rs.getInt("id"));
		a.setPuesto(rs.getString("puesto"));
		a.setSalario(rs.getDouble("salario"));

		return a;
	}

}
