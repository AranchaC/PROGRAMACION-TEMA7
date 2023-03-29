package Reto1UT7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BenchMarkInserBorrInicioPosAleat {

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
		//para insertar y borrar en posición aleatoria, primero hay que sacar la posición con Math.randorm.
		//en el rango desde posición 0 hasta el límite de cada lista, el .size.
		//lo demás es igual que con el resto de métodos de inserción.
		int posArr = (int) (Math.random()*(0-lista.size()+lista.size()));
		int posLink = (int) (Math.random()*(0-listaLink.size()+listaLink.size()));
		t1 = System.nanoTime();
		//inserto 1 elemento en ArrayList 
		//y lo borro 100000
		while (contador1<10000) {
			lista.add(posArr,1111);
			lista.remove(posArr);
			contador1++;		
		}//while					
		t2 = System.nanoTime();
		//inserto 1 elemento en LinkedList 
		//y lo borro 100000
		while (contador2<10000) {
			listaLink.add(posLink,1111);
			listaLink.remove(posLink);
			contador2++;		
		}//while	
		t3 = System.nanoTime();

		// FIN DE PRUEBAS, MOSTRAMOS RESULTADOS:
		System.out.printf("Tardó en insertar y borrar %s: %.2f ms.\n","ArrayList en posición aleat. ",(t2-t1)/1000.0);
		System.out.printf("Tardó en insertar y borar %s: %.2f ms.\n","LinkedList en posición aleat.  ",(t3-t2)/1000.0);

	}

}