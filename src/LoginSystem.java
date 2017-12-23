
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin lim
 */
public class LoginSystem extends JFrame{
     private JLabel jlbTitle = new JLabel("FastDeliveryMan sdn.bhd");
     private JLabel jlbUsername = new JLabel("Username: ");
     private JLabel jlbPassword = new JLabel("Password: ");
   
     private JButton loginButton = new JButton("Login");
     
     public LoginSystem(){
         setTitle("Fast Delivery Man");
        Font fontTitle = new Font("Arial", Font.BOLD, 36);
        Font font = new Font("Arial", Font.BOLD, 18);
        loginButton.setFont(font);
        
        jlbTitle.setFont(fontTitle);
        jlbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel jplLogin = new JPanel(new GridLayout(0,1));
        jplLogin.add(jlbTitle);
        jplLogin.add(jlbUsername);
        jplLogin.add(jlbPassword);
        jplLogin.add(loginButton);
     }
     
     public static void main(String[] args) {
        LoginSystem frame = new LoginSystem();
        frame.getContentPane().setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
