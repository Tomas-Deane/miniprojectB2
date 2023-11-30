package quiz;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import user.User;

public class Quiz {
    private User u;
    private int quizType, mark; // quiztype 0 = inc difficulty, 1 = random, 2 = timed
    private double time;

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getQuizType() {
        return quizType;
    }

    public void setQuizType(int quizType) {
        if (quizType >= 0 && quizType <= 2) {
            this.quizType = quizType;
        } else {
            System.out.println("Quiz Type outside valid range");
        }
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void writeTimerResult(){
        try {
            File myObj = new File("timerResults.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("timerResults.txt", true));

            Scanner reader = new Scanner("timerResults.txt");
            while (reader.hasNextLine()) {
                reader.nextLine();

            }
            reader.close();

            writer.write(u.getID() + " " + this.getQuizType() + " " + u.getUsername() + " " + this.getMark() + " " +this.getTime()+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findResultPathname() {
        String pathnameString = "";
        switch (this.quizType) {
            case 0:
                pathnameString = "incDiffResults.txt";
                break;
            case 1:
                pathnameString = "randResults.txt";
                break;
            case 2:
                writeTimerResult();
                break;
        }
        return pathnameString;
    }

    public void writeResult() {
        String pathnameString = findResultPathname();
        try {
            File myObj = new File(pathnameString);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathnameString, true));
    
            Scanner reader = new Scanner(pathnameString);
            while (reader.hasNextLine()) {
                reader.nextLine();
            }
            reader.close();
    
            writer.write("\n"+u.getID() + " " + this.getQuizType() + " " + u.getUsername() + " " + this.getMark()+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
