package EjercicioCOLECCIONES1;

import java.util.*;

public class EjLinkedList {

	public static void main(String[] args) {
		 
		List<String> paises = new LinkedList<String>();
			paises.add("España");
			paises.add("Colombia");
			paises.add("Mexico");
			paises.add("Peru");
			for (String s : paises) {
				System.out.println(s);
			}
			System.out.println();
			
		List<String> capitales = new LinkedList<String>();
			capitales.add("Madrid");
			capitales.add("Bogotá");
			capitales.add("MexDF");
			capitales.add("Lima");
			for (String s : capitales) {
				System.out.println(s);
			}
			System.out.println();
			
		ListIterator<String> it1 = paises.listIterator();
		ListIterator<String> it2 = capitales.listIterator();
		while (it2.hasNext()) {
			if (it1.hasNext()) it1.next();
			it1.add(it2.next());
		}
		
		//opción2
		/*int index=0;
		while (it1.hasNext()) {
			it1.next();
			it1.add(capitales.get(index));
			index++;
		}*/
		
		for (String s : paises) {
			System.out.println(s);
		}
		System.out.println();
		
		it2 = capitales.listIterator();
		while (it2.hasNext()) {
			it2.next();
			if (it2.hasNext()) {
				it2.next();
				it2.remove();
			}
		}
		
		for (String s : capitales) {
			System.out.println(s);
		}
		
		
		
		
			
	}

}
