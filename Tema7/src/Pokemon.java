import java.util.Comparator;

public class Pokemon implements Comparable<Pokemon> {
	String nombre;

	public Pokemon(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + "]";
	}

	@Override
	public int compareTo(Pokemon o) {
		return nombre.compareTo(o.nombre);
	}
	

}
