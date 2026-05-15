package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import util.ConexionBD;

public class ProductoDAO implements GenericDAO<Producto>{

	@Override
	public boolean insertar(Producto objeto) {
		String sql = "INSERT INTO producto (nombre, precio, stock) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, objeto.getNombre());
            ps.setDouble(2, objeto.getPrecio());
            ps.setInt(3, objeto.getStock());
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
	public List<Producto> obtenerTodos() {
		List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";

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
	public Producto obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean actualizarPrecio(int id, double precio) {
		String sql = "UPDATE producto SET precio = ? where id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, precio);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

        return false;
	}

	@Override
	public boolean actualizar(Producto objeto) {
		String sql = "UPDATE producto SET nombre = ?, precio = ?, stock = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, objeto.getNombre());
            ps.setDouble(2, objeto.getPrecio());
            ps.setInt(3, objeto.getStock());
    

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

        return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	 private Producto mapear(ResultSet rs) throws SQLException {
	        Producto objeto = new Producto();
	        objeto.setId(rs.getInt("id"));
	        objeto.setNombre(rs.getString("nombre"));
	        objeto.setPrecio(rs.getDouble("precio"));
	        objeto.setStock(rs.getInt("stock"));

	        return objeto;
	    }

}
