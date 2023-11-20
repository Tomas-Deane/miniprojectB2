public class Timer {
	
	/* In main method:
	*  Timer quizTimer = new Timer();
	*  quizTimer.start();
	*  double elapsedTime = quizTimer.end();
	*/
	
	private long startTime;
	
	public void startTimer() { //method to begin timer
		startTime = System.currentTimeMillis();
	}
	public double end() { //method to end timer and return elapsed time
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return elapsedTime / 1000.0;
	}
}