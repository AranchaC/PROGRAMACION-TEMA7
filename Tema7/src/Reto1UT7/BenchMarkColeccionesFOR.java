package Reto1UT7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BenchMarkColeccionesFOR {

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
		
		// rellenado y vaciado inicial de la lista para calentar:
		for (int i=0; i<NUM_ELEMENTOS;i++) lista.add(aleatorios[i]);
		for (int i=0; i<listaLink.size();i++) listaLink.add(aleatorios[i]);
		
		//while (! lista.isEmpty()) lista.remove(lista.size()-1);
		
		// La vuelvo a rellenar
		//lista = new ArrayList<Integer>(); 
		//for (int i=0; i<NUM_ITERACIONES;i++) lista.add(aleatorios[i%NUM_ELEMENTOS]);
		
		long suma = 0;
		// espera ESPERA segundos para estabilizar antes de medir tiempos
		Thread.sleep(ESPERA); 
		for (int i=0; i<lista.size(); i++) {
			suma += lista.get(i);
		}
		for (int i=0; i<listaLink.size(); i++) {
			suma += listaLink.get(i);
		}
		
		// CAMBIAR A PARTIR DE AQUÍ:
		
		// PRUEBAS DE RECORRIDO DE UNA LISTA:
		// ArrayList con for (;;)
		t1 = System.nanoTime();
		for (int i=0; i<lista.size(); i++) {
			suma += lista.get(i);
		}
		
		// LinkedList con for (;;)
		t2 = System.nanoTime();
		for (int i=0; i<listaLink.size(); i++) {
			suma += listaLink.get(i);
		}
		
		t3 = System.nanoTime();
		
		// FIN DE PRUEBAS, MOSTRAMOS RESULTADOS:
		System.out.printf("Tardó en recorrido %s: %.2f ms.\n","ArrayList for(;;) ",(t2-t1)/1000.0);
		System.out.printf("Tardó en recorrido %s: %.2f ms.\n","LinkedList for(;;) ",(t3-t2)/1000.0);

		
	}

}