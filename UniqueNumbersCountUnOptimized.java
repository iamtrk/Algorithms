package date;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Combinations.
 */
public class UniqueNumbersCountUnOptimized {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UniqueNumbersCountUnOptimized.class.getName());
	
	/** The cnt. */
	private static int cnt = 0;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueNumbersCountUnOptimized obj = new UniqueNumbersCountUnOptimized();
		int n = 123456789;
		
		logger.info("similar numbers count is:"+obj.solution(n));
		

	}
	
	
	
	/**
	 * Solution.
	 *
	 * @param n the n
	 * @return the number of similar numbers
	 */
	public static int solution(int n) {

		// corner scenarios. Here n should be positive integer only
		if (n <= 0) {
			return 0;
		}

		List<Integer> numbers = new ArrayList<Integer>();

		Integer number = n;

		// convert the number into list of numbers. for instance 1213
		// becomes[1,2,1,3]

		while (number > 0) {

			numbers.add(number % 10);

			number = number / 10;

		}

		logger.info("digits in number are :"+numbers);
		

		// if numbers size is not null and one for instance single digit numbers
		if (numbers != null && numbers.size() == 1) {
			return 1;
		}

		// if all digits in numbers array are same

		if (isAllNumbersSame(numbers)) {
			return 1;
		}

		// convert the list to array
		int[] temp = new int[numbers.size()];

		for (int i = 0; i < numbers.size(); i++) {
			temp[i] = numbers.get(i);

		}

		

		HashSet<Integer> similarNumberSet = new HashSet<Integer>();

		getAllSimilarNumbers(temp, 0, similarNumberSet);

		logger.info("similarNumbers Count is :"+similarNumberSet);		

		return similarNumberSet.size();

	}

	/**
	 * Checks if is all numbers same.
	 *
	 * @param numbers the numbers
	 * @return true, if is all numbers same
	 */
	public static boolean isAllNumbersSame(List<Integer> numbers) {
		return new HashSet<Integer>(numbers).size() == 1;
	}

	/**
	 * Gets the all similar numbers.
	 *
	 * @param numbers the numbers
	 * @param k the k
	 * @param similarNumberSet the similar number set
	 * @return the all similar numbers
	 */
	private static void getAllSimilarNumbers(int[] numbers, int index, HashSet<Integer> similarNumberSet) {
		if (index == numbers.length) {
			String number = "";

			for (int i = 0; i < numbers.length; i++) {

				number = number.concat(Integer.toString((numbers[i])));

			}

			try {
				Integer similarnumber = Integer.parseInt(number);
				
				similarNumberSet.add(similarnumber);
				
				
			} catch (NumberFormatException numberFormatException) {

				logger.severe("exception thrown is :" + numberFormatException.getMessage());
			}

		} else {
			for (int i = index; i < numbers.length; i++) {
				int temp = numbers[index];
				numbers[index] = numbers[i];
				numbers[i] = temp;

				getAllSimilarNumbers(numbers, index + 1, similarNumberSet);

				temp = numbers[index];
				numbers[index] = numbers[i];
				numbers[i] = temp;
			}
		}
	}
	
	

}

