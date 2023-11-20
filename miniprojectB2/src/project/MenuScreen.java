

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

//import java.awt.Dimension;
//import java.awt.Toolkit;
public class MenuScreen implements ActionListener {
    // initialising User object
    static User u;
    // initialising frame variables and components
    static JFrame frame = new JFrame("Menu");
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();
    JButton btnQuiz = new JButton("Quiz", null);
    JButton btnStats = new JButton("Statistics", null);
    JLabel lblUsername = new JLabel("Username: ");
    JLabel lblMenu = new JLabel("Select an option");

    // constructor
    public MenuScreen(User u) {

        MenuScreen.u = u;
        // JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.CYAN);
        lblUsername.setText(lblUsername.getText() + "" + u.getUsername());
        lblUsername.setFont(new Font("", Font.PLAIN, 16));
        lblMenu.setFont(new Font("", Font.BOLD, 20));
        panel.setSize(700, 500);
        panel.setLayout(layout);
        panel.add(btnQuiz);
        panel.add(btnStats);
        panel.add(lblUsername);
        panel.add(lblMenu);
        // lblUsername CONSTRAINTS
        layout.putConstraint(SpringLayout.WEST, lblUsername, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblUsername, 50, SpringLayout.NORTH, panel);
        // lblMenu CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblMenu, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, lblMenu, 5, SpringLayout.NORTH, panel);
        // btnStats CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnStats,  50, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnStats, 0, SpringLayout.VERTICAL_CENTER, panel);
        // btnQuiz CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnQuiz, -50, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnQuiz, 0, SpringLayout.VERTICAL_CENTER, panel);

        frame.add(panel);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnQuiz.addActionListener(this);
        btnQuiz.setActionCommand("Quiz");
        btnStats.addActionListener(this);
        btnStats.setActionCommand("Stats");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Quiz":
                new QuizScreen(u);
                frame.dispose();
                break;
            case "Stats":
                new StatsScreen(u);
                frame.dispose();
                break;
        }
    }

}
