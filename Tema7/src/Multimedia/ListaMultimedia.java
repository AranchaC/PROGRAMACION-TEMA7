package Multimedia;

import java.util.Arrays;

public class ListaMultimedia {
	protected int contador=0;
	protected Multimedia[] multimedia;	

	public ListaMultimedia(int num) {
		super();
		multimedia = new Multimedia[num];
	}	
	
	public int getContador() {
		return contador;
	}

	public void setContador(int num) {
		this.contador = num;
	}

	public Multimedia[] getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(Multimedia[] multimedia) {
		this.multimedia = multimedia;
	}	
	
	public int size() {		
		return contador;
	}
	
	public Multimedia get(int pos) {
		if (pos > multimedia.length) {
			System.out.println("ERROR");			
		}
		return multimedia[pos];
	}

	public boolean add(Multimedia m) {		
		if (contador == multimedia.length) {
			return false;
		}//if
		else {
			multimedia[contador] = m;	
			contador++;			
			return true;
			//;
			/*for (int i=0;i<contador;i++) {
				multimedia[contador] = m;*/
		}	
	}//boolean add
	
	public void sort() {
		Arrays.sort(multimedia);
	}
	
	@Override
	public String toString() {
		return  Arrays.toString(multimedia);
	}

}
