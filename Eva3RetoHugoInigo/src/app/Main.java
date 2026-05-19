package app;

import java.util.Locale;
import app.Ejercicios;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("""
				=======================================
		
				               MENU		
				     1. Ej 1          2. Ej 2
				     3. Ej 3          4. Ej 4
				     5. Ej 5          6. Ej 6
				     7. Ej 7          8. Ej 8
				     9. Ej 9         10. Ej 10
				    11. Ej 11        12. Ej 12
				    13. Ej 13        14. Ej 14
				    15. Ej 15
				    
				======================================""");
		System.out.print("Escribe el numero del ejercicio: ");
		String ejercicio = sc.nextLine();
		int num = Integer.parseInt(ejercicio);
		switch (num) {
		case 1 -> Ejercicios.ejercicio1();
		case 2 -> Ejercicios.ejercicio2();
		case 3 -> Ejercicios.ejercicio3();
		case 4 -> Ejercicios.ejercicio4();
		case 5 -> Ejercicios.ejercicio5();
		case 6 -> Ejercicios.ejercicio6();
		case 7 -> Ejercicios.ejercicio7();
		case 8 -> Ejercicios.ejercicio8();
		case 9 -> Ejercicios.ejercicio9();
		case 10 -> Ejercicios.ejercicio10();
		case 11 -> Ejercicios.ejercicio11();
		case 12 -> Ejercicios.ejercicio12();
		case 13 -> Ejercicios.ejercicio13();
		case 14 -> Ejercicios.ejercicio14();
		case 15 -> Ejercicios.ejercicio15();

		default -> throw new IllegalArgumentException("No exixste ese ejercicio" );
		}
	}

}
