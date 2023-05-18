import java.util.*;

public class PruebListSort {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
			nums.add(15);
			nums.add(8);
			nums.add(12);
			nums.add(3);
			
			Collections.sort(nums);
			System.out.println("--- collection sort ---"+nums);
			
		List<Integer> nums2 = new ArrayList<Integer>();
			nums2.add(15);
			nums2.add(8);
			nums2.add(12);
			nums2.add(3);
			
			nums2.sort(null);
			System.out.println("\n--- sort ---"+nums);

	}

}
