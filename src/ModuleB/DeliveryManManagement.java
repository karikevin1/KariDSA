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
import ModuleB.adt.DeliveryProfileInterface;
import ModuleB.adt.DeliveryProfile;
import ModuleB.entity.DeliveryMan;
import ModuleD.Client;
import ModuleD.adt.ScheduleInterface;
import ModuleD.adt.ScheduleADT;
import ModuleD.entity.Schedule;
/**
 *
 * @author kevin lim
 */
public class DeliveryManManagement extends JFrame{
    private JLabel jlblInstruction = new JLabel("Delivery Man Management");
    private JButton createProfile = new JButton("CreateProfile");
    private JButton updateProfile = new JButton("UpdateProfile");
    private JButton pendingList = new JButton("RetrievePendingList");
    private JButton updateStatus = new JButton("Set Resigned/Retired Member");
    private JButton dailyProfile = new JButton("DailyReport");
    private JPanel jPanelAll = new JPanel();
    
    public static DeliveryProfileInterface<DeliveryMan> deliveryProfileList = new DeliveryProfile<>(); // the super list object
    public static ScheduleInterface<Schedule> deliveryList = new Client().getDeliList();
    
    public void setList (DeliveryProfileInterface<DeliveryMan> deliveryProfileList){
        this.deliveryProfileList = deliveryProfileList;   // setter for super list object
    }
    
    public DeliveryProfileInterface<DeliveryMan> getList (){
        return this.deliveryProfileList;      // getter for super list object
    }
     
    public ScheduleInterface<Schedule> getDeliList (){
        return this.deliveryList;      // getter for super list object
    }
     
    
    public DeliveryManManagement(){
        initialize();
        setTitle("Delivery Man Management subsystem (HR subsystem)");
        Font fontInstruction = new Font("Arial", Font.BOLD, 36);
        Font font = new Font("Arial", Font.BOLD, 18);
        createProfile.setFont(font);
        updateProfile.setFont(font);
        pendingList.setFont(font);
        updateStatus.setFont(font);
        dailyProfile.setFont(font);
        
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
        jpButton.add(updateStatus);
        jpButton.add(dailyProfile);
        jPanelAll.add(jpButton, BorderLayout.CENTER);
        
        CreateProfileButtonListener listener = new CreateProfileButtonListener();
        createProfile.addActionListener(listener);
        UpdateProfileButtonListener listener2 = new UpdateProfileButtonListener();
        updateProfile.addActionListener(listener2);
        PendingListButtonListener listener3 = new PendingListButtonListener();
        pendingList.addActionListener(listener3);
        UpdateStatusButtonListener listener4 = new UpdateStatusButtonListener();
        updateStatus.addActionListener(listener4);
        DailyProfileButtonListener listener5 = new DailyProfileButtonListener();
        dailyProfile.addActionListener(listener5);
        add(jPanelAll);
    }
    
    private class CreateProfileButtonListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
              CreateProfile cp = new CreateProfile();
              cp.getContentPane().setPreferredSize(new Dimension(600, 500));
              cp.pack();
              cp.setLocationRelativeTo(null);
              cp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    
    private class DailyProfileButtonListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
              DailyProfile up = new DailyProfile();
              up.getContentPane().setPreferredSize(new Dimension(600, 500));
              up.pack();
              up.setLocationRelativeTo(null);
              up.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
              up.setVisible(true);
        }
    }
    
    private class UpdateStatusButtonListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
              UpdateStatus up = new UpdateStatus();
              up.getContentPane().setPreferredSize(new Dimension(600, 500));
              up.pack();
              up.setLocationRelativeTo(null);
              up.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
              up.setVisible(true);
        }
    }
    
    private void initialize(){
                if(this.deliveryProfileList.isEmpty()){
                    DeliveryMan initializeList1, initializeList2, initializeList3, initializeList4,
                            initializeList5,initializeList6,initializeList7,initializeList8,initializeList9,
                            initializeList10;
                    initializeList1= new DeliveryMan("LimKH",1629,"0162903850", "no2, jln6", "Male", "970629-14-5571",2000.00,2,15,12,20);          //1 pend
                    initializeList2= new DeliveryMan("LimKW",1111,"0162342850", "no2, jln6", "Male", "971234-18-9911",1200.00,2,20,14,1);           //2
                    initializeList3= new DeliveryMan("LowSK",3456,"0162203850", "no2, jln6", "Female", "975050-90-1122",2300.00,3,30,10,5);       //3
                    initializeList4= new DeliveryMan("NgWD",9909,"0162987850", "no2, jln6", "Male", "973020-87-2211",1000.00,1,5,11,8);              //1
                    initializeList5= new DeliveryMan("LooJW",1233,"0162903850", "no2, jln6", "Female", "970529-14-5571",2000.00,2,11,18,19);     //2
                    initializeList6= new DeliveryMan("LimJW",1012,"0162342850", "no2, jln6", "Male", "971214-18-9911",1200.00,3,12,5,10);            //3
                    initializeList7= new DeliveryMan("MahJW",3757,"0162203850", "no2, jln6", "Female", "970501-90-1122",2400.00,1,11,10,10);    //1
                    initializeList8= new DeliveryMan("LoiKW",9610,"0162987850", "no2, jln6", "Male", "971120-87-2211",1000.00,3,10,11,3);            //2
                    initializeList9= new DeliveryMan("LimNF",5566,"0162903850", "no2, jln6", "Female", "970619-14-5571",2000.00,2,29,20,2);        //3
                    initializeList10= new DeliveryMan("LohKC",6969,"0162342850", "no2, jln6", "Male", "971134-18-9911",1200.00,1,17,20,3);          //1
                    this.deliveryProfileList.createProfile(initializeList1);
                    this.deliveryProfileList.createProfile(initializeList2);
                    this.deliveryProfileList.createProfile(initializeList3);
                    this.deliveryProfileList.createProfile(initializeList4);
                    this.deliveryProfileList.createProfile(initializeList5);
                    this.deliveryProfileList.createProfile(initializeList6);
                    this.deliveryProfileList.createProfile(initializeList7);
                    this.deliveryProfileList.createProfile(initializeList8);
                    this.deliveryProfileList.createProfile(initializeList9);
                    this.deliveryProfileList.createProfile(initializeList10);
                }
                
    }
    
    public static void main(String[] args) {
        DeliveryManManagement frame = new DeliveryManManagement();
        frame.getContentPane().setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
