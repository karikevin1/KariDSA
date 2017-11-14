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
public interface DeliveryProfileInterface {
        public boolean createProfile (DeliveryMan dm);
        //create profile for deliveryman using deliveryman enitity 
        public String retrieveProfile(int Id);
        public String toProfileString ();
}
