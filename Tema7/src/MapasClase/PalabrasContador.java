package MapasClase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PalabrasContador {

	public static void main(String[] args) {
		String texto ="Elements . An ordered collection and (also known as a sequence). "
				+ "and the user can access elements by their in search integer index (position in the list)"
				+ ", and search for in elements in the list elements list.";	
		String[] pals = texto.split("[^A-Za-záéíóúÁÉÍÓÚ]+"); 

		Map<String,Integer> frecuencias = new TreeMap<String,Integer>(String.CASE_INSENSITIVE_ORDER);
		
		for (String palabra : pals) {
			if (frecuencias.containsKey(palabra)) {
				int cuenta = frecuencias.get(palabra)+1;
				frecuencias.put(palabra, cuenta);
			}//if
			else {
				frecuencias.put(palabra, 1);
			}//else
		}//for
		
		System.out.println(frecuencias);
		
		//Recorrido con KeySet:
		Set<String> noRepes = frecuencias.keySet();
		for (String palabra : noRepes) {
			System.out.println(palabra+": "+ frecuencias.get(palabra));
		}
		
		//Recorrido con EntrySet:
		/*Set<Entry<String,Integer>> todas = frecuencias.entrySet();
		Iterator<Entry<String,Integer>> it = todas.iterator();
		while (it.hasNext()) {
			Entry<String,Integer> e = it.next();
			System.out.println(e.getKey() + ": "+ e.getValue());
		}*/
		
		//Recorrido con ForEach:
		/*frecuencias.forEach( (a,b) -> System.out.println(a+": "+b) );*/
		
		System.out.println(
			frecuencias.keySet()
				.stream()
				.map( (a) -> a.length() )
				.reduce(0, Integer::sum) // ((a,b) -> (a+b))
						//map: lo transforma en ota cosa

		);

	}

}
