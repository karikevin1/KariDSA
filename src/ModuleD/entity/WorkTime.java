/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD.entity;

/**
 *
 * @author Alex Ng
 */
public class WorkTime {
    private int staffID;
    private String staffName;
    private int workedHours;
    private int workedMinutes;

    public WorkTime() {
    }

    public WorkTime(int staffID, String staffName, int workedHours, int workedMinutes) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.workedHours = workedHours;
        this.workedMinutes = workedMinutes;
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

    public int getWorkedHours() {
        return workedHours;
    }

    public int getWorkedMinutes() {
        return workedMinutes;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public void setWorkedMinutes(int workedMinutes) {
        this.workedMinutes = workedMinutes;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-10s %-10d %-10d", staffID, staffName, workedHours, workedMinutes);
    }
     
}
