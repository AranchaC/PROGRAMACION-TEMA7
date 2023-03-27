import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

// Pruebas iniciales de conjuntos y listas
public class PruebaTiposDeConjuntos {
	public static void main(String[] args) {
		// Copiamos un texto en una variable String
		//String texto = "A Collection represents a group of objects known as its elements. The Collection interface is used to pass around collections of objects where maximum generality is desired. For example, by convention all general-purpose collection implementations have a constructor that takes a Collection argument. This constructor, known as a conversion constructor, initializes the new collection to contain all of the elements in the specified collection, whatever the given collection's subinterface or implementation type. In other words, it allows you to convert the collection's type.";
		String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lantejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas, con sus pantuflos de lo mesmo, y los días de entresemana se honraba con su vellorí de lo más fino. Tenía en su casa una ama que pasaba de los cuarenta y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza que así ensillaba el rocín como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años. Era de complexión recia, seco de carnes, enjuto de rostro, gran madrugador y amigo de la caza. Quieren decir que tenía el sobrenombre de «Quijada», o «Quesada», que en esto hay alguna diferencia en los autores que deste caso escriben, aunque por conjeturas verisímiles se deja entender que se llamaba «Quijana». Pero esto importa poco a nuestro cuento: basta que en la narración dél no se salga un punto de la verdad.\n"
				+ "\n"
				+ "Es, pues, de saber que este sobredicho hidalgo, los ratos que estaba ocioso \"que eran los más del año\", se daba a leer libros de caballerías, con tanta afición y gusto, que olvidó casi de todo punto el ejercicio de la caza y aun la administración de su hacienda; y llegó a tanto su curiosidad y desatino en esto, que vendió muchas hanegas de tierra de sembradura para comprar libros de caballerías en que leer, y, así, llevó a su casa todos cuantos pudo haber dellos; y, de todos, ningunos le parecían tan bien como los que compuso el famoso Feliciano de Silva, porque la claridad de su prosa y aquellas entricadas razones suyas le parecían de perlas, y más cuando llegaba a leer aquellos requiebros y cartas de desafíos, donde en muchas partes hallaba escrito: «La razón de la sinrazón que a mi razón se hace, de tal manera mi razón enflaquece, que con razón me quejo de la vuestra fermosura». Y también cuando leía: «Los altos cielos que de vuestra divinidad divinamente con las estrellas os fortifican y os hacen merecedora del merecimiento que merece la vuestra grandeza...»";
		
		// Creamos una lista y la llenamos con palabras del texto, repetidas algunas
		List<String> palabras = Arrays.asList(texto.toLowerCase().split("(\\s*[,.\"<>;«»]+\\s*|\\s+)"));
	
		// Creamos tres conjuntos
		Set<String> sinRepetidosHash =  new HashSet<String>(); //  HashSet();
		Set<String> sinRepetidosTree = new TreeSet<String>();
		Set<String> sinRepetidosLinked = new LinkedHashSet<String>();
		sinRepetidosHash.add("PRIMERA-INSERTADA");
		sinRepetidosTree.add("PRIMERA-INSERTADA");
		sinRepetidosLinked.add("PRIMERA-INSERTADA");
		sinRepetidosHash.addAll(palabras);
		sinRepetidosTree.addAll(palabras);
		sinRepetidosLinked.addAll(palabras);
		sinRepetidosHash.add("ULTIMA-INSERTADA");
		sinRepetidosTree.add("ULTIMA-INSERTADA");
		sinRepetidosLinked.add("ULTIMA-INSERTADA");
			
		System.out.println("Palabras en texto: " + palabras.size());
		System.out.println("Palabras no repetidas+2: " + sinRepetidosHash.size() + ", " + sinRepetidosTree.size() + 
				", " + sinRepetidosLinked.size());

		// tiempos de recorrido: Los long para medir tiempos en nanosegundos
		long t1,t2,t3,t4;
		String palabra;
		System.out.println("Tiempos de recorrido con forEach sin hacer nada con cada elemento");
		t1 = System.nanoTime();
		sinRepetidosHash.forEach(x -> {}); // no deja dejarlo vacío, pongo función lambda que no hace nada
		t2 = System.nanoTime();
		sinRepetidosTree.forEach(x -> {});
		t3 = System.nanoTime();
		sinRepetidosLinked.forEach(x -> {});
		t4 = System.nanoTime();
		System.out.printf("Hash   : %12.3f ms\n",((float)(t2-t1))/1000000);
		System.out.printf("Tree   : %12.3f ms\n",((float)(t3-t2))/1000000);
		System.out.printf("Linked : %12.3f ms\n",((float)(t4-t3))/1000000);

		Iterator<String> itHash = sinRepetidosHash.iterator();
		Iterator<String> itTree = sinRepetidosTree.iterator();
		Iterator<String> itLinked = sinRepetidosLinked.iterator();
		System.out.println("Tiempos de recorrido con iterator sin hacer nada con cada elemento");
		t1 = System.nanoTime();
		while (itHash.hasNext()) itHash.next(); // no hacemos nada con los elementos visitados
		t2 = System.nanoTime();
		while (itTree.hasNext()) itTree.next(); // no hacemos nada con los elementos visitados
		t3 = System.nanoTime();
		while (itLinked.hasNext()) itLinked.next();// no hacemos nada con los elementos visitados
		t4 = System.nanoTime();
		System.out.printf("Hash   : %12.3f ms\n",((float)(t2-t1))/1000000);
		System.out.printf("Tree   : %12.3f ms\n",((float)(t3-t2))/1000000);
		System.out.printf("Linked : %12.3f ms\n",((float)(t4-t3))/1000000);
		
		
		System.out.println("Tiempos de recorrido con stream sin hacer nada con cada elemento (contarlos");
		t1 = System.nanoTime();
		sinRepetidosHash.stream().count();
		t2 = System.nanoTime();
		sinRepetidosTree.stream().count();
		t3 = System.nanoTime();
		sinRepetidosLinked.stream().count();
		t4 = System.nanoTime();
		System.out.printf("Hash   : %12.3f ms\n",((float)(t2-t1))/1000000);
		System.out.printf("Tree   : %12.3f ms\n",((float)(t3-t2))/1000000);
		System.out.printf("Linked : %12.3f ms\n",((float)(t4-t3))/1000000);
		// orden aleatorio
		System.out.println("Conjunto Hash:" + sinRepetidosHash);
		// ordenados por método natural del objeto
		System.out.println("Conjunto Tree:" + sinRepetidosTree);
		// ordenador por tiempo de inserción
		System.out.println("Conjunto LinkedHash:" + sinRepetidosLinked);

	} // main
} // class
