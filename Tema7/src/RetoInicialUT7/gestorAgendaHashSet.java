package RetoInicialUT7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestorAgendaHashSet {

		private static Scanner entrada = new Scanner(System.in);

		public static void main(String[] args) {
			AgendaHashSet agenda = new AgendaHashSet(10);

			int opcion;
			while ( (opcion=menuPrincipal(!agenda.vacia()))!= 0) {
				switch (opcion) {
				case 1:
					System.out.println(agenda.listaContactos());
					break;
				case 2:
					Contacto nuevo = Contacto.deTeclado(entrada);
					if (nuevo!=null) agenda.anadeContacto(nuevo);
					break;
				case 3:
					int pos = menuPosicion(agenda.numContactos());
					agenda.borraContacto (pos-1); 

				}	
			}
			System.out.println("Bye bye ...");
		} // main

		public static int menuPosicion(int maxPosicion) {
			int pos;
			do {
				pos = dameEntero("Dime posición entre 1 y " + maxPosicion + ": ");
			} while (pos<=0 || pos > maxPosicion);
			return pos;
		} // menúPosición

		public static int menuPrincipal(boolean opcionBorrar) {
			final int MAX_OPTION = 3;
			int opcion;
			String textoMenu = "MENÚ PRINCIPAL:\n"
					+ "0. SALIR\n"
					+ "1. LISTAR CONTACTOS\n"
					+ "2. NUEVO CONTACTO\n";
			if (opcionBorrar) {
				textoMenu += "3. BORRAR CONTACTO\n";
			}
			// Pide opción hasta que de una válida:
			do {
				System.out.println(textoMenu);
				opcion = dameEntero("Entre opción: ");
			} while( opcion<0 || opcion > MAX_OPTION);
			return opcion;
		} // menúPrincipal

		public static int dameEntero(String prompt) {
			int opcion;
			String input;
			do {
				System.out.print(prompt);
				input = entrada.nextLine();
				try {
					opcion = Integer.parseInt(input);
				}
				catch(Exception e) {
					opcion = -1;
				}
			} while (opcion<0);
			return opcion;
		} // dameEntero

	

}
