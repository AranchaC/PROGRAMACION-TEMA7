import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

// Pruebas iniciales de conjuntos y listas
public class PruebaConjuntosYListas {
	public static void main(String[] args) {
		// Copiamos un texto en una variable String
		String texto = "A Collection represents a group of objects known as its elements. The Collection interface is used to pass around collections of objects where maximum generality is desired. For example, by convention all general-purpose collection implementations have a constructor that takes a Collection argument. This constructor, known as a conversion constructor, initializes the new collection to contain all of the elements in the specified collection, whatever the given collection's subinterface or implementation type. In other words, it allows you to convert the collection's type.";
		
		// Creamos una lista estática y otra dinámica
		List<String> palabras = new ArrayList<String>(5);
		List<String> palabras2 = new LinkedList<String>();
		// Un array con cada palabra del texto anterior
		String[] trozos = texto.toLowerCase().split("(\\s*[,.]\\s*|\\s+)");
		
		// los long para medir tiempos en nanosegundos
		long t1,t2,t3;
		// Vamos a insertar al final de cada lista 1000 veces todas las palabras del string trozos 
		System.out.println("Tiempos de inserción al final:");
		t1 = System.nanoTime();
 		for(int i=0;i<1000;i++) palabras.addAll(Arrays.asList(trozos));
 		t2 = System.nanoTime();
 		for(int i=0;i<1000;i++) palabras2.addAll(Arrays.asList(trozos));
 		t3 = System.nanoTime();
 		System.out.printf(muestraTiempos((t3-t2),(t2-t1)));
 		
 		// Igual que antes pero insertando cada vez en la posición 0 para que el array tenga que mover elementos
 		System.out.println("Tiempos de inserción al principio:");
		t1 = System.nanoTime();
 		for(int i=0;i<1000;i++) palabras.addAll(0,Arrays.asList(trozos));
 		t2 = System.nanoTime();
 		for(int i=0;i<1000;i++) palabras2.addAll(0,Arrays.asList(trozos));
 		t3 = System.nanoTime();
 		System.out.printf(muestraTiempos((t3-t2),(t2-t1)));
 		
 		// Calculamos tiempo de reorrido de las listas, en orden normal e inverso
 		// con get() es poco eficiente
 		System.out.println("Tiempos de recorrido:");
 		String palabra;
 		t1 = System.nanoTime();
 		//for (int pos=palabras.size()-1; pos>=0; pos--) {
 		for (int pos=0; pos<palabras.size();pos++) {
 			palabra = palabras.get(pos);
 		}
 		t2 = System.nanoTime();
 		//for (int pos=palabras2.size()-1; pos>=0; pos--) {
 		for (int pos=0; pos<palabras2.size();pos++) {
 			palabra = palabras2.get(pos);
 		}
 		t3 = System.nanoTime();
 		System.out.printf(muestraTiempos((t3-t2),(t2-t1)));
 		
 	    // Calculamos tiempo de reorrido de las listas con iteradores:
 		System.out.println("Tiempos de recorrido con iterador:");
 		Iterator<String> it1 = palabras.iterator();
 		Iterator<String> it2 =  palabras2.iterator();
 		t1 = System.nanoTime();
 		while (it1.hasNext()) palabra = it1.next();
 		t2 = System.nanoTime();
 		while (it2.hasNext()) palabra = it2.next();
 		t3 = System.nanoTime();
 		System.out.printf(muestraTiempos((t3-t2),(t2-t1)));
 		
 		// En orden inverso se podría hacer con listIterator
 		
 		//System.out.println("Lista de palabras:");
		//palabras.forEach(System.out::println);
		
		// Las metemos en un conjunto para eliminar repetidas:
		Set<String> noRepetidas = new TreeSet<String>();
		noRepetidas.addAll(palabras);
		
		System.out.println("Palabras en texto: " + palabras.size());
		System.out.println("Palabras no repetidas: " + noRepetidas.size());
		
		//noRepetidas.forEach(System.out::println);
	} // main
	
	public static String muestraTiempos(long tLinked, long tArr) {
		StringBuilder res = new StringBuilder(String.format("Linked: %12.3f ms\n",((double)tLinked)/1000000));
		res.append(String.format("Array : %12.3f ms\n",(float)(tArr/1000000)));
		return res.toString();
	}
} // class
