package TradeBea;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class character {

	public static void main(String[] args) {
		duplicateCharacter("ram ram ram kiran kiran kalyan krishna hari suresh radha radha");
		duplicateCharacter("ram ram ram kiran kiran kalyan krishna hari suresh radha radha");
	}

	public static void duplicateCharacter(String str) {
		//String str = "ram ram ram kiran kiran kalyan krishna hari suresh radha radha";
		String words[] = str.split("");
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		for (String word : words) {
			if (wordCount.containsKey(word)) {
				wordCount.put(word.toLowerCase(), wordCount.get(word) + 1);
			} else {
				wordCount.put(word, 1);
			}
		}
//extracting all keys map
		Set<String> WordsInString = wordCount.keySet();
		for (String word : WordsInString) {
			if (wordCount.get(word) > 1) {
				System.out.println(word + ":" + wordCount.get(word));
			}
		}
	}

}
