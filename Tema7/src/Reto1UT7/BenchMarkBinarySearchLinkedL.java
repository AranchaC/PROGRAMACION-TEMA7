package Reto1UT7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BenchMarkBinarySearchLinkedL {

	public static void main(String[] args) throws InterruptedException {
		final int NUM_ITERACIONES = 1000000;
		final int NUM_ELEMENTOS = 100000;
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
		for (int i=0; i<listaLink.size();i++) listaLink.add(aleatorios[i]);
		
		//ordeno ambas listas con sort, sin especificar parámetro, 
		//según el orden establecido en la interfaz comparable.
		Collections.sort(lista);
		Collections.sort(listaLink);
		
		Thread.sleep(ESPERA); 
		
		//Búsqueda de todos los elementos mediante bucle FOR: pasando por parámetro el nombre de la lista 
		//y el elemento a buscar, como nuestra lista está compuesta por el array aleatorios se pone aleatorios[i], 
		//y como está en el bucle, el elemento de la posición i va aumentando hasta el último.
		
		//Búsqueda en ArrayList de todos los elementos.
		/*t1 = System.nanoTime();
		for (int i=0; i<lista.size(); i++) {
			Collections.binarySearch(lista, aleatorios[i]);
		}*/	
		t2 = System.nanoTime();
		//Búsqueda en LinkedList de todos los elementos.
		for (int i=0; i<listaLink.size(); i++) {
			Collections.binarySearch(listaLink, aleatorios[i]);
		}
		t3 = System.nanoTime();
		
		// FIN DE PRUEBAS, MOSTRAMOS RESULTADOS:
		//System.out.printf("Tardó en buscar %s: %.2f ms.\n","ArrayList ",(t2-t1)/1000.0);
		System.out.printf("Tardó en buscar %s: %.2f ms.\n","LinkedList ",(t3-t2)/1000.0);

		
	}

}