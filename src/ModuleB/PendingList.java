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
import ModuleB.adt.LList;
import ModuleB.adt.ListInterface;
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
public class PendingList extends JFrame{
    private JLabel jblID = new JLabel("Delivery Man ID:");
    private JLabel jblName = new JLabel("Delivery Man Name:");
    private JLabel jblStatus = new JLabel("Delivery Status:");
    private JTextArea jtaStaffList = new JTextArea(20, 20); // StaffList
    
    private ListInterface <String> staffID = new LList();
    private JComboBox<String> jcbID = new JComboBox<String>();
    private JTextField jtfName = new JTextField();
    private JTextField jtfStatus = new JTextField();
    
    private JButton searchProfile = new JButton("Search");
    private JButton reset = new JButton("reset");
    public DeliveryProfileInterface dpi = new DeliveryProfile();
   
    int counter;
    
    public PendingList(){
        addID(); // put in staff id into the combobox
        setTitle("Access Pending List");
        jblID.setHorizontalAlignment(SwingConstants.CENTER);
        jblName.setHorizontalAlignment(SwingConstants.CENTER);
        jblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblID.setHorizontalAlignment(SwingConstants.CENTER);
        jblName.setVerticalAlignment(SwingConstants.CENTER);
        jblStatus.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaStaffList.setEditable(false);
        JPanel jpInfo = new JPanel(new GridLayout(4,2));
        jpInfo.add(jblID);
        jcbID.setVisible(true);
        jpInfo.add(jcbID);
        jpInfo.add(jblName);
        jpInfo.add(jtfName);
        jpInfo.add(jblStatus);
        jpInfo.add(jtfStatus);
        jpInfo.add(searchProfile);
        jpInfo.add(reset);
        
        add(jpInfo, BorderLayout.NORTH);
        
        SearchButtonListener listener = new SearchButtonListener();
        searchProfile.addActionListener(listener);
        
        ResetButtonListener listener2 = new ResetButtonListener();
        reset.addActionListener(listener2);
             
        JScrollPane scrollPane = new JScrollPane(jtaStaffList);
        add(scrollPane, BorderLayout.CENTER);
    }
    
     private class SearchButtonListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
            try{
                int id = Integer.parseInt(jcbID.getSelectedItem().toString());
                jtfName.setText(dpi.retrieveSelectedProfile(id).getStaffName());
                jtaStaffList.setText("OrderNo       CustName   CustomerContactNo\n"+dpi.retrievePendingList(id));
                if(dpi.retrievePendingList(id).equals("Free and Available")){
                    jtfStatus.setText("Available");
                }else{
                    jtfStatus.setText("Delivering");
                }
            }catch(Exception ex){
                 jtaStaffList.setText("Invalid Input due to invalid inputs.\n Error:" + ex.getMessage() );
            }
        }
    }
    
      private class ResetButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
              clearText();
            }
     }
    
    public void addID(){
        //jcbID.addItem("Select Delivery Man ID: ");
        for(int a=1 ; a<= dpi.retrieveProfile().getNumberOfEntries();a++){
                staffID.add(""+dpi.retrieveProfile().getEntry(a).getStaffID());
        }
        
        for(int a=1 ; a<= staffID.getNumberOfEntries();a++){
                jcbID.addItem(staffID.getEntry(a));
        }      
     }
    
    public void clearText(){
         jcbID.setSelectedIndex(0);
         jtfName.setText("");
         jtfStatus.setText("");
         jtaStaffList.setText("");
     }
    
    
}
