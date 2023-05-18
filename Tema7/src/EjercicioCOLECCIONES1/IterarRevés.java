package EjercicioCOLECCIONES1;

import java.util.*;

public class IterarRevés {

	public static void main(String[] args) {
		
		int[] numsArr = {12,74,25,9,31,41,20};
		List<Integer> nums = new ArrayList<Integer>();

		for (Integer i : numsArr) {
			nums.add(i);
		}//for
		
		System.out.println("<<< orden asc >>>");
		nums.sort(null);
		for (Integer i : nums) {
			System.out.println(i);
		}//
		System.out.println();
		
		System.out.println("<<< orden desc >>>");
		ListIterator<Integer> it = nums.listIterator(nums.size());
		/*while (it.hasNext()) {
			it.next();
		}*/
		while (it.hasPrevious()) {
			int a= it.previous();
			System.out.println(a );
		}

	}

}
