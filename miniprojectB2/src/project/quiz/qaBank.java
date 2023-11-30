package quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class qaBank {

	private static final String QUESTIONS_FILE_PATH = "questions.txt";//Initialize question bank file path variable
	
	public String[] getQuestionInfo(int questionIndex) {//Index 0: Questions, Index 1,2,3,4: Answer options, Index 5: Index of correct answer option
				// Discrete Mathematics: q=0,1,2,3,4,5 | Novice:0,1 | Intermediate: 2,3 | Advanced: 4,5
				// Computer Science: q=6,7,8,9,10,11 | Novice:6,7 | Intermediate: 8,9 | Advanced: 10,11
				//Computer Organization: q=12,13,14,15,16,17 | Novice:12,13 | Intermediate: 14,15 | Advanced: 16,17
		String[] questionInfo = new String[3]; //Initialize String array
		try {
			BufferedReader br = new BufferedReader(new FileReader(QUESTIONS_FILE_PATH));
			try {
				for (int i = 0; i < questionIndex; i++) {//Skip to question specified by method arguments
					br.readLine();
				}
				while ((questionInfo[0] = br.readLine()) != null) { //Set index 0 to entire line
					questionInfo[2] = questionInfo[0].split("//")[2];// Set final index to third column
					questionInfo [1] = questionInfo[0].split("//")[1];// Set middle index to middle column
					questionInfo [0] = questionInfo[0].split("//")[0];// set first index to first column
					br.close();
					return questionInfo;
				}
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {System.out.println("File was not found");}
		return questionInfo;
	}
}
