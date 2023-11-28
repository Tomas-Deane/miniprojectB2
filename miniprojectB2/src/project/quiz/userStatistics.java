package quiz;
import java.lang.Math;
public class userStatistics {
	public static double median(int[] results) { // Return median from array of quiz results
		double median = 0;
		int[] sortedResults = bubbleSort(results); // Sort results in order
		if ((sortedResults.length % 2) == 1) {
			median = sortedResults[sortedResults.length / 2];
		} else if ((sortedResults.length % 2) == 0) {
			median = (sortedResults[sortedResults.length / 2] + sortedResults[(sortedResults.length / 2) -1]) / 2;
		} else {
			System.out.println("Invalid array to calculate median");
		}
		return median;

	}

	public static double mean(int[] results) {
		double sum = 0;
		double mean = 0;
		for (int i = 0; i < results.length; i++) {
			sum += results[i];
		}
		mean = sum / results.length;
		return mean;
	}

	public static double standardDeviation(int[] input) {
		double mean = mean(input);
		double sumOfSquares = 0;
		for (int i = 0; i < input.length; i++) {
			sumOfSquares += Math.pow((input[i] - mean), 2);
		}
		return (Math.sqrt((sumOfSquares / input.length)));
	}

	private static int[] bubbleSort(int[] arr) {
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < arr.length - 1; i++) {
			swapped = false;
			for (j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			if (swapped == false)
				break;
		}
		return arr;
	}
}