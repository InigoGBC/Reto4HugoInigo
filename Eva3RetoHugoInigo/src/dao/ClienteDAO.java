package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import modelo.Cliente;
import util.ConexionBD;

public class ClienteDAO implements GenericDAO<Cliente> {
	
	/**
	 * Método para insertar una persona nueva, le pasamos los campos y los valores nuevos.
	 * Una vez insertada la persona inserta en clientes los campos restantes necesarios.
	 */
	@Override
	public boolean insertar(Cliente cliente) {
		String sql = """
				insert into persona (dni,nombre) values (?,?);
			
				""";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, cliente.getDni());
			pstmt.setString(2, cliente.getNombre());

			int filas = pstmt.executeUpdate();

			if (filas > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						cliente.setId(rs.getInt(1)); 
						String sql2 = """
								insert into cliente (id,direccion) values (?,?);
							
								""";
						try (PreparedStatement pstm = conn.prepareStatement(sql2)){
							pstm.setInt(1, cliente.getId());
							pstm.setString(2, cliente.getDireccion());
							 filas = pstm.executeUpdate();
						}  
							
							
						
						return true;
					}
				}
			}
			return false;

		} catch (SQLException e) {
			System.err.println("Error SQL al insertar '" + cliente.getDireccion() + "': " + e.getMessage());
			return false;
		}
		
	}
	/**
	 * 
	 */
	@Override
	public List<Cliente> obtenerTodos() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = """ 
				
				SELECT id, direccion
				FROM cliente 
		
				""";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				clientes.add(mapearFila(rs));
			}

		} catch (SQLException e) {
			System.err.println("Error SQL al obtener todos los clientes: " + e.getMessage());
		}
		return clientes;
	}
	/**
	 * 
	 */
	@Override
	public Cliente obtenerPorId(int id) {
		  String sql = "SELECT id,direccion FROM cliente WHERE id = ?";

	        try (Connection con = ConexionBD.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return mapearFila(rs);
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }

	        return null;
	}

	@Override
	public boolean actualizar(Cliente objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	protected Cliente mapearFila(ResultSet rs) throws SQLException {
		Cliente a = new Cliente();
		a.setId(rs.getInt("id"));
		a.setDireccion(rs.getString("direccion"));

		return a;
	}
}
