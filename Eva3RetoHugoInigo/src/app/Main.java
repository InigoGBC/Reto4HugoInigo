package app;

import java.util.Locale;
import app.Ejercicios;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Dime un ejercicio: ");
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
