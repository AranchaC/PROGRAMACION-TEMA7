package Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PruebaListas2 {

	public static void main(String[] args) {
		String texto ="Elements . An ordered collection (also known as a sequence). "
				+ "and the user can access elements by their integer index (position in the list)"
				+ ", and search for elements in the list list.";
				
		List<String> palabras = new ArrayList<String>();
		
		palabras.addAll(Arrays.asList(texto.split("\\W+")));
		//W cualquier caracter que no sea alfanumerico		
		palabras.sort(String.CASE_INSENSITIVE_ORDER);
		
		Set<String> noRepes = new LinkedHashSet<String>();
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
