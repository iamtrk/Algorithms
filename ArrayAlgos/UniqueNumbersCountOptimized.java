package date;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumbersCountOptimized {

	public static void main(String[] args) {
		int n = 123456789;

		UniqueNumbersCountOptimized uniqueNumbersCount = new UniqueNumbersCountOptimized();

		System.out.println(uniqueNumbersCount.returnuniqueCount(n));

	}

	public static int fact(int n) {
		if (n == 0)
			return 1;
		else
			return n * fact(n - 1);
	}

	public int returnuniqueCount(int n) {
		// TODO Auto-generated method stub

		int result = 0;

		if (n <= 0)
			return 0;

		
		String s = String.valueOf(n);

		int actual_length = s.length();

		if (actual_length == 1)
			return 1;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < actual_length; i++) {
			if (map.containsKey(s.charAt(i))) {
				int count = map.get(s.charAt(i));
				count++;

				map.put(s.charAt(i), count);
			} else {
				map.put(s.charAt(i), new Integer(1));
			}

		}

		if (map.keySet().size() == 1)
			return 1;

		if (map.keySet().size() == actual_length)
			result = fact(actual_length);

		else if (map.keySet().size() > 1 && map.keySet().size() != actual_length) {

			int divisior = 1;

			for (char ch : map.keySet()) {

				if (map.get(ch) > 1) {
					divisior = divisior * fact(map.get(ch));
				}
			}

			result = fact(actual_length) / divisior;

		}

		return result;

	}

}

