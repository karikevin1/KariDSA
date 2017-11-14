/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import ModuleB.CreateProfile;
/**
 *
 * @author kevin lim
 */
public class DeliveryManManagement extends JFrame{
    private JLabel jlblInstruction = new JLabel("Delivery Man Management");
    private JButton createProfile = new JButton("CreateProfile");
    private JButton checkProfile = new JButton("CheckProfile");
    public DeliveryManManagement(){
        setTitle("Delivery Man Management subsystem (HR subsystem)");
        Font fontInstruction = new Font("Arial", Font.BOLD, 36);
        Font font = new Font("Arial", Font.BOLD, 18);
        createProfile.setFont(font);
        checkProfile.setFont(font);
        jlblInstruction.setFont(fontInstruction);
        jlblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlblInstruction, BorderLayout.NORTH);
        JPanel jpButton = new JPanel(new FlowLayout());
        ImageIcon deliveryMan = new ImageIcon(getClass().getResource("image/deliveryMan.jpg"));
        jpButton.add(new JLabel(deliveryMan)).setSize(new Dimension(300, 300));
        jpButton.add(createProfile);
        //jpButton.add(checkProfile);
        add(jpButton, BorderLayout.CENTER);
        
        CreateProfileButtonListener listener = new CreateProfileButtonListener();
        createProfile.addActionListener(listener);
        CheckProfileButtonListener listener2 = new CheckProfileButtonListener();
        checkProfile.addActionListener(listener2);
    }
    
    private class CreateProfileButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
         CreateProfile cp = new CreateProfile();
          cp.getContentPane().setPreferredSize(new Dimension(600, 500));
          cp.pack();
          cp.setLocationRelativeTo(null);
          cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          cp.setVisible(true);
    }
  }
    
    private class CheckProfileButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
         
    }
  }
    
    public static void main(String[] args) {
    DeliveryManManagement frame = new DeliveryManManagement();
    frame.getContentPane().setPreferredSize(new Dimension(600, 500));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    //frame.setResizable(false);
  }
}
