package EjercicioCOLECCIONES1;

import java.util.*;
import java.util.List;

public class PruebaLinkedList {

	public static void main(String[] args) {
		
		List<String> personas = new LinkedList<String>();
		personas.add("arancha");
		personas.add("irene");
		personas.add("ana");
		personas.add("lara");
		
		System.out.println(personas.size()+" : "+personas);
		
		//para agregar, quitar, mover, introducir en una posición
		//usamos iterator
		ListIterator<String> it = personas.listIterator();
		//voya a añadir a eva entre el 1 y el 2
		it.next();
		it.add("eva");
		it.previous();
		it.add("sara");
		it.next();it.next();
		it.add("aza");
		
		int index=1;
		for (String per : personas) {
			System.out.println(index+": "+per);
			index++;
		}
		System.out.println();
		
		while (it.hasNext()) {
			String pal = it.next();
			if (pal.length()==3) it.remove();
		}
		
		for (String per : personas) {
			System.out.println(per);
		}

	}

}
