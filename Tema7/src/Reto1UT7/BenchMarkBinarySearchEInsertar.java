package Reto1UT7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BenchMarkBinarySearchEInsertar {

	public static void main(String[] args) throws InterruptedException {
		final int NUM_ITERACIONES = 1000000;
		final int NUM_ELEMENTOS = 10000;
		final int ESPERA = 2000; // segundos de espera antes de la prueba
		List<Integer> lista = new ArrayList<Integer>(NUM_ITERACIONES);
		List<Integer> listaLink = new LinkedList<Integer>();
		
		long t1, t2, t3;
		long t0 = System.nanoTime();
		int[] aleatorios = new int[NUM_ELEMENTOS];
		// calculo NUM_ELEMENTOS aleatorios y los meto en un array
		for (int i=0; i<NUM_ELEMENTOS;i++) {
			aleatorios[i] = (int)(Math.random()*Integer.MAX_VALUE);
		}
		
		// rellenado de cada lista:
		for (int i=0; i<NUM_ELEMENTOS;i++) lista.add(aleatorios[i]);
		for (int i=0; i<NUM_ELEMENTOS;i++) listaLink.add(aleatorios[i]);
		
		//ordeno ambas listas con sort, sin especificar parámetro, 
		//según el orden establecido en la interfaz comparable.
		Collections.sort(lista);
		Collections.sort(listaLink);
		
		Thread.sleep(ESPERA); 
		
		int num = 123;
		int pos = Collections.binarySearch(listaLink, num);
		
		t1 = System.nanoTime();
		listaLink.add(pos);
			
		t2 = System.nanoTime();
		//Búsqueda en LinkedList de todos los elementos.
		for (int i=0; i<listaLink.size(); i++) {
			Collections.binarySearch(listaLink, aleatorios[i]);
		}
		t3 = System.nanoTime();
		
		// FIN DE PRUEBAS, MOSTRAMOS RESULTADOS:
		System.out.printf("Tardó en buscar %s: %.2f ms.\n","ArrayList ",(t2-t1)/1000.0);
		System.out.printf("Tardó en buscar %s: %.2f ms.\n","LinkedList ",(t3-t2)/1000.0);

		
	}

}