

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class LoginScreen implements ActionListener {
    private String usernameInput, passwordInput;
    static User u = new User();
    static JFrame frame = new JFrame("Login");
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();

    JLabel lblTitle= new JLabel("Welcome to the ISE Quiz ");
    JLabel lblUser = new JLabel("Username: ");
    JTextField txtUser = new JTextField("", 15);
    JLabel lblPass = new JLabel("Password: ");
    JTextField txtPass = new JTextField("", 15);
    JButton btnLogin = new JButton("Login", null);
    JButton btnRegister = new JButton("Register New User", null);

    // text.setBounds(200, 200,400,500);;
    public LoginScreen() {
        //JFrame.setDefaultLookAndFeelDecorated(true);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.CYAN);
        panel.setBackground(Color.CYAN);
        panel.setBounds(0,0,700, 500);
        panel.setLayout(layout);
        panel.add(lblTitle);
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(btnLogin);
        panel.add(btnRegister);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        // Put constraint on components
        // TITLE CONSTRAINTS
        //layout.putConstraint(SpringLayout.WEST, lblTitle, (panel.getWidth()-lblTitle.getWidth())/2, SpringLayout.WEST, panel);
        //layout.putConstraint(SpringLayout.NORTH, lblUser, 60, SpringLayout.NORTH, panel);
        // USERNAME CONSTRAINTS
        layout.putConstraint(SpringLayout.WEST, lblUser, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblUser, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtUser, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtUser, 100, SpringLayout.NORTH, panel);
        // PASSWORD CONSTRAINTS
        layout.putConstraint(SpringLayout.WEST, lblPass, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblPass, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtPass, 150, SpringLayout.WEST, panel );
        layout.putConstraint(SpringLayout.NORTH, txtPass, 150, SpringLayout.NORTH, panel);
        // LOGIN BUTTON CONSTRAINTS
        layout.putConstraint(SpringLayout.WEST, btnLogin, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnLogin, 200, SpringLayout.NORTH, panel);
        // REGISTER BUTTON CONSTRAINTS
        layout.putConstraint(SpringLayout.WEST, btnRegister, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnRegister, 200, SpringLayout.NORTH, panel);
        frame.add(panel);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
        btnLogin.addActionListener(this);
        btnLogin.setActionCommand("Login");
        btnRegister.addActionListener(this);
        btnRegister.setActionCommand("Register");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        usernameInput = txtUser.getText();
        passwordInput = txtPass.getText();
        String[] info = { usernameInput, passwordInput };
        if (!usernameInput.contains(" ") && !passwordInput.contains(" ") && !usernameInput.isBlank()&& !passwordInput.isBlank()) {
            switch (e.getActionCommand()) {
                case "Login":
                    Login(info);
                    break;
                case "Register":
                    Register(info);
                    break;
            }
            
        }
        else {
                JOptionPane.showMessageDialog(null, "Login Unsuccessful, please enter a username and password");
            }
    }

    public static void Login(String[] info) {
        //User u = new User();
        if (u.validLogIn(info)) {
                    //System.out.println("Login Successful");
                    OpenMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Unsuccessful, Invalid username or password");
                }
    }
    public static void Register(String[] info) {
        if(passRegex.validPassword(info[1])){
            u.setUserInfo(info);
            OpenMenu();
        }
        else{
            JOptionPane.showMessageDialog(null, "Registration Unsuccessful, password invalid");
        }
        
    }
    public static void OpenMenu(){
        new MenuScreen(u);
        frame.dispose();
    }
}
