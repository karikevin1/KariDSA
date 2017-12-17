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
import java.util.Date;

/**
 *
 * @author kevin lim
 */
public class DailyProfile extends JFrame{
       private JLabel jblName = new JLabel("Staff Name:");
       private JLabel jblComment = new JLabel("Comment:");
       
       private JTextField jtfComment = new JTextField();
       private JComboBox<String> jcbID = new JComboBox<String>();
       private JTextArea jtaReport = new JTextArea(20, 20); // StaffList
       private JButton generateReport = new JButton("Generate");
       
       public DeliveryProfileInterface<DeliveryMan> deliveryProfileList = new DeliveryManManagement().getList(); 
        // get the list from the main page
       
       public DailyProfile(){
            addID(); // put in staff id into the combobox
            setTitle("Access Pending List");
            jblName.setHorizontalAlignment(SwingConstants.CENTER);
            jblComment.setHorizontalAlignment(SwingConstants.CENTER);
   
            jblName.setHorizontalAlignment(SwingConstants.CENTER);
            jblComment.setHorizontalAlignment(SwingConstants.CENTER);
      
            jtaReport.setEditable(false);
            JPanel jpInfo = new JPanel(new GridLayout(4,2));
            jpInfo.add(jblName);
            jcbID.setVisible(true);        
            jpInfo.add(jcbID);
            jpInfo.add(jblComment);
            jpInfo.add(jtfComment);
            jpInfo.add(generateReport);
            
            add(jpInfo, BorderLayout.NORTH);
        
            GenerateButtonListener listener = new GenerateButtonListener();
            generateReport.addActionListener(listener);

            JScrollPane scrollPane = new JScrollPane(jtaReport);
            add(scrollPane, BorderLayout.CENTER);
        
       }
  
         private class GenerateButtonListener implements ActionListener {
            @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        String resultString ="Daily Report \n";
                        resultString+= "Staff: "+ jcbID.getSelectedItem() + "\nDate: " +java.time.LocalDate.now()+ ""  ;
                        resultString += "\nComment: " + jtfComment.getText();
                        resultString += "\n" +deliveryProfileList.toReportString();
                        jtaReport.setText(resultString);
                    }catch(Exception ex){
                         jtaReport.setText("Invalid Input due to invalid inputs.\n Error:" + ex.getMessage() );
                    }
                }
            }
         
       public void addID(){
           jcbID.addItem("Lim Kah Ri");
           jcbID.addItem("Lim Lo Li");
           jcbID.addItem("Low Kit Kat");
           jcbID.addItem("Ng Ah Lex");
       }
       
    public static void main(String[] args) {
      DailyProfile frame = new DailyProfile();
      frame.getContentPane().setPreferredSize(new Dimension(600, 500));
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      //frame.setResizable(false);
    }
}
