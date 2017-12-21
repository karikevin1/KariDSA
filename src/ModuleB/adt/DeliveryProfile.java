/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;
import ModuleB.entity.DeliveryMan;

/**
 *
 * @author kevin lim
 */
public class DeliveryProfile<T> implements DeliveryProfileInterface<T> {
    
    private DeliveryManNode<T> firstMan;
    private int numberOfMen;
    
        public DeliveryProfile(){
             clear();
        }
    
        @Override
        public final void clear() {
          firstMan = null;
          numberOfMen = 0;
        }
        
        

        @Override
        public boolean createProfile (T deliEntry){
            DeliveryManNode <T> newMan = new DeliveryManNode<>(deliEntry);

            if(isEmpty())
            {
                firstMan = newMan;   
            }else{
               DeliveryManNode<T> lastMan = getNodeAt(numberOfMen);
               lastMan.nextMan = newMan;
            }

            numberOfMen++;
            return true;
         }
        
        @Override
        public T getSelectedProfile(int Id){
            T result = null;
            DeliveryManNode currentMan = firstMan;
            for (int counter = 1; counter <= numberOfMen; counter++) {
                DeliveryMan temp = (DeliveryMan)currentMan.man; 
                if(temp.getStaffID() == Id){
                   result =(T)currentMan.man;
                }else{
                    currentMan = currentMan.nextMan;
                }
            }
            return result;
        }
        
        @Override
        public boolean updateProfile(int Id,T deliEntry){
            boolean ans = false; 
            DeliveryManNode currentMan = firstMan;
            DeliveryMan temp = new DeliveryMan();
            for (int counter = 1; counter <= numberOfMen; counter++) {
                temp = (DeliveryMan)currentMan.man; 
                if(temp.getStaffID() == Id){
                    currentMan.man = deliEntry; 
                    ans = true;
                }else{
                    currentMan = currentMan.nextMan;
                }
            }
            return ans;
        }
        
        @Override
        public boolean updateStaffStatus(int Id, String status){
            boolean ans = false; 
            DeliveryManNode<T> currentMan = firstMan;
            DeliveryMan temp = new DeliveryMan();
            for (int counter = 1; counter <= numberOfMen; counter++) {
                temp = (DeliveryMan)currentMan.man; 
                if(temp.getStaffID() == Id){
                    temp.setStatus(status);
                    currentMan.man = (T)temp; 
                    ans = true;
                }else{
                    currentMan = currentMan.nextMan;
                }
            }
            return ans;
        }
        
        @Override
        public String toString() {
            String outputString = String.format("%-18s%-18s%-23s%-20s%-18s%-18s%-30s%-20s%-23s%-18s%-18s%-10s%-16s\n","Staff name","StaffID","PhoneNo","Address","Status","Gender","ICNO","Salary","DeliveryState","Pendingjobs","TotalDeliveries","Distance","YearsServ");
            DeliveryManNode<T> currentMan = firstMan;
            while (currentMan != null){
                outputString += "" + currentMan.man + "\n";
                currentMan = currentMan.nextMan;
            }
           
            return outputString;
        }
        
        @Override
        public String toReportString(){
            sortBasedCompletedJobs();
            String outputString = String.format("%-18s%-18s%-18s%-18s%-18s\n","StaffName","StaffID","TotalDeliveries","Distance","YearsServ");
            DeliveryManNode<T> currentMan = firstMan;
            int countGrandTotal =0;
            while (currentMan != null){
                DeliveryMan temp = (DeliveryMan)currentMan.man;
                countGrandTotal += temp.getTotalDeliveriesCompleted();
                outputString +=temp.toReportString()+"\n";
                currentMan = currentMan.nextMan;
            }
            outputString += "\n"+ "Grand Total Delivery of all Delivery Man =  "+ countGrandTotal;
           
            return outputString;
        }
        
        @Override
        // this is a selection sort that sort the profile list according to best delivery man ( total completed deliveries )
        public void sortBasedCompletedJobs(){
            DeliveryManNode<T> sortMan = firstMan;
            for(int a = 1; a <= this.numberOfMen; a++){
                    int bestDeliveryCount =0;
                    DeliveryManNode<T> currentMan = sortMan;      
                    //first loop to differentiate sorted part & unsorted part
                    for(int b= a ; b <= numberOfMen; b++){
                        DeliveryMan currentTemp = (DeliveryMan)currentMan.man;
                        int currentCount = currentTemp.getTotalDeliveriesCompleted();
                        //compare entity behaviour, always swap the highest with the to be sorted position
                        if(currentCount > bestDeliveryCount){       
                            T temp = sortMan.man;                       //store the selected position to be part of sorted
                            sortMan.man = currentMan.man;        //swap the highest score with the selected position
                            currentMan.man = temp;                    //swap the storage of the selected position to the highest score position
                            bestDeliveryCount = currentCount;
                        }
                        currentMan = currentMan.nextMan;
                    }
                    
                    sortMan = sortMan.nextMan;
            }   
        }    
        
        @Override
        // this is a selection sort that sort the profile list according to experience (years of services)
        public void sortBasedYearService(){
            DeliveryManNode<T> sortMan = firstMan;
            for(int a = 1; a <= this.numberOfMen; a++){
                    int bestExperienceCount =0;
                    DeliveryManNode<T> currentMan = sortMan;      
                    //first loop to differentiate sorted part & unsorted part
                    for(int b= a ; b <= numberOfMen; b++){
                        DeliveryMan currentTemp = (DeliveryMan)currentMan.man;
                        int currentCount = currentTemp.getYearsOfService();
                        //compare entity behaviour, always swap the highest with the to be sorted position
                        if(currentCount > bestExperienceCount){       
                            T temp = sortMan.man;                       //store the selected position to be part of sorted
                            sortMan.man = currentMan.man;        //swap the highest score with the selected position
                            currentMan.man = temp;                    //swap the storage of the selected position to the highest score position
                            bestExperienceCount = currentCount;
                        }
                        currentMan = currentMan.nextMan;
                    }
                    
                    sortMan = sortMan.nextMan;
            }   
        }
        @Override
        public void sortBasedPendingJobs(){
            DeliveryManNode<T> sortMan = firstMan;
            for(int a = 1; a <= this.numberOfMen; a++){
                    int lowestPending = 10000;
                    DeliveryManNode<T> currentMan = sortMan;      
                    //first loop to differentiate sorted part & unsorted part
                    for(int b= a ; b <= numberOfMen; b++){
                        DeliveryMan currentTemp = (DeliveryMan)currentMan.man;
                        int currentCount = currentTemp.getPendingJobs();
                        //compare entity behaviour, always swap the highest with the to be sorted position
                        if(currentCount < lowestPending){       
                            T temp = sortMan.man;                       //store the selected position to be part of sorted
                            sortMan.man = currentMan.man;        //swap the highest score with the selected position
                            currentMan.man = temp;                    //swap the storage of the selected position to the highest score position
                            lowestPending = currentCount;
                        }
                        currentMan = currentMan.nextMan;
                    }
                    
                    sortMan = sortMan.nextMan;
            } 
        }
        
        @Override
        public void setDeliveryStatus(int Id,String status,boolean pending,boolean completed){
            DeliveryManNode<T> currentMan = firstMan;
            DeliveryMan temp = new DeliveryMan();
            for (int counter = 1; counter <= numberOfMen; counter++) {
                temp = (DeliveryMan)currentMan.man; 
                if(temp.getStaffID() == Id){
                    temp.setDeliveryStatus(status);
                    if(pending == true){
                        int temp1 = temp.getPendingJobs();
                        temp.setPendingJobs(temp1++);
                    }else if(completed == true){
                        int temp1 = temp.getTotalDeliveriesCompleted();
                        int temp2 = temp.getPendingJobs();
                        temp.setPendingJobs(--temp2);
                        temp.setTotalDeliveriesCompleted(temp1++);
                    }
                    currentMan.man = (T)temp; 
                }else{
                    currentMan = currentMan.nextMan;
                }
            }
        }
        
        @Override
        public T getPositionProfile(int givenPosition){
            T result = null;
            result = (T) getNodeAt(givenPosition).man;
            return result;
        }
        
        private DeliveryManNode<T> getNodeAt(int givenPosition) {
           DeliveryManNode<T> currentMan = firstMan;

           // traverse the list to locate the desired node
           for (int counter = 1; counter < givenPosition; counter++) {
             currentMan = currentMan.nextMan;
           }
           
           return currentMan;
        }
        
        @Override
        public int getNumberOfEntries() {
          return numberOfMen;
        }
        
        @Override
        public boolean isEmpty() {
          boolean result;

          result = numberOfMen == 0;

          return result;
        }
        
        @Override
        public boolean isFull() {
          return false;
        }

        private class DeliveryManNode<T> {

          private T man;
          private DeliveryManNode nextMan;

          private DeliveryManNode(T man) {
            this.man = man;
            this.nextMan = null;
          }

          private DeliveryManNode(T man, DeliveryManNode nextMan) {
            this.man = man;
            this.nextMan = nextMan;
          }
        } // end Node
}



