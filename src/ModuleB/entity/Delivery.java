/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.entity;



/**
 *
 * @author kevin lim
 */
public class Delivery {
    private String staffName;
    private int staffID;
    private String orderNo;
    private String customerName;
    private String customerContactNo;
    private String deliverymanStatus;

    public Delivery(String staffName, int staffID, String orderNo, String customerName, String customerContactNo, String deliverymanStatus) {
        this.staffName = staffName;
        this.staffID = staffID;
        this.orderNo = orderNo;
        this.customerName = customerName;
        this.customerContactNo = customerContactNo;
        this.deliverymanStatus = deliverymanStatus;
    }

    public Delivery() {
    }
    
    
    public String getStaffName() {
        return staffName;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerContactNo() {
        return customerContactNo;
    }

    public String getDeliverymanStatus() {
        return deliverymanStatus;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerContactNo(String customerContactNo) {
        this.customerContactNo = customerContactNo;
    }

    public void setDeliverymanStatus(String deliverymanStatus) {
        this.deliverymanStatus = deliverymanStatus;
    }

    @Override
    public String toString() {
        return String.format("%-18s%-18s%-18s%-18s%-18s%-18s", staffName,staffID,orderNo,customerName,customerContactNo,deliverymanStatus);
    }
    
    public String toShortString() {
        return String.format("%-18s%-18s%-18s",orderNo,customerName,customerContactNo);
    }
    
}


