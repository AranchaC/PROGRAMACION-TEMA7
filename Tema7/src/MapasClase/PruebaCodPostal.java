package MapasClase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PruebaCodPostal {

	public static void main(String[] args) {
		Map<Integer,String> cps = new HashMap<Integer,String>();
		cps.put(28032, "Vicálvaro");
		cps.put(28030, "Moratalaz");
		cps.put(28017, "La Elipa");
		cps.put(28038, "Puente de Vallecas");
		System.out.println(cps);
		
		Scanner entrada = new Scanner(System.in);
		while(true) {
			System.out.println("Dame código postal (0 para salir): ");
			int cp = entrada.nextInt();
			if(cp==0) break;
			System.out.println("El distrito es: " + cps.get(cp));
		}

	}

}
