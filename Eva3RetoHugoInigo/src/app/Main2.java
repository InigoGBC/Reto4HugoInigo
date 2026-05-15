package app;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import dao.ProductoDAO;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.LineaFactura;
import modelo.Producto;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();	
		ProductoDAO productoDAO = new ProductoDAO();
		/*
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
		System.out.println("\n");
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
		//Ej 5
		System.out.println("Ej 5 \nEscribe una fecha: ");
		String datest = sc.nextLine();
		LocalDate dateej4 = LocalDate.parse(datest);
		for (Factura lf : facturaDAO.obtenerTodos()) {
			LocalDate fech = lf.getFecha();
			if (fech.equals(dateej4)) {
			System.out.println(lf);
			}
		}
		System.out.println("\n");
		//Fin Ej 5
		//Ej 7
		System.out.println("Ej 7 \nEscribe un nombre: ");
		String nuevonombre = sc.nextLine();
		System.out.println("Escribe un precio base: ");
		String nvoprecost = sc.nextLine();
		Double nuevoprecio = Double.parseDouble(nvoprecost);
		System.out.println("Escribe un stock base: ");
		String nvostockst = sc.nextLine();
		int nuevostock = Integer.parseInt(nvostockst);
		boolean esta = false;
		for (Producto prod : productoDAO.obtenerTodos()) {
			if (prod.getNombre().equals(nuevonombre)) {
				esta=true;
			}
		}
		if (!esta) {
			System.out.println(productoDAO.insertar(new Producto(nuevonombre,nuevoprecio,nuevostock)));
		} else {
			System.out.println("El producto ya esta");
		}
		System.out.println("\n");
		//Fin ej 7
		//Ej 8
		System.out.println("Ej 8 \nEscribe la id del producto: ");
		String idej8st = sc.nextLine();
		int idej8 = Integer.parseInt(idej8st);
		System.out.println("Escribe el nuevo precio: ");
		String precioej8st = sc.nextLine();
		Double nuevoprecioej8 = Double.parseDouble(precioej8st);
		System.out.println(productoDAO.actualizarPrecio(idej8, nuevoprecioej8));
		System.out.println("\n");
		// Fin 8
		*/
		/*
		//Ej 10
		int idfac10 = 0;
		System.out.println("Ej 10");
		for (Producto prod : productoDAO.obtenerTodos()) {
			System.out.println(prod);
		}
		System.out.println("Escribe el id del producto: ");
		String idej10st = sc.nextLine();
		int idej10 = Integer.parseInt(idej10st);
		for (LineaFactura ln : lineafacturaDAO.obtenerTodos()) {
			if (ln.getIdProducto()==idej10) {
				idfac10 = ln.getIdFactura();
				for (Factura fac : facturaDAO.obtenerTodos()) {
					if (fac.getId()==idfac10) {
						System.out.println(fac);
					}
					
				}
				
			}
			
		}
		//Ej11
		System.out.println("\n");
		System.out.println("Ej11");
		boolean esta = false;
		for (Producto prod : productoDAO.obtenerTodos()) {
			System.out.println(prod);
		}
		System.out.println("Escribe el id del producto: ");
		String idej11st = sc.nextLine();
		int idej11 = Integer.parseInt(idej11st);
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdProducto()==idej11) {
				esta = true;
			}
		}
		if (esta) {
			System.out.println("Este producto tiene lineas de factura");
		} else {
			System.out.println(productoDAO.eliminar(idej11));
		}
		
		//Ej 13
		System.out.println("\n");
		*/
		System.out.println("Ej13");
		System.out.println("Escribe el id de una factura: ");
		Factura copiafac = facturaDAO.copiar(1);
		System.out.println(copiafac);

		
		
		

	}

}
