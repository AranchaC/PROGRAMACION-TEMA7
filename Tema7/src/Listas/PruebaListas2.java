package Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class PruebaListas2 {

	public static void main(String[] args) {
		String texto ="Elements . An ordered collection (also known as a sequence). "
				+ "and the user can access elements by their integer index (position in the list)"
				+ ", and search for elements in the list list.";
				
		List<String> palabras = new ArrayList<String>();
		String[] pals = texto.split("[^A-Za-záéíóúÁÉÍÓÚ]+"); 
		palabras = Arrays.asList(pals);
		
		System.out.println("Número de palablras: "+ palabras.size());
		palabras.sort(String.CASE_INSENSITIVE_ORDER);
		
		/*ListIterator<String> it = palabras.listIterator(palabras.size());
		
		while (it.hasPrevious()) {
			System.out.println(it.previous() + ", ");
		}*/  
		
		Set<String> noRepes = new LinkedHashSet<String>();
		//ListIterator<String> cursor = 

	}

}
