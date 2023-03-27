package Reto1UT7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class BenchMarkBusquedaSet {

	public static void main(String[] args) throws InterruptedException {
		final int NUM_ITERACIONES = 1000000;
		final int NUM_ELEMENTOS = 100000;
		final int ESPERA = 2000; // segundos de espera antes de la prueba
		Set<Integer> listaHash = new HashSet<Integer>();
		Set<Integer> listaTree = new TreeSet<Integer>();
		
		long t1, t2, t3;
		long t0 = System.nanoTime();
		int[] aleatorios = new int[NUM_ELEMENTOS];
		// calculo NUM_ELEMENTOS aleatorios y los meto en un array
		for (int i=0; i<NUM_ELEMENTOS;i++) {
			aleatorios[i] = (int)(Math.random()*Integer.MAX_VALUE);
		}
		
		// rellenado de cada lista:
		for (int i=0; i<listaHash.size();i++) listaHash.add(aleatorios[i]);
		for (int i=0; i<listaTree.size();i++) listaTree.add(aleatorios[i]);	
		
		Thread.sleep(ESPERA); 
		
		//Búsqueda en HashSet de todos los elementos.
		t1 = System.nanoTime();
		//listaHash.contains(50); para buscar un único elemento
		for (int i=0; i<listaHash.size(); i++) {
			listaHash.contains(aleatorios[i]);
		}
		t2 = System.nanoTime();
		//Búsqueda en TreeSet de todos los elementos.
		for (int i=0; i<listaTree.size(); i++) {
			listaTree.contains(aleatorios[i]);
		}
		t3 = System.nanoTime();
		
		// FIN DE PRUEBAS, MOSTRAMOS RESULTADOS:
		System.out.printf("Tardó en buscar %s: %.2f ms.\n","HashSet ",(t2-t1)/1000.0);
		System.out.printf("Tardó en buscar %s: %.2f ms.\n","TreeSet ",(t3-t2)/1000.0);

		
	}

}