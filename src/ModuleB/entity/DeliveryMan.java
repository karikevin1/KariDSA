/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.entity;
import java.util.Random;

/**
 *
 * @author kevin lim
 */
public class DeliveryMan {
    private String staffName;
    private int staffID;
    private String phoneNo;
    private String address;
    private String status;
    private String gender;
    private String icNo;
    private double Salary;
    private String deliveryStatus;
    private Random rand = new Random();

    //this constructor for newly created id
    public DeliveryMan(String staffName, String phoneNo, String address, String gender, String icNo, double Salary) {
        this.staffName = staffName;
        this.staffID = rand.nextInt((9999 - 1000) + 1) + 1000 ;
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = "staff";
        this.gender = gender;
        this.icNo = icNo;
        this.Salary = Salary;
        this.deliveryStatus = "Available";
    }
    
    //this constructor for manually assign id
    public DeliveryMan(String staffName,int staffId, String phoneNo, String address, String gender, String icNo, double Salary) {
        this.staffName = staffName;
        this.staffID = staffId ;
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = "staff";
        this.gender = gender;
        this.icNo = icNo;
        this.Salary = Salary;
        this.deliveryStatus = "Available";
    }


    public DeliveryMan() {   }
  

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    
    
    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

 

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffID() {
        return staffID;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s", staffName,staffID, phoneNo, address, status, gender, icNo, Salary, deliveryStatus);
    }
    
    public String toShortString() {
        return String.format("%-18s %-18s %-18s", staffName,staffID, deliveryStatus);
    }
}
