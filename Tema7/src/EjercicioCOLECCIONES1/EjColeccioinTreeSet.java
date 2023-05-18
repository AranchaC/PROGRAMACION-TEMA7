package EjercicioCOLECCIONES1;

import java.util.*;

public class EjColeccioinTreeSet {

	public static void main(String[] args) {
		Set<String> ordenaGente = new TreeSet<String>();
		ordenaGente.add("Oscar");
		ordenaGente.add("María");
		ordenaGente.add("Ana");
		ordenaGente.add("Eva");
		
		for (String s : ordenaGente) {
			System.out.println(s);
		}
		
		System.out.println();
		
		Productos comparador = new Productos();		
		
		Set<Productos> ordenaProd = new TreeSet<Productos>(comparador);
		ordenaProd.add( new Productos(3, "esta es la descrip del Tercer Prod"));
		ordenaProd.add( new Productos(7, "Séptimo"));
		ordenaProd.add( new Productos(2, "Segundo Prod"));
		
		for (Productos p : ordenaProd) {
			System.out.println(p.getDescrip());
		}
	}

}//class

class Productos implements Comparable<Productos>, Comparator<Productos> {
	private int numProd;
	private String descrip;
	
	public Productos() {};
	
	public Productos(int numProd, String descrip) {
		super();
		this.numProd = numProd;
		this.descrip = descrip;
	}
	
	@Override
	public String toString() {
		return "Productos [numProd=" + numProd + ", descrip=" + descrip + "]";
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	@Override
	public int compareTo(Productos o) {
		return numProd - o.numProd;
	}

	@Override
	public int compare(Productos o1, Productos o2) {
		int a = o1.getDescrip().length();
		int b = o2.getDescrip().length();
		return a-b;
	}
	
}
