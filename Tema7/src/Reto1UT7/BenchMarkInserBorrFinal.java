package Reto1UT7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BenchMarkInserBorrFinal {

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
		for (int i=0; i<NUM_ELEMENTOS;i++) lista.add(aleatorios[i]);
		for (int i=0; i<NUM_ELEMENTOS;i++) listaLink.add(aleatorios[i]);
		
		Thread.sleep(ESPERA); 
		
		long contador1=1;
		long contador2 =1;
		t1 = System.nanoTime();
		//inserto 1 elemento en ArrayList al final 
		//y lo borro 100000
		while (contador1<10000) {
			lista.add(lista.size(),1111);
			lista.remove(lista.size()-1);
			contador1++;		
		}//while					
		t2 = System.nanoTime();
		//inserto 1 elemento en LinkedList al final 
		//y lo borro 100000
		while (contador2<10000) {
			listaLink.add(listaLink.size(),1111);
			listaLink.remove(listaLink.size()-1);
			contador2++;	
		}//while	
		t3 = System.nanoTime();

		// FIN DE PRUEBAS, MOSTRAMOS RESULTADOS:
		System.out.printf("Tardó en insertar y borrar %s: %.2f ms.\n","ArrayList al final ",(t2-t1)/1000.0);
		System.out.printf("Tardó en insertar y borrar %s: %.2f ms.\n","LinkedList al final ",(t3-t2)/1000.0);

	}

}