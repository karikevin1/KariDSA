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
    private String staffName;   // staff name (First name, Last name)
    private int staffID;             // staff unique ID 
    private String phoneNo;    // staff phone number
    private String address;      // staff home addresses
    private String status;        // "Staff", "Resigned" , "Retired"
    private String gender;       // "Male", "Female"
    private String icNo;           // staff identity card no
    private double salary;        // staff salary (RM)
    private String deliveryStatus;                  //"Delivering" , "Available"
    private int pendingJobs;                         // sum of pending deliveries now
    private int totalDeliveriesCompleted;     // sum of all the jobs done daily
    private int kmTravelled;               // miles travelled per day (round up km)
    private int yearsOfService;          // years of staying in the company
    
    private Random rand = new Random();     // for randomize staff id

    //this constructor for newly created id
    public DeliveryMan(String staffName, String phoneNo, String address,
            String gender, String icNo, double salary) {    
        this.staffName = staffName;
        this.staffID = rand.nextInt((9999 - 1000) + 1) + 1000 ; // random number from 1000 - 9999
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = "staff";   // "staff" by default
        this.gender = gender;
        this.icNo = icNo;
        this.salary = salary;
        this.deliveryStatus = "Available"; // "available" as default
        this.pendingJobs = 0;                          //0
        this.totalDeliveriesCompleted = 0;      //0
        this.kmTravelled = 0;                           //0
        this.yearsOfService=0;
    }
    
    //this constructor for predefined data
    public DeliveryMan(String staffName, int staffID, String phoneNo, String address, String gender, String icNo, 
            double salary, int pendingJobs, int totalDeliveriesCompleted, int kmTravelled,int yearsOfSevice) {
        this.staffName = staffName;
        this.staffID = staffID; // random number from 1000 - 9999
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = "staff";   // "staff" by default
        this.gender = gender;
        this.icNo = icNo;
        this.salary = salary;
        this.deliveryStatus = "Delivering"; // "available" as default
        this.pendingJobs = pendingJobs;
        this.totalDeliveriesCompleted = totalDeliveriesCompleted;
        this.kmTravelled = kmTravelled;
        this.yearsOfService = yearsOfSevice;
    }
    
    public DeliveryMan() {   }
   

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getPendingJobs() {
        return pendingJobs;
    }

    public void setPendingJobs(int pendingJobs) {
        this.pendingJobs = pendingJobs;
    }

    public int getTotalDeliveriesCompleted() {
        return totalDeliveriesCompleted;
    }

    public void setTotalDeliveriesCompleted(int totalDeliveriesCompleted) {
        this.totalDeliveriesCompleted = totalDeliveriesCompleted;
    }

    public int getKmTravelled() {
        return kmTravelled;
    }

    public void setKmTravelled(int kmTravelled) {
        this.kmTravelled = kmTravelled;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }
    
    public String toReportString() {
        return String.format("%-20s%-25s%-25s%-25s%-25s",staffName,staffID,totalDeliveriesCompleted,kmTravelled,yearsOfService);
    }

    public String toString() {
        return String.format("%-20.10s%-20.10s%-20.15s%-20.15s%-18.15s%-20.15s%-25.20s"
                + "%-20.15s%-20.15s%-27.20s%-27.15s%-22.15s%-22.15s",
                staffName, staffID, phoneNo, address, status, gender, icNo, salary, deliveryStatus, 
                pendingJobs, totalDeliveriesCompleted, kmTravelled,yearsOfService);
    }
    
    
}
