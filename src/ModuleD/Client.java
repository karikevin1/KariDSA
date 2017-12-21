/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD;

import ModuleD.adt.ScheduleADT;
import ModuleD.adt.ScheduleInterface;
import ModuleD.entity.Schedule;

/**
 *
 * @author kevin lim
 */
public class Client {
    public static ScheduleInterface<Schedule> deliveryList = new ScheduleADT<>();
    
    public ScheduleInterface<Schedule> getDeliList (){
        return this.deliveryList;      // getter for super list object
    }
    public Client(){
         if(this.deliveryList.isEmpty()){
                    Schedule initializeList1, initializeList2, initializeList3, initializeList4,initializeList5,
                            initializeList6,initializeList7,initializeList8,initializeList9,
                            initializeList10,initializeList11,initializeList12,initializeList13,
                            initializeList14,initializeList15,initializeList16,initializeList17,
                            initializeList18,initializeList19,initializeList20,initializeList21,initializeList22;
                    initializeList1= new Schedule("A001","LimKH", 1629,"A01", "pewdiepie", "0162313212", "Delivering","5min");
                    initializeList2= new Schedule("A002","LimKW", 1111,"A02", "MsTingTT", "012432434", "Delivering","5min");
                    initializeList3= new Schedule("A003","LowSK",3456, "A03", "AhLiao", "01312321213", "Delivering","5min");
                    initializeList4= new Schedule("A004","NgWD",9909, "A04", "Kazuma", "015213797", "Delivering","5min");     
                    initializeList5= new Schedule("A005","LooJW",1233,"A05","Kalima","01124356","Delivering","5min");
                    initializeList6= new Schedule("A006","LimJJ",1012,"A06", "LeongFoei", "01239909", "Delivering","5min");
                    initializeList7= new Schedule("A007","MahHW",3757,"A07","KongKong","012283747","Delivering","5min");
                    initializeList8= new Schedule("A008","LoiKH",9610,"A08","MigMing","012636383","Delivering","5min"); 
                    initializeList9= new Schedule("A009","LimNF",5566,"A09","MsTing","0192726363","Delivering","5min");
                    initializeList10= new Schedule("A010","LohKC",6969,"A10","KitKat","017265353","Delivering","5min");
                    
                    initializeList11= new Schedule("A011","LimKH", 1629,"A11", "Kari", "012213778", "Delivering","5min");
                    initializeList12= new Schedule("A012","LimKW", 1111,"A12", "Yolo", "0162328212", "Delivering","5min");
                    initializeList13= new Schedule("A013","LowSK", 3456,"A13", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList14= new Schedule("A015","LowSK", 3456,"A14", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList15= new Schedule("A016","LooJW", 1233,"A15", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList16= new Schedule("A017","LimJJ", 1012,"A16", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList17= new Schedule("A018","LimJJ", 1012,"A17", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList18= new Schedule("A019","LoiKH", 9610,"A18", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList19= new Schedule("A020","LimNF", 5566,"A19", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList20= new Schedule("A021","LimNF", 5566,"A20", "Hahaha", "0198377213", "Delivering","5min");
                    
                    //completed jobs
                    initializeList21= new Schedule("A022","LimKH", 1629,"A21", "Doggo", "0198377213", "Completed","5min");
                    initializeList22= new Schedule("A023","LimKH", 1629,"A22", "Cloud", "0198377213", "Completed","5min");
                    this.deliveryList.addSchedule(initializeList1);
                    this.deliveryList.addSchedule(initializeList2);
                    this.deliveryList.addSchedule(initializeList3);
                    this.deliveryList.addSchedule(initializeList4);
                    this.deliveryList.addSchedule(initializeList5);
                    this.deliveryList.addSchedule(initializeList6);
                    this.deliveryList.addSchedule(initializeList7);
                    this.deliveryList.addSchedule(initializeList8);
                    this.deliveryList.addSchedule(initializeList9);
                    this.deliveryList.addSchedule(initializeList10);
                    this.deliveryList.addSchedule(initializeList11);
                    this.deliveryList.addSchedule(initializeList12);
                    this.deliveryList.addSchedule(initializeList13);
                    this.deliveryList.addSchedule(initializeList14);
                    this.deliveryList.addSchedule(initializeList15);
                    this.deliveryList.addSchedule(initializeList16);
                    this.deliveryList.addSchedule(initializeList17);
                    this.deliveryList.addSchedule(initializeList18);
                    this.deliveryList.addSchedule(initializeList19);
                    this.deliveryList.addSchedule(initializeList20);
                    this.deliveryList.addSchedule(initializeList21);
                    this.deliveryList.addSchedule(initializeList22);
         }   
    }
}
