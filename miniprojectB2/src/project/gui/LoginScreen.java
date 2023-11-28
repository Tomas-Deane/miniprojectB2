package gui;

import javax.swing.*;

import user.LoginRegister;
import user.User;
import java.awt.event.*;

public class LoginScreen implements ActionListener {

    final private String BACKGROUND_IMAGE = "motherboard1.jpg";
    
    private String usernameInput, passwordInput;
    static User u = new User();
    static LoginRegister logReg = new LoginRegister();
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
                    logReg.Login(usernameInput, passwordInput, u, frame);
                    break;
                case "Register":
                    logReg.Register(usernameInput, passwordInput, u, frame);
                    break;
            }
            
        }
        else {
                JOptionPane.showMessageDialog(null, "Login Unsuccessful, please enter a username and password");
            }
    }

}
