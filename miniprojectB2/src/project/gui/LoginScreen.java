package gui;

import user.User;
import user.passRegex;

import javax.swing.*;
import java.awt.event.*;

public class LoginScreen implements ActionListener {

    final private String BACKGROUND_IMAGE = "motherboard1.jpg";
    
    private String usernameInput, passwordInput;
    static User u = new User();
    passRegex passwordRegex = new passRegex();
    static JFrame frame = new JFrame("Login");
    JPanel panel = new JPanel();

    SpringLayout layout = new SpringLayout();


    JLabel lblTitle = new JLabel("Welcome to the ISE Quiz ");
    JLabel lblUser = new JLabel("Username: ");
    JTextField txtUser = new JTextField("", 15);
    JLabel lblPass = new JLabel("Password: ");
    JTextField txtPass = new JTextField("", 15);
    JButton btnLogin = new JButton("Login", null);
    JButton btnRegister = new JButton("Register New User", null);
    JLabel backgroundLabel = new JLabel(new ImageIcon(BACKGROUND_IMAGE));
    

    public LoginScreen() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundLabel.setBounds(0,0,1920,1080);

        panel.setBounds(0,0,1920, 1080);
        panel.setLayout(layout);
        panel.add(lblTitle);
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(btnLogin);
        panel.add(btnRegister);
        panel.add(backgroundLabel);
        
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        // Put constraint on components
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
        frame.setSize(1920, 1920);
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
        if (!usernameInput.contains(" ") && !passwordInput.contains(" ") && !usernameInput.isBlank()&& !passwordInput.isBlank()) {
            switch (e.getActionCommand()) {
                case "Login":
                    Login(usernameInput, passwordInput);
                    break;
                case "Register":
                    Register(usernameInput, passwordInput);
                    break;
            }
            
        }
        else {
                JOptionPane.showMessageDialog(null, "Login Unsuccessful, please enter a username and password");
            }
    }

    private void Login(String username, String password) {
        if (u.validLogIn(username, password)) {
                    //System.out.println("Login Successful");
                    OpenMenu(u, frame);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Unsuccessful, Invalid username or password");
                }
    }
    
    private void Register(String username, String password) {
        if(passRegex.validPassword(password)){
            u.setUserInfo(username, password);
            OpenMenu(u, frame);
        }
        else{
            JOptionPane.showMessageDialog(null, "Registration Unsuccessful, password invalid");
        }
        
    }
    
    public static void OpenMenu(User u, JFrame frame){
        new MenuScreen(u);
        frame.dispose();
    }
}
