import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    

    public Quiz() {
        
    }

    public void writeResult() {
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
                return;
        }
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
                // writer.write("\n");
                reader.nextLine();

            }
            reader.close();

            writer.write("\n"+u.getID() + " " + this.getQuizType() + " " + u.getUsername() + " " + this.getMark()+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                // writer.write("\n");
                reader.nextLine();

            }
            reader.close();

            writer.write(u.getID() + " " + this.getQuizType() + " " + u.getUsername() + " " + this.getMark() + " " +this.getTime()+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

}
