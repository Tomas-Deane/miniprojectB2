package quiz;

import java.util.Random;

public class QuizFormats {

    	public int[] getQuestionIndices(boolean increasingDifficulty) {//increasingDifficulty=true: Increasing difficulty. False: Random Questions
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		if (increasingDifficulty) {
			return arr;
		} else {
			Random rand = new Random();
			for (int i = 0; i < arr.length; i++) {
				int randomIndexToSwap = rand.nextInt(arr.length-1);

				int temp = arr[randomIndexToSwap];
				arr[randomIndexToSwap] = arr[i];
				arr[i] = temp;
				}
				}
			return arr;
		}

        public long startTimer() { //method to begin timer
            long startTime = System.currentTimeMillis();
            return startTime;
        }
        public  void endTimer(long startTime, Quiz q) { //method to end timer and return elapsed time
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            q.setTime(elapsedTime / 1000.0); 
        }
}
