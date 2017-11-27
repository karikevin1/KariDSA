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
import ModuleB.UpdateProfile;
/**
 *
 * @author kevin lim
 */
public class DeliveryManManagement extends JFrame{
    private JLabel jlblInstruction = new JLabel("Delivery Man Management");
    private JButton createProfile = new JButton("CreateProfile");
    private JButton updateProfile = new JButton("UpdateProfile");
    private JButton pendingList = new JButton("RetrievePendingList");
    private JPanel jPanelAll = new JPanel();
    
    public DeliveryManManagement(){
        setTitle("Delivery Man Management subsystem (HR subsystem)");
        Font fontInstruction = new Font("Arial", Font.BOLD, 36);
        Font font = new Font("Arial", Font.BOLD, 18);
        createProfile.setFont(font);
        updateProfile.setFont(font);
        pendingList.setFont(font);
        
        jlblInstruction.setFont(fontInstruction);
        jlblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
        jPanelAll.setLayout(new BorderLayout());
        jPanelAll.add(jlblInstruction, BorderLayout.NORTH);
        JPanel jpButton = new JPanel(new FlowLayout());
        ImageIcon deliveryMan = new ImageIcon(getClass().getResource("image/deliveryMan.jpg"));
        jpButton.add(new JLabel(deliveryMan)).setSize(new Dimension(300, 300));
        jpButton.add(createProfile);
        jpButton.add(updateProfile);
        jpButton.add(pendingList);
        jPanelAll.add(jpButton, BorderLayout.CENTER);
        
        CreateProfileButtonListener listener = new CreateProfileButtonListener();
        createProfile.addActionListener(listener);
        UpdateProfileButtonListener listener2 = new UpdateProfileButtonListener();
        updateProfile.addActionListener(listener2);
        PendingListButtonListener listener3 = new PendingListButtonListener();
        pendingList.addActionListener(listener3);
        add(jPanelAll);
    }
    
    private class CreateProfileButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
          CreateProfile cp = new CreateProfile();
          cp.getContentPane().setPreferredSize(new Dimension(600, 500));
          cp.pack();
          cp.setLocationRelativeTo(null);
          cp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          cp.setVisible(true);
    }
  }
    
     private class PendingListButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
          PendingList pl = new PendingList();
          pl.getContentPane().setPreferredSize(new Dimension(600, 500));
          pl.pack();
          pl.setLocationRelativeTo(null);
          pl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          pl.setVisible(true);
    }
  }
    
    private class UpdateProfileButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
          UpdateProfile up = new UpdateProfile();
          up.getContentPane().setPreferredSize(new Dimension(600, 500));
          up.pack();
          up.setLocationRelativeTo(null);
          up.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          up.setVisible(true);
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
