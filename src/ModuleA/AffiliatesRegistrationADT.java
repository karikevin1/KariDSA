/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulea;

import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ModuleA.adt.AffiliatesRegistrationInterface;
import ModuleA.adt.AffiliatesList;
import ModuleA.entity.Affiliates;

/**
 *
 * @author User
 */
public class AffiliatesRegistrationADT extends JFrame {
    private JLabel jblTitle = new JLabel("Affiliates Registration");
    private JLabel jblstaffName = new JLabel("Name :");
    private JTextField jtfstaffName = new JTextField(12);
    private JLabel jblstaffNo = new JLabel("Staff No :");
    private JTextField jtfstaffNo = new JTextField();
    private JTextArea jtaAffiliatesList = new JTextArea(5, 20);
    private JButton jbtRegister = new JButton("Register as Affiliates");
    
    private AffiliatesList<Affiliates> affiliatesList = new AffiliatesList<>();
    
    public AffiliatesRegistrationADT(){
        setTitle("Affiliates Registration");
        Font font = new Font("Calibri", Font.BOLD, 18);
        jblTitle.setFont(font);
        jblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jblstaffName.setFont(font);
        jtfstaffName.setFont(font);
        jblstaffNo.setFont(font);
        jtfstaffNo.setFont(font);
        
        
        JPanel jpInput = new JPanel(new GridLayout(3,3));
        jpInput.add(jblstaffNo);
        jpInput.add(jtfstaffNo);
        jtfstaffNo.setText("" + Affiliates.getStaffNo());
        jtfstaffNo.setEditable(false);
        jpInput.add(jblstaffName);
        jpInput.add(jtfstaffName);
        jpInput.add(jbtRegister);
        add(jpInput, BorderLayout.WEST);
        
        add(jblTitle, BorderLayout.NORTH);
        
        InputListener listener = new InputListener();
        jbtRegister.addActionListener(listener);
        
        
        jtaAffiliatesList.setLineWrap(true);
        jtaAffiliatesList.setWrapStyleWord(true);
        jtaAffiliatesList.setEditable(false);
        jtaAffiliatesList.setFont(font);
        JScrollPane scrollPane = new JScrollPane(jtaAffiliatesList);
        add(scrollPane, BorderLayout.EAST);
        jtfstaffName.grabFocus();
    }  
        private class InputListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String name = jtfstaffName.getText();
                Affiliates affiliates = new Affiliates(name);
                affiliatesList.add(affiliates);
                jtfstaffNo.setText("" + Affiliates.getStaffNo());
                jtaAffiliatesList.setText("" + affiliatesList);
                jtfstaffName.setText("");
                jtfstaffName.grabFocus();
            }
        }
        public static void main(String args[]){
            AffiliatesRegistrationADT frame = new AffiliatesRegistrationADT();
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

