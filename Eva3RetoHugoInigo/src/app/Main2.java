package app;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.LineaFactura;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();	
		
		//Ej 3
		System.out.println("Ej1:");
		for (Cliente p : clienteDAO.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("Dime el id de un cliente: ");
		int idcliente = (Integer.parseInt(sc.nextLine()));
		for (Factura lf : facturaDAO.obtenerTodos()) {
			if (lf.getIdCliente() == idcliente)
			System.out.println(lf);
		}
		System.out.println("\n");
		
		
		System.out.println("Ej2: ");
		for (Empleado p : empleadoDAO.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("Dime el id de un empleado: ");
		int idempleado = (Integer.parseInt(sc.nextLine()));
		for (Factura lf : facturaDAO.obtenerTodos()) {
			if (lf.getIdEmpleado() == idempleado)
			System.out.println(lf);
		}
		System.out.println("\n");
		
		// Ej 3 Muestra una factura por id junto con todas sus líneas de factura. 
		System.out.println("Ej3");
		for (Factura lf : facturaDAO.obtenerTodos()) {
			System.out.println(lf);
		}
		System.out.println("Escribe la id de la factura para mostrar sus lineas de factura: ");
		String idej1st = sc.nextLine();
		int idej1 = Integer.parseInt(idej1st);
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdFactura() == idej1)
			System.out.println(lf);
		}
		//Fin Ej 3
		System.out.println("\n");
		//-----------------------------------------------------------------------
		/* Ej 4 Muestra todas las facturas de un mes, pide el número del mes y 
		   calcula el total facturado ese mes. */
		System.out.println("Ej 4 \nEscribe un mes de factura: ");
		double calc = 0;
		String idej4st = sc.nextLine();
		int idej4 = Integer.parseInt(idej4st);
		for (Factura lf : facturaDAO.obtenerTodos()) {
			LocalDate fech = lf.getFecha();
			if (fech.getMonthValue() == idej4) {
			System.out.println(lf);
			calc+=lf.getTotal();
			}
		}
		System.out.println("En total se ha facturado "+calc+"€ este mes");
		System.out.println("\n");
		//Fin Ej 4
		System.out.println("Ej 5 \nEscribe una fecha: ");
		String datest = sc.nextLine();
		LocalDate dateej4 = LocalDate.parse(datest);
		for (Factura lf : facturaDAO.obtenerTodos()) {
			LocalDate fech = lf.getFecha();
			if (fech.equals(dateej4)) {
			System.out.println(lf);
			}
		}
		
		
		
		
		
		

	}

}
