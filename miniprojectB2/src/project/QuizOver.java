import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
public class QuizOver implements ActionListener {
    User u = new User();
    Quiz q;
    static JFrame frame = new JFrame("Quiz Over");
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();
    JButton btnNext = new JButton("Exit to Menu", null);
    JLabel lblUsername = new JLabel("Username: ");
    JLabel lblMark = new JLabel();
    JLabel lblTime = new JLabel();
    JLabel lblTitle = new JLabel("Quiz Over");

    public QuizOver(User u, Quiz q) {
        this.u = u;
        this.q = q;
        q.writeResult();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.CYAN);
        lblUsername.setText(lblUsername.getText() + "" + u.getUsername());
        lblMark.setText("Mark: "+q.getMark()+"/18");
        lblMark.setFont(new Font("", Font.BOLD, 20));
        lblTime.setText("Time taken: "+q.getTime()+"s");
        lblTime.setFont(new Font("", Font.BOLD, 20));
        lblTitle.setFont(new Font("", Font.BOLD, 20));
        lblUsername.setFont(new Font("", Font.BOLD, 20));
        panel.setSize(700, 500);
        panel.setLayout(layout);
        panel.add(btnNext);
        panel.add(lblMark);
        panel.add(lblTime);
        
        panel.add(lblUsername);
        panel.add(lblTitle);
        // lblUsername CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblUsername, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, lblUsername, -50, SpringLayout.VERTICAL_CENTER, panel);
        // lblTitle CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTitle, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, lblTitle, 20, SpringLayout.NORTH, panel);
        // lblTime CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTime, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, lblTime, 20, SpringLayout.VERTICAL_CENTER, panel);
        // lblMark CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblMark, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, lblMark, 50, SpringLayout.VERTICAL_CENTER, panel);
        // btnNext CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnNext, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnNext, 80, SpringLayout.VERTICAL_CENTER, panel);

        
        if(q.getQuizType()==2){
            lblTime.setVisible(true);
        }
        else{
            lblTime.setVisible(false);
        }
        frame.add(panel);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnNext.addActionListener(this);
        btnNext.setActionCommand("next");
       
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "next":
                new MenuScreen(u);
                frame.dispose();    
                break;
        
            
        }   
    }
}
