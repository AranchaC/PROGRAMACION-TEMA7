import java.util.*;

public class PruebaComparator {

	public static void main(String[] args) {
		//pasar comparator, con otra clase solo comparator o clase anonima aquí dentro
		Set<Pokemon> pokedex = new TreeSet<Pokemon>
			(				
				new ComparatorPokemonLong()
				
				/*new Comparator<Pokemon>(){
					@Override
					public int compare(Pokemon o1, Pokemon o2) {
						return o1.nombre.length() - o2.nombre.length();
					}
				}*/			
			);
		
		pokedex.add(new Pokemon("Bulbasur"));
		pokedex.add(new Pokemon("Charmander"));
		pokedex.add(new Pokemon("Squirtel"));
		pokedex.add(new Pokemon("Pikachu"));
		pokedex.add(new Pokemon("Meaw"));
		
		for (Pokemon pok : pokedex) {
			int a = pok.getNombre().length();
			System.out.println( a + ": "+pok);
		}
				
	}

}//class

class ComparatorPokemonLong implements Comparator<Pokemon>{

	@Override
	public int compare(Pokemon o1, Pokemon o2) {
		return o1.getNombre().length() - o2.getNombre().length();
	}

}
