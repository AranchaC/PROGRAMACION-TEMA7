package Listas;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class PruebaListasSara {
	static final int LETRAS_POR_LINEA = 30;
	
	public static void main(String args[]) { //puede entrar en examen
		
		String texto = "An ordered collection (also known as a sequence). The user of this this interface has precise precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.";
		
		List<String> palabras; // = new ArrayList<String>();
		
		String[] pals = texto.split("[^A-Za-záéíóúÁÉÍÓÚ]+"); //EL "+" SE PUEDE GENERAR MAS VECES
		palabras = Arrays.asList(pals); //pasa de un array a una lista (Arrays.asList)
				
		System.out.println("Numero de palabras: " + palabras.size());
		palabras.sort(new ComparadorPorLetras());
		System.out.println(palabras);
		/*palabras.sort(String.CASE_INSENSITIVE_ORDER);//ORDENA ALFABETICAMENTE SIN TENER EN CUENTA MAYUSCULAS Y MINUSCULAS Y CON REVERSED DE FORMA REVERSA
				
		/*Set<String> noRepes = new LinkedHashSet<String>();
		
		ListIterator<String> it = palabras.listIterator(palabras.size());
	
		/*while(it.hasPrevious()) {
				noRepes.add(it.previous());
		}*/
		Set<String> noRepes = new TreeSet<String> (String.CASE_INSENSITIVE_ORDER);
		noRepes.addAll(palabras);
		System.out.println("No repes: " + noRepes.size());
			
		
		Iterator<String> cursor = noRepes.iterator();
		int contadorLetras = 0 ;
		while(cursor.hasNext()) {
			String separador = ",";
			String palabra = cursor.next()+separador;
			//contadorLetras += palabra.length();
			
			char[] caracteres = palabra.toCharArray();
			contadorLetras = caracteres.length;
			for (int i=0;  i<LETRAS_POR_LINEA; i++) {
				System.out.println(caracteres[i]);
			}
					
			/*if (contadorLetras>=LETRAS_POR_LINEA) {
				System.out.println();
				contadorLetras=caracteres.length;
			}
			System.out.print(caracteres);*/
			
			/*if(contadorLetras %10 ==0) System.out.println(); //CADA 10 PALABRAS HACE UN SALTO DE LINEA
			contadorLetras++;*/
		}
		

		/*Iterator<String> it = palabras.iterator();
		while(it.hasNext()) { //hasNext pregunta si queda alguno mas 
			System.out.println(it.next()); //tAMBIEN SE PUEDE RECORRER ASI UN CONJUNTO
		}*/
		
		
	
		
		/*
		
		
		ListIterator<String> it = palabras.listIterator(palabras.size());
		String anterior = "";
		while(it.hasPrevious()) {
			String actual = it.previous();
			if(! actual.equals(anterior)) {
			
			System.out.print(actual + ",");
		}
			anterior = actual;
		}
		*/
		
	
		
		/*
		for(String pal : palabras) {
			System.out.println(noRepes.add(pal)+ ":" + pal);
		}
		
		*/
	}//main

	private static Object anterior() {
		// TODO Auto-generated method stub
		return null;
	}
	
}//class