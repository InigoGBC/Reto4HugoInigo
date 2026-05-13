package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Factura;
import util.ConexionBD;

public class FacturaDAO implements GenericDAO<Factura>{
	
	public void name() {
		
	}
	
	

	@Override
	public boolean insertar(Factura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Factura> obtenerTodos() {
		List<Factura> lista = new ArrayList<>();
        String sql = "SELECT * FROM factura";

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
	public Factura obtenerPorId(int id) {
		 String sql = "SELECT * FROM factura WHERE id = ?";

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
	public boolean actualizar(Factura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	 private Factura mapear(ResultSet rs) throws SQLException {
	        Factura objeto = new Factura();
	        objeto.setId(rs.getInt("id"));
	        objeto.setIdCliente(rs.getInt("id_cliente"));
	        objeto.setIdEmpleado(rs.getInt("id_empleado"));
	        objeto.setSubtotal(rs.getDouble("subtotal"));
	        objeto.setIva(rs.getDouble("iva"));
	        objeto.setTotal(rs.getDouble("total"));
	        return objeto;
	    }
	

}
