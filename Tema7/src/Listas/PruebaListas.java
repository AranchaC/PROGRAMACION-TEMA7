package Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PruebaListas {

	public static void main(String[] args) {
		String texto ="Elements . An ordered collection (also known as a sequence). "
				+ "and the user can access elements by their integer index (position in the list)"
				+ ", and search for elements in the list list.";
				
		List<String> palabras = new ArrayList<String>();
		String[] pals = texto.split("\\W+");
			
		palabras = Arrays.asList(pals);
		
		System.out.println("Número de palabras: "+ palabras.size());
		Iterator<String> it = palabras.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		Set<String> noRepes = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		noRepes.addAll(palabras);
		
		System.out.println(noRepes);
		System.out.println(noRepes.size());
		
		int i=1;
		for (String palabra : noRepes) {
			System.out.println(i++ + ": "+palabra);
		}
		
		/*for (int i=0; i<palabras.size(); i++) {
			System.out.println( (i+1) + ": " + palabras.get(i));
		}*/

	}

}
