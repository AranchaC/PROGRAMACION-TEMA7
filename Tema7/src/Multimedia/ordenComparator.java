package Multimedia;

import java.util.Comparator;

public class ordenComparator implements Comparator<Película> {

	@Override
	public int compare(Película o1, Película o2) {
		int a = o1.getTítulo().length();
		int b = o2.getTítulo().length();
		if (a == b) return o1.compareTo(o2);
		return a-b;
	}

}
