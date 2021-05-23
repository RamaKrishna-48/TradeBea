package TradeBea;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java {

	public static void main(String[] args) {
		swap();
		findingSecondHighestNumber();
		findingDup();
		findingduplicateaName();
		findDulicatevaleue();
		findingduplicate();
		
	}

	public static void swap() {
		int a = 20;
		int b = 10;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a is " + a + "  b is " + b);

	}

	public static void findingSecondHighestNumber() {
		int array[] = { 1, 3, 5, 12, 9, 28 };
		Arrays.sort(array);
		System.out.println("second highest number is" + array[array.length - 2]);
	}

	public static void findingDup() {
		int array[] = { 1, 3, 5, 12, 9, 28, 1 };
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++)
			if (array[i] == array[i + 1]) {
				System.out.println("duplicate number is" + array[i]);
			}
	}
	


	public static void findDulicatevaleue() {
		String duplicates[] ={ "java", "spring", "hibernate", "java" };
		Arrays.sort(duplicates);
		for (int i = 0; i < duplicates.length - 1; i++) {
			if (duplicates[i] == duplicates[i + 1]) {
				System.out.println("duplicate string is:" +duplicates[i]);
			}
		}
	}
	//compare each element
		public static void findingduplicateaName() {
			String array[] = { "ram", "krishna", "kiran", "kalyan", "kiran" };
			for (int i = 0; i <= array.length; i++) {
				for (int j = i + 1; j < array.length; j++) {
					if (array[i].equals(array[j])) {
						System.out.println("duplicate element is:" + array[i]);
					}

				}

			}

		}

	// using hashset
	public static void findingduplicate() {
		String array[] = { "ram", "krishna", "kiran", "kalyan", "kiran", "kiran", "krishna", "kalyan", "ram" };
		Set<String> store = new HashSet<String>();
		for (String name : array) {
			if (store.add(name) == false) {
				System.out.println("duplicate element is:" + name);
			}
		}
	}

	
}