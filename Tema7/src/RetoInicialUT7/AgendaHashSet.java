
package RetoInicialUT7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AgendaHashSet {

	protected static final int TAMANO_POR_DEFECTO = 100;

	protected Set<Contacto> contactos; // A sustituir por un ArrayLIst
	protected int numElementos;

	public AgendaHashSet(int tamano) {
		contactos = new HashSet<Contacto> (TAMANO_POR_DEFECTO);
		numElementos = 0;
	}

	public AgendaHashSet() { this(TAMANO_POR_DEFECTO); }
	
	public int numContactos() {
		return contactos.size();
	}
	
	public boolean vacia() {
		return contactos.isEmpty();
	}
	
	public String listaContactos() {
		StringBuilder res = new StringBuilder();
		for (int i=0; i<contactos.size(); i++) {
			// Muestra posiciones de 1 a numelementos
			res.append(i+1);
			res.append(": ");
			//res.append(contactos.get(i));
			res.append("\n");
		}
		return res.toString();
		//return contactos.toString();
	}

	public boolean anadeContacto(Contacto c) {
		return contactos.add(c);
	}

	public boolean borraContacto(String nombre) {
		//2.cambio el parámetro a tipo String con nombre
		//y creo contacto nuevo con ese nombre para luego borrarlo
		Contacto c1 = new Contacto(nombre,null);				
		return contactos.remove(c1);
	}

	/*public boolean reemplazaContacto(int posicion, Contacto c) {
		return contactos.set(posicion, c);
	}*/
	
	//no se puede hacer un get con un objeto porque contaisn devuelve boolean y no nos da acceso.
	/*public Contacto getContacto(int posicion) {
		return contactos.get(posicion);
	}*/

	/*public int buscaContacto (Contacto c) {
		return contactos.indexOf(c);
	}*/

}
