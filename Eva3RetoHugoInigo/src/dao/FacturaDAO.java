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

import modelo.Factura;
import util.ConexionBD;

public class FacturaDAO implements GenericDAO<Factura>{
	
	public void name() {
		
	}
	
	

	@Override
	public boolean insertar(Factura objeto) {
		String sql = "INSERT INTO factura (fecha,id_cliente,id_empleado,subtotal,iva,total) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	LocalDate fecha=objeto.getFecha();
            if (fecha != null) {
            	ps.setObject(1, fecha); // DATE
            	} else {
            	ps.setNull(1, Types.DATE);
            	}
            ps.setInt(2, objeto.getIdCliente());
            ps.setInt(3, objeto.getIdEmpleado());
            ps.setDouble(4, objeto.getSubtotal());
            ps.setDouble(5, objeto.getIva());
            ps.setDouble(6, objeto.getTotal());
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
		 String sql = "SELECT id,fecha,id_cliente,id_empleado,subtotal,iva,total FROM factura WHERE id = ?";

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
	public Factura copiar(int id) {
		 String sql = "SELECT id,fecha,id_cliente,id_empleado,subtotal,iva,total FROM factura WHERE id = ?";

	        try (Connection con = ConexionBD.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return mapearCopiar(rs);
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }

	        return null;

	}
	public Factura obtenerPorFecha(LocalDate fecha) {
		 String sql = "SELECT id,fecha,id_cliente,id_empleado,subtotal,iva,total FROM factura WHERE id = ?";

	        try (Connection con = ConexionBD.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setObject(1, fecha);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return mapear(rs);
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }

	        return null;

	}
	public boolean recalcular(double sub, double iva, double total, int id) {
		String sql = "UPDATE factura SET subtotal = ?, iva = ?, total = ? where id = ?";
	    try (Connection con = ConexionBD.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setDouble(1, sub);
	        ps.setDouble(2, iva);
	        ps.setDouble(3, total);
	        ps.setInt(4, id);
	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        System.out.println("Error al actualizar: " + e.getMessage());
	    }

	    return false;
		
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
	        objeto.setFecha(rs.getObject("fecha", LocalDate.class));
	        objeto.setIdCliente(rs.getInt("id_cliente"));
	        objeto.setIdEmpleado(rs.getInt("id_empleado"));
	        objeto.setSubtotal(rs.getDouble("subtotal"));
	        objeto.setIva(rs.getDouble("iva"));
	        objeto.setTotal(rs.getDouble("total"));
	        return objeto;
	    }
	 private Factura mapearCopiar(ResultSet rss) throws SQLException {
	        Factura objeto = new Factura();
	        objeto.setFecha(LocalDate.now());
	        objeto.setIdCliente(rss.getInt("id_cliente"));
	        objeto.setIdEmpleado(rss.getInt("id_empleado"));
	        objeto.setSubtotal(rss.getDouble("subtotal"));
	        objeto.setIva(rss.getDouble("iva"));
	        objeto.setTotal(rss.getDouble("total"));
	        
	        return objeto;
	    }
	

}
