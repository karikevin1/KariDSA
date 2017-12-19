/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;

/**
 *
 * @author kevin lim
 */
public interface DeliveryProfileInterface<T> {
        public void clear() ;
        //clear the profile
        public boolean createProfile (T deliEntry);
        //create profile for deliveryman using deliveryman enitity 
        public T getSelectedProfile(int Id);
        //pass in id , get the selected profile
        public boolean updateProfile(int Id,T deliEntry);
        //pass in staff id, updates the profile
        public boolean updateStaffStatus(int Id,String status);
        //pass in staff id , updates selected staff's status
        public String toString() ;
        // return all entries
        public String toReportString();
        // return report
        public void sortBasedCompletedJobs();
        // sort the list based on total completed jobs
        public T getPositionProfile(int givenPosition);
        // return selected position profile
        public int getNumberOfEntries() ;
        //return the number of men in the profile list
        public boolean isEmpty() ;
        //is the list empty?
        public boolean isFull();
        // is the list full? 
        
}
