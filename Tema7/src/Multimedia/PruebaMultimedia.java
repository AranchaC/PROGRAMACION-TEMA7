package Multimedia;

import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class PruebaMultimedia {

	public static void main(String[] args) {
		//ListaMultimedia obras = new ListaMultimedia (4);//ej4 
		List<Película> obras = new ArrayList();
		
		obras.add(new Película ("LA LA LAND","Damien Chazelle", 2.8, Formato.DVD, "RYAN GOSLING", "EMMA STONE"));
		obras.add(new Película ("LIBRO DE LA SELVA","Disney", 1.29, Formato.AVI, null, null));
		//obras.add(new Película ("TITANIC","James Cameron", 3.30, Formato.MP3, "LEO DI CAPRIO","KATE WINSLET"));
		obras.add(new Película ("VIUDA NEGRA","Marvel", 2.13, Formato.MOV, null, "SCARLETT JOHANSSON"));
		obras.add(new Película ("IRON MAN","Marvel", 2.6, Formato.MPG, "ROBERT DOWNEY JR", null));		
		/*obras.add(new Película ("HARRY POTTER 3","Alfonso Cuarón", 2.19, Formato.DVD, "DANIEL RADCLIFFE", null));
		obras.add(new Película ("PIRATAS DEL CARIBE","Disney", 2.23, Formato.AVI, "JOHNNY DEPP", "ORLANDO BLOOM"));
		obras.add(new Película ("GREEN BOOK","Peter Farrelly", 2.10, Formato.MPG, "VIGGO MORTENSEN", "MAHERSHALA ALI"));
		obras.add(new Película ("CRIADAS Y SEÑORAS","Tate Taylor", 2.26, Formato.MP3, "VIOLA DAVIS", "EMMA STONE"));
		obras.add(new Película ("ENOLA HOLMES","Netflix", 2.3, Formato.MOV, null, "MILLIE BOBBY BROWN"));
		*/
		//Collections.sort(obras);
		//System.out.println("===LISTA PELICULAS===\n"+obras);
		System.out.println();
		
		Set<Película> listaTree = new TreeSet<>(obras);
		for (Película p : listaTree) {
			System.out.println(p.hashCode()+"\n"+p.toString());
		}
			//System.out.println("\n===TREE PELICULAS===\n"+listaTree);
			
			
		//List<ListaMultimedia> lista = new ArrayList<ListaMultimedia>();
		/*List<Película> lista = Arrays.asList(
				new Película ("LA LA LAND","Damien Chazelle", 2.8, Formato.DVD, "RYAN GOSLING", "EMMA STONE"),
				new Película ("TITANIC","James Cameron", 3.30, Formato.MP3, "LEO DI CAPRIO","KATE WINSLET"),
				new Película ("PIRATAS DEL CARIBE","Disney", 2.23, Formato.AVI, "JOHNNY DEPP", "ORLANDO BLOOM"),
				new Película ("ENOLA HOLMES","Netflix", 2.3, Formato.MOV, null, "MILLIE BOBBY BROWN"),
				new Película ("CRIADAS Y SEÑORAS","Tate Taylor", 2.26, Formato.MP3, "VIOLA DAVIS", "EMMA STONE")
				);
		Collections.sort(lista, new ordenComparator());	
		System.out.println("LISTA comparator:\n"+lista);*/
		
		//Stream<String> streams = lista.stream().map(null);
		
	}

}
