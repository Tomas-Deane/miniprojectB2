
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class QuizScreen implements ActionListener {
    User u = new User();
    Quiz q = new Quiz();
    qaBank bank = new qaBank();
    int[] qNums;
    int qPointer = 0;
    int marks = 0;

    long startTime = 0;
    // initialising frame and components
    static JFrame frame = new JFrame("Quiz");
    JPanel formatPanel = new JPanel();
    JPanel quizPanel = new JPanel();
    SpringLayout layout = new SpringLayout();
    // SpringLayout quizLayout = new SpringLayout();

    JLabel lblSelectFormat = new JLabel("Select a Quiz Format");
    ButtonGroup radiGroup = new ButtonGroup();
    JRadioButton radRandom = new JRadioButton("Random selection");
    JRadioButton radIncDiff = new JRadioButton("Increasing Difficulty");
    JRadioButton radTimed = new JRadioButton("Timed");
    JButton btnStart = new JButton("Start Quiz");
    JLabel lblQuestion = new JLabel("question");
    JButton btnAnsZero = new JButton("a0");
    JButton btnAnsOne = new JButton("a1");
    JButton btnAnsTwo = new JButton("a2");
    JButton btnAnsThree = new JButton("a3");
    JLabel lblMarks = new JLabel("Marks: " + marks);
    //JLabel lblAStatus = new JLabel();
    ButtonGroup ansGroup = new ButtonGroup();

    public QuizScreen(User u) {
        this.u = u;
        q.setU(u);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set background color
        formatPanel.setBackground(Color.CYAN);
        quizPanel.setBackground(Color.CYAN);
        radIncDiff.setBackground(Color.cyan);
        radRandom.setBackground(Color.cyan);
        radTimed.setBackground(Color.cyan);
        // set title font
        lblSelectFormat.setFont(new Font("", Font.BOLD, 20));
        lblQuestion.setFont(new Font("", Font.BOLD, 14));
        lblMarks.setFont(new Font("", Font.BOLD, 20));
        //lblAStatus.setFont(new Font("", Font.BOLD, 20));
        // set format panel size/layout
        formatPanel.setSize(1200, 800);
        formatPanel.setLayout(layout);
        // setup radio button group
        radiGroup.add(radIncDiff);
        radiGroup.add(radRandom);
        radiGroup.add(radTimed);

        ansGroup.add(btnAnsZero);
        ansGroup.add(btnAnsOne);
        ansGroup.add(btnAnsTwo);
        ansGroup.add(btnAnsThree);
        // add components to format panel
        formatPanel.add(lblSelectFormat);
        formatPanel.add(radIncDiff);
        formatPanel.add(radRandom);
        formatPanel.add(btnStart);
        formatPanel.add(radTimed);

        quizPanel.setVisible(false);
        quizPanel.add(lblQuestion);
        //quizPanel.add(lblAStatus);
        quizPanel.add(btnAnsZero);
        quizPanel.add(btnAnsOne);
        quizPanel.add(btnAnsTwo);
        quizPanel.add(btnAnsThree);
        quizPanel.add(lblMarks);
        // set quiz panel size/layout
        quizPanel.setSize(1200, 800);
        quizPanel.setLayout(layout);

        // Spring layout constraints
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblSelectFormat, 0, SpringLayout.HORIZONTAL_CENTER,
                formatPanel);
        layout.putConstraint(SpringLayout.NORTH, lblSelectFormat, 5, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, radIncDiff, -100, SpringLayout.HORIZONTAL_CENTER,
                formatPanel);
        layout.putConstraint(SpringLayout.NORTH, radIncDiff, 40, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, radTimed, 0, SpringLayout.HORIZONTAL_CENTER,
                formatPanel);
        layout.putConstraint(SpringLayout.NORTH, radTimed, 40, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, radRandom, 100, SpringLayout.HORIZONTAL_CENTER,
                formatPanel);
        layout.putConstraint(SpringLayout.NORTH, radRandom, 40, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnStart, 0, SpringLayout.HORIZONTAL_CENTER, formatPanel);
        layout.putConstraint(SpringLayout.NORTH, btnStart, 80, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblQuestion, 0, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.NORTH, lblQuestion, 50, SpringLayout.NORTH, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsZero, -200, SpringLayout.HORIZONTAL_CENTER,
                quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsZero, -50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsOne, 200, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsOne, -50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsTwo, -200, SpringLayout.HORIZONTAL_CENTER,
                quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsTwo, 50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsThree, 200, SpringLayout.HORIZONTAL_CENTER,
                quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsThree, 50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.WEST, lblMarks, 10, SpringLayout.WEST, quizPanel);
        layout.putConstraint(SpringLayout.SOUTH, lblMarks, -10, SpringLayout.SOUTH, quizPanel);

        //layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblAStatus, 0, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        //layout.putConstraint(SpringLayout.VERTICAL_CENTER, lblAStatus, 0, SpringLayout.VERTICAL_CENTER, quizPanel);

        btnStart.addActionListener(this);
        btnStart.setActionCommand("startQuiz");

        btnAnsZero.addActionListener(this);
        btnAnsZero.setActionCommand("a0");

        btnAnsOne.addActionListener(this);
        btnAnsOne.setActionCommand("a1");

        btnAnsTwo.addActionListener(this);
        btnAnsTwo.setActionCommand("a2");

        btnAnsThree.addActionListener(this);
        btnAnsThree.setActionCommand("a3");

        //lblAStatus.setVisible(false);

        frame.add(formatPanel);
        frame.add(quizPanel);
        frame.pack();
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "startQuiz":
                if (radIncDiff.isSelected()) {
                    q.setQuizType(0);
                    startQuiz(true);
                } else if (radRandom.isSelected()) {
                    q.setQuizType(1);
                    startQuiz(false);
                }else if(radTimed.isSelected()){
                    q.setQuizType(2);
                    startQuiz(true);
                }
                 else {
                    JOptionPane.showMessageDialog(null, "Select a format");
                }
                break;
            case "a0":
                nextQuestion(0);
                break;
            case "a1":
                nextQuestion(1);
                break;
            case "a2":
                nextQuestion(2);
                break;
            case "a3":
                nextQuestion(3);
                break;
        }
    }

    public void startQuiz(boolean incOrRand) {
        formatPanel.setVisible(false);
        quizPanel.setVisible(true);
        if(q.getQuizType()==2){
            startTime = startTimer();
        }
        qNums = bank.incOrRand(incOrRand);
        nextQuestion(-1);
    }

    public void nextQuestion(int answerChoice) {
        try {
            if (answerChoice >= 0) {
                int correctAns = bank.correctAnswer(qNums[qPointer]);
                if (answerChoice == correctAns) {
                    marks++;
                    lblMarks.setText("Marks: " + marks);
                    //lblAStatus.setText("Correct!");
                    //lblAStatus.setBackground(Color.GREEN);
                }
                
                //lblAStatus.setVisible(true);
                qPointer++;
                
                //lblAStatus.setVisible(false);
            }
            lblQuestion.setText("<html><pre>" + bank.returnQuestion(qNums[qPointer]) + "</pre></html>");
        } catch (ArrayIndexOutOfBoundsException e) {
            //end quiz
            endQuiz();
            return;
        }
        try {
            btnAnsTwo.setVisible(true);
            btnAnsThree.setVisible(true);
            btnAnsZero.setText(bank.returnAnswer(qNums[qPointer], 0));
            btnAnsOne.setText(bank.returnAnswer(qNums[qPointer], 1));
            btnAnsTwo.setText(bank.returnAnswer(qNums[qPointer], 2));
            btnAnsThree.setText(bank.returnAnswer(qNums[qPointer], 3));
        } catch (ArrayIndexOutOfBoundsException e) {
            btnAnsTwo.setVisible(false);
            btnAnsThree.setVisible(false);
        }

    }
    public void endQuiz(){
        q.setMark(marks);
        if(q.getQuizType()==2){
            endTimer(startTime);
        }
        new QuizOver(u,q);
        frame.dispose();
    }
    public long startTimer() { //method to begin timer
		long startTime = System.currentTimeMillis();
        return startTime;
	}
	public  void endTimer(long startTime) { //method to end timer and return elapsed time
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        q.setTime(elapsedTime / 1000.0); 

	}
}