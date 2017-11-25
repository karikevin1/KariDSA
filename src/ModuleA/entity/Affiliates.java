/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Affiliates implements Serializable {
    public static int staffNo = 1000;
    private String staffName;
    private int ICnumber;
    private int number;
    
    public Affiliates(int number){
        this.number = number;
    }
    
    public Affiliates(String staffName){
        this.staffName = staffName;
        this.number = staffNo++;
    }
    
    public String getName(){
        return staffName;
    }
    
    public void setName(String staffName){
        this.staffName = staffName;
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public static int getStaffNo(){
        return staffNo;
    }
    
    public void setStaffNo(int staffNo){
        Affiliates.staffNo = staffNo;
    }
    
    public int getICNo(){
        return ICnumber;
    }
    
    public void setICNo(int ICnumber){
        this.ICnumber = ICnumber;
    }
    
    @Override
    public int hashCode(){
        int hash = 3;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Affiliates other = (Affiliates) obj;
        if(this.number != other.number){
            return false;
        }
        return true;
    }
    @Override
  public String toString() {
    return String.format("Affiliates List\n Staff No : %-10d Staff Name : %-14s\n", number, staffName);
    
  }
  
  
}

