/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.entity;
import java.math.*;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DeliveryMan(String staffName, String phoneNo, String address,String gender) {
        this.staffName = staffName;
        this.staffID = (int) Math.ceil(Math.random() * 9999) ;
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = "staff";
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
        return  "staffName=" + staffName + ", staffID=" + staffID + ", " + status;
    }
}
