package TradeBea;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class jaavaa {

	public static void main(String[] args) {
		String str = "ramakrishna";
		Map<Character, Integer> count = new HashMap<>();
		for (Character c : str.toCharArray()) {
			if (count.containsKey(c)) {
				count.put(c, count.get(c) + 1);
			} else {
				count.put(c, 1);
			}

		}
		System.out.println(count);
		
		dupString();
		reverse();
		wordFinding();
		remove();
		findingMaxAndMin();
		findSecondHighestNumber();
	}
public static void reverse() {
	

	StringBuffer buffer=new StringBuffer("rama");
	System.out.println(buffer.reverse());
	
}
public static void wordFinding() {
	String str="raam, ram. kiran";
	Boolean found=str.contains("ram");
	System.out.println(found);
}
public static void remove() {
	String str="1235adtafDcg!233";
	str=str.replaceAll("[^a-z]", "");
	System.out.println(str);
}

public static void findingMaxAndMin() {
	int array[]= {1,3,5,7,12,14,78};
	int max=array[0];
	int min=array[0];
	for(int i=0;i<=array.length-1;i++) {
		if( array[i]>=max) {
			max=array[i];}
		if(array[i]<=min) {
			min=array[i];}
			
		}
	System.out.println("min number is:"+min+ "max number is:"+max);
	}
public static void findSecondHighestNumber() {
	String []array= {"1","2","3"};
	Arrays.sort(array);
	System.out.println("second Highest Number is"+array[array.length-2]);
	
}
	
	public static void dupString() {
		String str[]= {"ram","java","ram"};
		Set<String> stra=new HashSet<String>();
		for(String name:str) {
			if(stra.add(name)==false) {
				System.out.println(name);
			}
		}
	}
}



