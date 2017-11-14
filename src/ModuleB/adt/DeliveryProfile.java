/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;
import ModuleB.adt.ListInterface;
import ModuleB.adt.ExpandableArrayList;
import ModuleB.entity.DeliveryMan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author kevin lim
 */
public class DeliveryProfile implements DeliveryProfileInterface {
    private ListInterface <DeliveryMan> deliveryManList = new ExpandableArrayList();
    
    public boolean createProfile (DeliveryMan dm){
        boolean ans = false; 
        int id = dm.getStaffID();
        String name = dm.getStaffName();
        for(int a=1 ; a <= deliveryManList.getNumberOfEntries(); a++){
            if(id == deliveryManList.getEntry(a).getStaffID() && name == deliveryManList.getEntry(a).getStaffName()){
                ans = false; 
                return ans;
            }
        }
        deliveryManList.add(dm);
                String temp ="";
                    try {
                         ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliMan.dat"));
                         temp += (String) (oiStream.readObject());
                         oiStream.close();
                         temp+=deliveryManList.toString();
                         ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliMan.dat"));
                         ooStream.writeObject(temp);
                         //ooStream.close();
                         //this.dispose();
                       } catch (FileNotFoundException ex) {
                         JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                       } catch (IOException ex) {
                         JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
                       } catch (ClassNotFoundException ex) { 
            Logger.getLogger(DeliveryProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
        ans = true;
        return ans;
    }
    
    public String retrieveProfile(int Id){
       return "qwe"; 
    }
    
    
    public String toProfileString(){
        String outputString = "Staff name           StaffID          StaffStatus \n";
         try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliMan.dat"));
            outputString += (String) (oiStream.readObject());
            oiStream.close();
          } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
          } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
         return outputString;
    }
}
