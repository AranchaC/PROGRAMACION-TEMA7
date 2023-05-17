package EjercicioCOLECCIONES1;

import java.util.*;
import java.util.List;

public class PruebaLinkedList {

	public static void main(String[] args) {
		
		List<String> personas = new LinkedList<String>();
		personas.add("Arancha");
		personas.add("Irene");
		personas.add("Ana");
		personas.add("Lara");
		
		System.out.println(personas.size());
		
		//para agregar, quitar, mover, introducir en una posición
		//usamos iterator
		ListIterator<String> it = personas.listIterator();
		//voya a añadir a eva entre el 1 y el 2
		it.next();
		it.add("natalia");
		it.previous();
		it.add("sara");
		while (it.hasNext()) {
			String pal = it.next();
			if (pal.length()==3) it.remove();
		}
		
		for (String per : personas) {
			System.out.println(per);
		}

	}

}
