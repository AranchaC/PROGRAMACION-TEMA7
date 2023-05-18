package Multimedia;

import java.util.Comparator;
import java.util.Objects;

public class Multimedia {
	protected String título, autor;
	protected double duración;
	protected Formato formato;
	
	public Multimedia(String título, String autor, double duración, Formato formato ) {
		super();
		this.título = título;
		this.autor = autor;
		this.duración = duración;
		this.formato = formato;
	}//cierre constructor Multimedia	

	public String getTítulo() {
		return título;
	}	

	public void setTítulo(String título) {
		this.título = título;
	}	

	public String getAutor() {
		return autor;
	}	

	public void setAutor(String autor) {
		this.autor = autor;
	}	

	public double getDuración() {
		return duración;
	}	

	public void setDuración(double duración) {
		this.duración = duración;
	}	

	public Formato getFormato() {
		return formato;
	}	

	public void setFormato(Formato formato) {
		this.formato = formato;
	}	

	@Override
	public String toString() {
		return "Título= " + título + "\n Autor= " + autor + "\n Duración= " + duración+" \n Formato= "+formato+"\n" ; 
	}
/*
	@Override
	public int hashCode() {
		return Objects.hash(autor);
	}
*/
	@Override
	public boolean equals(Object obj) {
		Multimedia other = (Multimedia) obj;
		return Objects.equals(autor, other.autor);
	}
	

	
}
