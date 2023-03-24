package Reto1UT7;

import java.util.ArrayList;
import java.util.List;

public class BenchMarkColeccionesINICIAL {

	public static void main(String[] args) throws InterruptedException {
		final int NUM_ITERACIONES = 100000;
		final int NUM_ELEMENTOS = 10000;
		final int ESPERA = 2000; // segundos de espera antes de la prueba
		List<Integer> lista = new ArrayList<Integer>(); // = new LinkedList<Integer>();
		
		long t1, t2, t3, t4;
		
		int[] aleatorios = new int[NUM_ELEMENTOS];
		// calculo NUM_ELEMENTOS aleatorios y los meto en un array
		for (int i=0; i<NUM_ELEMENTOS;i++) {
			aleatorios[i] = (int)(Math.random()*Integer.MAX_VALUE);
		}
		
		// rellenado y vaciado inicial de la lista para calentar:
		for (int i=0; i<NUM_ELEMENTOS;i++) lista.add(aleatorios[i]);
		while (! lista.isEmpty()) lista.remove(lista.size()-1);
		
		
		// espera ESPERA segundos para estabilizar antes de medir tiempos
		Thread.sleep(ESPERA); 
		
		// PRUEBAS DE RELLENADO DE UNA LISTA:
		t1 = System.nanoTime();
		lista = new ArrayList<Integer>(); 
		for (int i=0; i<NUM_ITERACIONES;i++) lista.add(aleatorios[i%NUM_ELEMENTOS]);
		t2 = System.nanoTime();
		// llenado con preserva de espacio:
		lista = new ArrayList<Integer>(NUM_ELEMENTOS); 
		for (int i=0; i<NUM_ITERACIONES;i++) lista.add(aleatorios[i%NUM_ELEMENTOS]);
		t3 = System.nanoTime();
		// insertando al principio:
		lista = new ArrayList<Integer>(); 
		for (int i=0; i<NUM_ITERACIONES;i++) lista.add(0,aleatorios[i%NUM_ELEMENTOS]);
		t4 = System.nanoTime();
		
		// FIN DE PRUEBAS, MOSTRAMOS RESULTADOS:
		System.out.printf("Tardó en rellenar %s: %d ms.\n","ArrayList",(t2-t1)/1000);
		System.out.printf("Tardó en rellenar %s: %d ms.\n","ArrayList pre-reservando espacio",(t3-t2)/1000);
		System.out.printf("Tardó en rellenar %s: %d ms.\n","ArrayList insertando en posición 0: ",(t4-t3)/1000);
		
	}

}