/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD.adt;

/**
 *
 * @author Alex Ng
 */
public class Schedule {
    private String scheduleID; //ID for that particular delivery schedule
    private String staffName; //name of the staff
    private int staffID; //ID of delivery staff
    private String orderID; //ID of the delivered order
    private String customerName; //name of the customer
    private String customerContactNo; //contact number of customer
    private String deliveryStatus;
    private String estimatedTimeArrival; //time of estimated arrival time

    public Schedule() {
    }

    public Schedule(String scheduleID,String staffName, int staffID, String orderID,String customerName, String customerContactNo, String deliveryStatus, String estimatedTimeArrival) {
        this.scheduleID = scheduleID;
        this.orderID = orderID;
        this.staffID = staffID;
        this.staffName = staffName;
        this.customerName = customerName;
        this.customerContactNo = customerContactNo;
        this.deliveryStatus = deliveryStatus;
        this.estimatedTimeArrival = estimatedTimeArrival;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public String getOrderID() {
        return orderID;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerContactNo() {
        return customerContactNo;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getEstimatedTimeArrival() {
        return estimatedTimeArrival;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerContactNo(String customerContactNo) {
        this.customerContactNo = customerContactNo;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setEstimatedTimeArrival(String estimatedTimeArrival) {
        this.estimatedTimeArrival = estimatedTimeArrival;
    }

    @Override
    public String toString() { //to be edited
        return "Schedule{" + "scheduleID=" + scheduleID + ", orderID=" + orderID + ", staffID=" + staffID + ", staffName=" + staffName + ", customerName=" + customerName + ", customerContactNo=" + customerContactNo + ", deliveryStatus=" + deliveryStatus + ", estimatedTimeArrival=" + estimatedTimeArrival + '}';
    }
    
    public String toShortString() {
        return String.format("%-18s%-18s%-18s",orderID,customerName,customerContactNo);
    }
    
}
