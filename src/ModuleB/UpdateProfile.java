/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import ModuleB.adt.DeliveryProfileInterface;
import ModuleB.entity.DeliveryMan;



/**
 *
 * @author kevin lim
 */
public class UpdateProfile extends JFrame{
    private JLabel jblID = new JLabel("Delivery Man ID:");
    private JLabel jblName = new JLabel("Delivery Man Name:");
    private JLabel jblNo = new JLabel("Phone No:");
    private JLabel jblAdd = new JLabel("Address:");
    private JLabel jblGender = new JLabel("Gender:");
    private JLabel jblIcNo = new JLabel("Ic No:");
    private JLabel jblSalary = new JLabel("Salary(RM0.00):");
    
    private JComboBox<ComboBoxObj> jcbID = new JComboBox<ComboBoxObj>();
    private JTextField jtfName = new JTextField();
    private JTextField jtfNo = new JTextField();
    private JTextField jtfAdd = new JTextField();
    private JTextField jtfGender = new JTextField();
    private JTextField jtfIcNo = new JTextField();
    private JTextField jtfSalary = new JTextField();
    
    private JTextArea jtaStaffList = new JTextArea(20, 20); // StaffList
    
    private JButton updateProfile = new JButton("Update");
    private JButton reset = new JButton("reset");
    
    public DeliveryProfileInterface<DeliveryMan> deliveryProfileList = new DeliveryManManagement().getList();
    //get the list from the main page
    
    private DeliveryMan selectedProfile = new DeliveryMan();
  
    public UpdateProfile(){
        addID(); // put in staff id into the combobox
        initializeList();
        
        setTitle("Update Profile");
       // Font font = new Font("Arial", Font.BOLD, 18);
        jblID.setHorizontalAlignment(SwingConstants.CENTER);
        jblName.setHorizontalAlignment(SwingConstants.CENTER);
        jblNo.setHorizontalAlignment(SwingConstants.CENTER);
        jblAdd.setHorizontalAlignment(SwingConstants.CENTER);
        jblGender.setHorizontalAlignment(SwingConstants.CENTER);
        jblIcNo.setHorizontalAlignment(SwingConstants.CENTER);
        jblSalary.setHorizontalAlignment(SwingConstants.CENTER);   
        
        jblID.setHorizontalAlignment(SwingConstants.CENTER);
        jblName.setVerticalAlignment(SwingConstants.CENTER);
        jblNo.setVerticalAlignment(SwingConstants.CENTER);
        jblAdd.setVerticalAlignment(SwingConstants.CENTER);
        jblGender.setVerticalAlignment(SwingConstants.CENTER);
        jblIcNo.setHorizontalAlignment(SwingConstants.CENTER);
        jblSalary.setHorizontalAlignment(SwingConstants.CENTER);   
        
        jtaStaffList.setEditable(false);
        JPanel jpInfo = new JPanel(new GridLayout(0,2));
        jpInfo.add(jblID);
        jcbID.setVisible(true);
        jpInfo.add(jcbID);
        jpInfo.add(jblName);
        jtfName.setEditable(false);
        jpInfo.add(jtfName);
        jpInfo.add(jblNo);
        jtfNo.setEditable(false);
        jpInfo.add(jtfNo);
        jpInfo.add(jblAdd);
        jtfAdd.setEditable(false);
        jpInfo.add(jtfAdd);
        jpInfo.add(jblGender);
        jtfGender.setEditable(false);
        jpInfo.add(jtfGender); 
        jpInfo.add(jblIcNo);
        jtfIcNo.setEditable(false);
        jpInfo.add(jtfIcNo); 
        jpInfo.add(jblSalary); 
        jtfSalary.setEditable(false);
        jpInfo.add(jtfSalary); 
        jpInfo.add(updateProfile);
        jpInfo.add(reset);
        
        add(jpInfo, BorderLayout.NORTH);
        
        UpdateProfileButtonListener listener = new UpdateProfileButtonListener();
        updateProfile.addActionListener(listener);
        
        ResetButtonListener listener2 = new ResetButtonListener();
        reset.addActionListener(listener2);
        
        SearchButtonListener listener3 = new SearchButtonListener();
        jcbID.addActionListener(listener3);
             
        JScrollPane scrollPane = new JScrollPane(jtaStaffList);
        add(scrollPane, BorderLayout.CENTER);
        
    }
    
    private class SearchButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                    try{
                        ComboBoxObj temp = (ComboBoxObj)jcbID.getSelectedItem();
                        int id = temp.getValue();
                        selectedProfile= deliveryProfileList.getSelectedProfile(id);
                        jtfName.setText(selectedProfile.getStaffName());
                        jtfNo.setText(selectedProfile.getPhoneNo());
                        jtfAdd.setText(selectedProfile.getAddress());
                        jtfGender.setText(selectedProfile.getGender());
                        jtfIcNo.setText(selectedProfile.getIcNo());
                        jtfSalary.setText(""+selectedProfile.getSalary());
                        jtfNo.setEditable(true);
                        jtfAdd.setEditable(true);
                        jtfSalary.setEditable(true);
                    }catch (Exception ex){
                          jtaStaffList.setText("Failed to get the selected profile.\n Error:" + ex.getMessage());
                    }
            }
     }
    
    private class UpdateProfileButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String phone = jtfNo.getText();
                    String add = jtfAdd.getText();
                    double salary = Double.parseDouble(jtfSalary.getText());
                    selectedProfile.setPhoneNo(phone);
                    selectedProfile.setSalary(salary);
                    selectedProfile.setAddress(add);
                    
                    boolean validateUpdate = false;
                    ComboBoxObj temp = (ComboBoxObj)jcbID.getSelectedItem();
                    int id = temp.getValue();
                    validateUpdate = deliveryProfileList.updateProfile(id,selectedProfile);        
                    if(validateUpdate==true){
                        new DeliveryManManagement().setList(deliveryProfileList); // update the list in the main page
                        jtaStaffList.setText(deliveryProfileList.toString());
                    }else if (validateUpdate==false){
                        jtaStaffList.setText("Invalid Inputs, Wrong ID inserted.");
                    }
                    new DeliveryManManagement().setList(deliveryProfileList); // update the list in the main page
               
                    clearText();
                }catch(Exception ex){
                    jtaStaffList.setText("No staff ID is selected.\n Error:" + ex.getMessage());
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
    
    public void addID(){
        for(int a=1 ; a <= deliveryProfileList.getNumberOfEntries();a++){
            jcbID.addItem(new ComboBoxObj(deliveryProfileList.getPositionProfile(a).getStaffName(),
            deliveryProfileList.getPositionProfile(a).getStaffID()));
        }      
     }
    
    public void clearText(){
            jcbID.setSelectedIndex(0);
            jtfName.setText("");
            jtfNo.setText("");
            jtfAdd.setText("");
            jtfGender.setText("");
            jtfIcNo.setText("");
            jtfSalary.setText("");
            jtfNo.setEditable(false);
            jtfAdd.setEditable(false);
            jtfSalary.setEditable(false);
    }
    
    private void initializeList() {
            jtaStaffList.setText(deliveryProfileList.toString());
    }
      
    
}
