package quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class qaBank {

	private static final String QUESTIONS_FILE_PATH = "questions.txt";
    private static final String ANSWER_OPTIONS_FILE_PATH = "answerOptions.txt";
	
	public String getQuestion(int questionIndex) {
				// Discrete Mathematics: q=0,1,2,3,4,5 | Novice:0,1 | Intermediate: 2,3 | Advanced: 4,5
				// Computer Science: q=6,7,8,9,10,11 | Novice:6,7 | Intermediate: 8,9 | Advanced: 10,11
				//Computer Organization: q=12,13,14,15,16,17 | Novice:12,13 | Intermediate: 14,15 | Advanced: 16,17
		try {
			BufferedReader br = new BufferedReader(new FileReader(QUESTIONS_FILE_PATH));
			String line = "";
			try {
				for (int i = 0; i < questionIndex; i++) {
					br.readLine();
				}
				while ((line = br.readLine()) != null) {
					br.close();
					return line;
				}
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {System.out.println("File was not found");}
		return "";
	}

	public String getAnswer(int questionIndex, int answerIndex) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(ANSWER_OPTIONS_FILE_PATH));
			String line = "";
			try {
				for (int k = 0; k < questionIndex; k++) {
					br.readLine();
				}
				while ((line = br.readLine()) != null) {
					br.close();
					return line.split("-")[answerIndex];
				}
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {System.out.println("File was not found");}
		return "";
		}
	
	public int getCorrectAnswer(int questionIndex) {// k+1 = question number, returns corresponding correct INDEX value for answerChoice method
		int[] correctAnswer = {3,1,1,2,1,1,2,1,0,3,1,0,0,2,1,3,2,1};
		return correctAnswer[questionIndex];
	}
}
