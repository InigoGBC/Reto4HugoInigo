package app;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.FacturaDAO;
import modelo.Cliente;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		FacturaDAO facturaDAO = new FacturaDAO();

		System.out.println("ejercicio 1:");
		for (Cliente p : clienteDAO.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("dime un id: ");
		int id = (Integer.parseInt(sc.nextLine()));
		System.out.println();
		facturaDAO.obtenerPorId(id);

		// System.out.println("Ejercicio 6: ");

		// Cliente c = new Cliente("12345675Z","Pepe Carrera","Plaza Mozart 3");
		// System.out.println(z.insertar(c));

	}

}
