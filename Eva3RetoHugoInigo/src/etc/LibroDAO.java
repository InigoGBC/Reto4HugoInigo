package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;
import util.ConexionBD;

public class LibroDAO implements GenericDAO<Libro>{

	@Override
	public boolean insertar(Libro objeto) {
		String sql = "INSERT INTO libro (titulo, precio, id_autor, id_editorial) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, objeto.getTitulo());
            ps.setDouble(2, objeto.getPrecio());
            ps.setInt(3, objeto.getId_autor());
            ps.setInt(4, objeto.getId_editorial());
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
	public List<Libro> obtenerTodos() {
		List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";

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
	public Libro obtenerPorId(int id) {
	    String sql = "SELECT * FROM libro WHERE id = ?";

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
	public boolean actualizar(Libro objeto) {
		String sql = "UPDATE libro SET titulo = ?, precio = ?, id_autor = ?, id_editorial = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
        	ps.setString(1, objeto.getTitulo());
            ps.setDouble(2, objeto.getPrecio());
            ps.setInt(3, objeto.getId_autor());
            ps.setInt(4, objeto.getId_editorial());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

        return false;
	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM libro WHERE id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
	}

    private Libro mapear(ResultSet rs) throws SQLException {
        Libro objeto = new Libro();
        objeto.setId(rs.getInt("id"));
        objeto.setTitulo(rs.getString("titulo"));
        objeto.setPrecio(rs.getDouble("precio"));
        objeto.setPrecio(rs.getInt("id_autor"));
        objeto.setPrecio(rs.getInt("id_editorial"));
        return objeto;
    }
    
	
}
