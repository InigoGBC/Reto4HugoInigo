package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Editorial;
import util.ConexionBD;

public class EditorialDAO implements GenericDAO<Editorial>{

	@Override
	public boolean insertar(Editorial objeto) {
		String sql = "INSERT INTO editorial (nombre, ciudad) VALUES (?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getCiudad());
            int filas = ps.executeUpdate();

            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    objeto.setId(rs.getInt(1));
                }
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

        return false;
	}

	@Override
	public List<Editorial> obtenerTodos() {
		List<Editorial> lista = new ArrayList<>();
        String sql = "SELECT * FROM editorial";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todos: " + e.getMessage());
        }

        return lista;
	}

	@Override
	public Editorial obtenerPorId(int id) {
	    String sql = "SELECT * FROM editorial WHERE id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener por id: " + e.getMessage());
        }

        return null;
	}

	@Override
	public boolean actualizar(Editorial objeto) {
		String sql = "UPDATE editorial SET nombre = ?, ciudad = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
        	ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getCiudad());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

        return false;
	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM editorial WHERE id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
	}

    private Editorial mapear(ResultSet rs) throws SQLException {
        Editorial objeto = new Editorial();
        objeto.setId(rs.getInt("id"));
        objeto.setNombre(rs.getString("nombre"));
        objeto.setCiudad(rs.getString("ciudad"));

        return objeto;
    }
    
	
}
