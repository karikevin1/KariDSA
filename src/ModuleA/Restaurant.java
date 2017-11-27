/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulea;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author User
 */
public class Restaurant {
    private String restName;
    private String restAddress;
    private int restTelNo;
    
    String[] restNameList = { "Mcd", "KFC", "Pizza Hut", "Domino"};
    String[] restAddressList = {"Setapak", "Wangsa Maju", "KLCC", "Mid Valley"};
    String[] restTelNoList = {"1300882525, 1300882424, 1300882323, 1300882222"};
    
    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestAddress() {
        return restAddress;
    }

    public void setRestAddress(String restAddress) {
        this.restAddress = restAddress;
    }

    public int getRestTelNo() {
        return restTelNo;
    }

    public void setRestTelNo(int restTelNo) {
        this.restTelNo = restTelNo;
    }
    
    
    public String toString(){
        return String.format("Restaurant Outlet List \n Restaurant Name : %-20s Restaurant Address : %-20s Restaurant Telephone Number : %-10d", restName, restAddress, restTelNo);
    }
}
