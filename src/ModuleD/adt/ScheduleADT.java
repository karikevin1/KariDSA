/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD.adt;

import ModuleD.entity.Schedule;

/**
 *
 * @author Alex Ng
 */
public class ScheduleADT<T> implements ScheduleInterface<T> {
    
    private ScheduleNode<T> firstSchedule;
    private int numberOfSchedule;
    
    public ScheduleADT(){
        
    }
    
    @Override
    public boolean addSchedule(T schedule){
        ScheduleNode <T> newSchedule = new ScheduleNode<>(schedule);
        if(isEmpty()){
            firstSchedule = newSchedule;
        }else{
            ScheduleNode <T> lastSchedule = getNodeAt(numberOfSchedule);
            lastSchedule.nextSchedule = newSchedule;
        }
        numberOfSchedule++;
        return true;
    }
    
    private ScheduleNode<T> getNodeAt(int position){
        ScheduleNode<T> current = firstSchedule;
        
        for(int i = 1; i < position; i++){
            current = current.nextSchedule;
        }
        return current;
    }
    
    @Override
    public T getSchedule(int position){
        T result = null;
        result = (T)getNodeAt(position+1).schedule;
        return result;
    }
    
    @Override
    public String getPendingList(int Id){
        String outputString ="";
        int counter =0; // count the pending task
                for(int a = 0; a < numberOfSchedule ;a++){
                    Schedule sche = (Schedule)getSchedule(a);
                    if(sche.getStaffID()== Id){
                        if(sche.getDeliveryStatus().equals("Delivering")){
                            outputString += sche.toShortString()+ "\n";
                            counter++;
                        }
                        
                    }
                }
        outputString+= "\nTotal Pending jobs:" + counter; 
        return outputString;
    }
    
    public boolean isEmpty(){
        boolean result;
        result = numberOfSchedule == 0;
        return result;
    }
    
    public int getNumberOfSchedule(){
        return numberOfSchedule;
    }
    
    public T removeSchedule(int position){
        T result = (T)getNodeAt(position).schedule;
        result = null;
        return result;
    }
    
    public T updateSchedule(int position){
        T result = (T)getNodeAt(position).schedule;
//        T updates = ; //update code 
        return result;
    }
    
    private class ScheduleNode<T>{
        private T schedule;
        private ScheduleNode nextSchedule;
        
        private ScheduleNode(T schedule){
            this.schedule = schedule;
            this.nextSchedule = null;
        }
        
        private ScheduleNode(T schedule, ScheduleNode nextSchedule){
            this.schedule = schedule;
            this.nextSchedule = nextSchedule;
        }
    }
    
//    public String toStringSchedule(){
//        String s = "";
//        boolean exception = true;
//        while(firstSchedule!=null){
//            s += firstSchedule.schedule.toString() + "\n";
//            firstSchedule = firstSchedule.nextSchedule;
//        }
//        return s;
//    }
//    @Override
//    public boolean isEmpty(){
//        return (this.firstSchedule == null) && (numberOfSchedule == 0);
//    }
}
