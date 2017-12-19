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
            String outputString = String.format("%-18s%-18s%-18s%-18s%-18s%-18s%-20s%-20s%-18s%-18s%-18s%-10s%-16s\n","Staff name","StaffID","PhoneNo","Address","Status","Gender","ICNO","Salary","DeliveryState","Pendingjobs","TotalDeliveries","Distance","YearsServ");
            DeliveryManNode<T> currentMan = firstMan;
            while (currentMan != null){
                outputString += "" + currentMan.man + "\n";
                currentMan = currentMan.nextMan;
            }
           
            return outputString;
        }
        
        @Override
        public String toReportString(){
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



