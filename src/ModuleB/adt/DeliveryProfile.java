/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;
import ModuleB.adt.ListInterface;
import ModuleB.adt.LList;
import ModuleB.entity.DeliveryMan;
import ModuleB.adt.DeliveryADT;
import ModuleB.adt.DeliveryInterface;
import ModuleB.entity.Delivery;
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
    private static final ListInterface <DeliveryMan> deliveryManList = new LList();
    
    public DeliveryProfile(){
         if(this.deliveryManList.isEmpty()){
            DeliveryMan initializeList1, initializeList2, initializeList3, initializeList4;
            initializeList1= new DeliveryMan("LimKH", 1234,"0162903850", "no2, jln6", "male", "970629-14-5571",2000.00);
            initializeList2= new DeliveryMan("LimKW", 1111,"0162342850", "no2, jln6", "male", "971234-18-9911",1200.00);
            initializeList3= new DeliveryMan("LowSK",3456, "0162203850", "no2, jln6", "female", "975050-90-1122",300.00);
            initializeList4= new DeliveryMan("NgWD",9909, "0162987850", "no2, jln6", "male", "973020-87-2211",1000.00);        
            this.deliveryManList.add(initializeList1);
            this.deliveryManList.add(initializeList2);
            this.deliveryManList.add(initializeList3);
            this.deliveryManList.add(initializeList4);
        }
    }
    
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
        this.deliveryManList.add(dm);
       
                 
        ans = true;
        return ans;
    }
    
    public boolean updateProfile(int Id,String name,String phone,String address,String gender,String IcNo, double salary){
        boolean ans = false; 
        for(int a=1 ; a <= deliveryManList.getNumberOfEntries(); a++){
            if(Id == deliveryManList.getEntry(a).getStaffID()){
               this.deliveryManList.getEntry(a).setStaffName(name);
               this.deliveryManList.getEntry(a).setPhoneNo(phone);
               this.deliveryManList.getEntry(a).setAddress(address);
               this.deliveryManList.getEntry(a).setGender(gender);
               this.deliveryManList.getEntry(a).setIcNo(IcNo);
               this.deliveryManList.getEntry(a).setSalary(salary);
               ans = true;
            }
        }
        
        return ans;
    }
    
    public ListInterface <DeliveryMan> retrieveProfile(){
        return this.deliveryManList;
    }
    
    public DeliveryMan retrieveSelectedProfile(int ID){
       DeliveryMan dm = new DeliveryMan();
        for (int a=1;a <= deliveryManList.getNumberOfEntries();a++){
            if (deliveryManList.getEntry(a).getStaffID()== ID){
                dm = deliveryManList.getEntry(a);
            }
        }
        return dm;
    }
    
    public String retrievePendingList(int ID){
        Delivery deli = new Delivery();
        DeliveryInterface temp = new DeliveryADT();
        int counter=0;
        String replyString = "Free and Available";
        for(int a =1 ;a <= temp.retrieveList().getNumberOfEntries();a++){
            if (ID == temp.retrieveList().getEntry(a).getStaffID()){
                if(temp.retrieveList().getEntry(a).getOrderNo()!=null){
                    deli = temp.retrieveList().getEntry(a);
                    replyString = deli.toShortString();
                    return replyString;
                }
            }
        }
        return replyString;
    }
    
    
    public String toProfileString(){
        ListInterface <DeliveryMan> temp = retrieveProfile();
        String outputString = "Staff name        StaffID           PhoneNo                Address         Status         Gender               ICNO                      Salary           DeliveryState\n";
        outputString += temp.toString();
        return outputString;
    }
}
