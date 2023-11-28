package user;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import gui.MenuScreen;

public class LoginRegister {

    public void Login(String username, String password, User u, JFrame frame) {
        if (u.validLogIn(username, password)) {
                    //System.out.println("Login Successful");
                    OpenMenu(u, frame);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Unsuccessful, Invalid username or password");
                }
    }
    
    public void Register(String username, String password, User u, JFrame frame) {
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
