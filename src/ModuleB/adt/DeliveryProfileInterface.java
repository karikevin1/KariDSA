/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;
import ModuleB.entity.DeliveryMan;
import ModuleB.entity.Delivery;
import ModuleB.adt.DeliveryADT;
import ModuleB.adt.DeliveryInterface;
/**
 *
 * @author kevin lim
 */
public interface DeliveryProfileInterface {
        public boolean createProfile (DeliveryMan dm);
        //create profile for deliveryman using deliveryman enitity 
        public boolean updateProfile(int Id,String name,String phone,String address,String gender,String IcNo, double salary);
        public ListInterface <DeliveryMan> retrieveProfile();
        public DeliveryMan retrieveSelectedProfile(int ID);
        public String retrievePendingList(int ID);
        public String toProfileString ();
}
