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
import ModuleB.adt.DeliveryProfile;
import ModuleB.adt.DeliveryProfileInterface;
import ModuleB.entity.DeliveryMan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author kevin lim
 */
public class CreateProfile extends JFrame {
    private JLabel jblName = new JLabel("Delivery Man Name:");
    private JLabel jblNo = new JLabel("Phone No:");
    private JLabel jblAdd = new JLabel("Address:");
    private JLabel jblGender = new JLabel("Gender:");
    private JTextField jtfName = new JTextField();
    private JTextField jtfNo = new JTextField();
    private JTextField jtfAdd = new JTextField();
    private JTextField jtfGender = new JTextField();
    private JTextArea jtaResult = new JTextArea(20, 20);
    private JButton createProfile = new JButton("create");
    private JButton reset = new JButton("reset");
    private JButton back = new JButton("back");
    public DeliveryProfileInterface dpi = new DeliveryProfile();
    
    public CreateProfile(){
        initializeList();
        setTitle("Create Profile");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblName.setHorizontalAlignment(SwingConstants.CENTER);
        jblNo.setHorizontalAlignment(SwingConstants.CENTER);
        jblAdd.setHorizontalAlignment(SwingConstants.CENTER);
        jblGender.setHorizontalAlignment(SwingConstants.CENTER);
        jblName.setVerticalAlignment(SwingConstants.CENTER);
        jblNo.setVerticalAlignment(SwingConstants.CENTER);
        jblAdd.setVerticalAlignment(SwingConstants.CENTER);
        jblGender.setVerticalAlignment(SwingConstants.CENTER);
        jtaResult.setEditable(false);
        
        JPanel jpInfo = new JPanel(new GridLayout(6,2));
        jpInfo.add(jblName);
        jpInfo.add(jtfName);
        jpInfo.add(jblNo);
        jpInfo.add(jtfNo);
        jpInfo.add(jblAdd);
        jpInfo.add(jtfAdd);
        jpInfo.add(jblGender);
        jpInfo.add(jtfGender);    
        jpInfo.add(createProfile);
        jpInfo.add(reset);
        jpInfo.add(back);
        add(jpInfo, BorderLayout.NORTH);
        
        CreateProfileButtonListener listener = new CreateProfileButtonListener();
        createProfile.addActionListener(listener);
        
        ResetButtonListener listener2 = new ResetButtonListener();
        reset.addActionListener(listener2);
        
        BackButtonListener listener3 = new BackButtonListener();
        back.addActionListener(listener3);
        
        JScrollPane scrollPane = new JScrollPane(jtaResult);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private class CreateProfileButtonListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
            String name = jtfName.getText();
            String no = jtfNo.getText();
            String add = jtfAdd.getText();
            String gender = jtfGender.getText();
            DeliveryMan dm = new DeliveryMan(name,no,add,gender);
            
            dpi.createProfile(dm);
            jtaResult.setText(dpi.toProfileString());
            clearText();
            
        }
    }
    
      private class ResetButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
              clearText();
            }
     }
      
       private class BackButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
              
            }
     }
    
    public void clearText(){
            jtfName.setText("");
            jtfNo.setText("");
            jtfAdd.setText("");
            jtfGender.setText("");
    }
    
    private void initializeList() {
      jtaResult.setText(dpi.toProfileString());
  }
    
    public static void main(String[] args) {
          CreateProfile cp = new CreateProfile();
          cp.getContentPane().setPreferredSize(new Dimension(600, 500));
          cp.pack();
          cp.setLocationRelativeTo(null);
          cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          cp.setVisible(true);
    
  }
}
