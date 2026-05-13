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

import modelo.Prestamo;
import util.ConexionBD;

public class PrestamoDAO implements GenericDAO<Prestamo>{
	@Override
	public boolean insertar(Prestamo objeto) {
		String sql = "INSERT INTO prestamo (socio, juego, inicio, fin) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, objeto.getSocio());
            ps.setString(2, objeto.getJuego());
            LocalDate inicio=objeto.getInicio();
            if (inicio != null) {
            	ps.setObject(5, inicio); // DATE
            	} else {
            	ps.setNull(5, Types.DATE);
            	}
            LocalDate fin=objeto.getFin();
            if (fin != null) {
            	ps.setObject(5, fin); // DATE
            	} else {
            	ps.setNull(5, Types.DATE);
            	}
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
	public List<Prestamo> obtenerTodos() {
		List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";

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
	public Prestamo obtenerPorId(int id) {
	    String sql = "SELECT * FROM prestamo WHERE id = ?";

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
	public boolean actualizar(Prestamo objeto) {
		String sql = "UPDATE prestamo SET socio = ?, juego = ?, inicio = ?, fin = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, objeto.getSocio());
            ps.setString(2, objeto.getJuego());
            LocalDate inicio=objeto.getInicio();
            if (inicio != null) {
            	ps.setObject(5, inicio); // DATE
            	} else {
            	ps.setNull(5, Types.DATE);
            	}
            LocalDate fin=objeto.getFin();
            if (fin != null) {
            	ps.setObject(5, fin); // DATE
            	} else {
            	ps.setNull(5, Types.DATE);
            	}

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

        return false;
	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM prestamo WHERE id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
	}
	

    private Prestamo mapear(ResultSet rs) throws SQLException {
        Prestamo objeto = new Prestamo();
        objeto.setId(rs.getInt("id"));
        objeto.setSocio(rs.getString("socio"));
        objeto.setJuego(rs.getString("juego"));
        objeto.setInicio(rs.getObject("inicio", LocalDate.class));
        objeto.setFin(rs.getObject("fin", LocalDate.class));
        return objeto;
    }
}
