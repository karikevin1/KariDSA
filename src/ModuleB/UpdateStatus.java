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
public class UpdateStatus extends JFrame{
         private JLabel jblID = new JLabel("Delivery Man ID:");
         private JLabel jblStatus = new JLabel("Delivery Man Status:");
         
         private JTextField jtfID = new JTextField();
         private JComboBox<String> jcbStatus = new JComboBox<String>();
         
         private JButton reset = new JButton("Reset");
         private JButton update = new JButton("Update Status");
         private JTextArea jtaStaffList = new JTextArea(20, 20); // StaffList
         
         public DeliveryProfileInterface<DeliveryMan> deliveryProfileList = new DeliveryManManagement().getList(); 
         //get the list from the main page
         
         public UpdateStatus(){
            initializeList();
            addStatus();

            setTitle("Update Resigned/Retired Status");
            jblID.setHorizontalAlignment(SwingConstants.CENTER);
            jblStatus.setHorizontalAlignment(SwingConstants.CENTER);
            
             jblID.setHorizontalAlignment(SwingConstants.CENTER);
             jblStatus.setHorizontalAlignment(SwingConstants.CENTER);
         
            jtaStaffList.setEditable(false);
            JPanel jpInfo = new JPanel(new GridLayout(3,2));
            jpInfo.add(jblID);
            jpInfo.add(jtfID);
            jpInfo.add(jblStatus);
            jpInfo.add(jcbStatus);
            jpInfo.add(reset);
            jpInfo.add(update);
            
            add(jpInfo, BorderLayout.NORTH);
        
            ResetButtonListener listener1 = new ResetButtonListener();
            reset.addActionListener(listener1);
            
            UpdateButtonListener listener2 = new UpdateButtonListener();
            update.addActionListener(listener2);

            JScrollPane scrollPane = new JScrollPane(jtaStaffList);
            add(scrollPane, BorderLayout.CENTER);
         }
         
         
        public void addStatus(){
            jcbStatus.addItem("Resigned");
            jcbStatus.addItem("Retired");
        }
         
        
        private class UpdateButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(jtfID.getText());
                    String status = jcbStatus.getSelectedItem().toString();
                    
                    boolean validateUpdate = false;
                    validateUpdate = deliveryProfileList.updateStaffStatus(id, status);        
                    if(validateUpdate==true){
                        new DeliveryManManagement().setList(deliveryProfileList); // update the list in the main page
                        jtaStaffList.setText(deliveryProfileList.toString());
                    }else if (validateUpdate==false){
                        jtaStaffList.setText("Invalid Inputs, Wrong ID inserted or Operation failed.");
                    }
                    new DeliveryManManagement().setList(deliveryProfileList); // update the list in the main page
               
                    clearText();
                }catch(Exception ex){
                    jtaStaffList.setText("Invalid Input due to invalid inputs.\n Error:" + ex.getMessage());
                }
            }
        }
        
        private class ResetButtonListener implements ActionListener {
           @Override
               public void actionPerformed(ActionEvent e) {
                 clearText();
                 jtaStaffList.setText(deliveryProfileList.toString());
               }
        }

        public void clearText(){
              jtfID.setText("");
              jcbStatus.setSelectedIndex(0);
        }

        private void initializeList() {
               jtaStaffList.setText(deliveryProfileList.toString());
        }
        
        public static void main(String[] args) {
          UpdateStatus frame = new UpdateStatus();
          frame.getContentPane().setPreferredSize(new Dimension(600, 500));
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
          //frame.setResizable(false);
        }
}