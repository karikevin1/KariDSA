/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB;
import ModuleB.adt.DeliveryInterface;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import ModuleB.adt.DeliveryProfile;
import ModuleB.adt.DeliveryProfileInterface;
import ModuleB.entity.Delivery;
import ModuleB.entity.DeliveryMan;


/**
 *
 * @author kevin lim
 */
public class PendingList extends JFrame{
    private JLabel jblID = new JLabel("Delivery Man ID:");
    private JLabel jblName = new JLabel("Delivery Man Name:");
    private JLabel jblStatus = new JLabel("Delivery Status:");
    private JTextArea jtaStaffList = new JTextArea(20, 20); // StaffList
    
    private JComboBox<String> jcbID = new JComboBox<String>();
    private JTextField jtfName = new JTextField();
    private JTextField jtfStatus = new JTextField();
    
    private JButton searchProfile = new JButton("Search");
    private JButton reset = new JButton("reset");
    
    public DeliveryProfileInterface<DeliveryMan> deliveryProfileList = new DeliveryManManagement().getList(); 
    // get the list from the main page
   
    public DeliveryInterface<Delivery> deliveryList = new DeliveryManManagement().getDeliList(); 
    // get the list from the main page
    
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
        jtfName.setEditable(false);
        jpInfo.add(jtfName);
        jpInfo.add(jblStatus);
        jtfStatus.setEditable(false);
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
                DeliveryMan temp = new DeliveryMan();
                temp = deliveryProfileList.getSelectedProfile(id);
                jtfName.setText(temp.getStaffName());
                String outputString ="";
                
                for(int a = 0; a< deliveryList.getNumberOfEntries();a++){
                    if(deliveryList.getSelectedDelivery(a).getStaffID() == id){
                        outputString += deliveryList.getSelectedDelivery(a).toShortString() + "\n";
                    }
                }
                jtaStaffList.setText("OrderNo       CustName   CustomerContactNo\n"+outputString);
                 if(outputString.equals("")){
                     jtfStatus.setText("Free and Available");
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
        for(int a=1 ; a <= deliveryProfileList.getNumberOfEntries();a++){
                jcbID.addItem(""+deliveryProfileList.getPositionProfile(a).getStaffID());
        }      
     }
    
    public void clearText(){
         jcbID.setSelectedIndex(0);
         jtfName.setText("");
         jtfStatus.setText("");
         jtaStaffList.setText("");
     }
    
    
}
