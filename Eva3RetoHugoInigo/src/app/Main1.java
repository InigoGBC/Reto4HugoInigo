package app;

import dao.ClienteDAO;
import modelo.Cliente;

public class Main1 {

	public static void main(String[] args) {
		System.out.println("Ejercicio 6: ");
		ClienteDAO z = new ClienteDAO();
		Cliente c = new Cliente("12345675Z","Pepe Carrera","Plaza Mozart 3");
		System.out.println(z.insertar(c)); 
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
