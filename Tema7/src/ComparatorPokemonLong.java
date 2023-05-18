import java.util.Comparator;

public class ComparatorPokemonLong implements Comparator<Pokemon>{

	@Override
	public int compare(Pokemon o1, Pokemon o2) {
		return o1.getNombre().length() - o2.getNombre().length();
	}

}
