/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD.adt;
import ModuleB.entity.Delivery;

/**
 *
 * @author kevin lim
 */
public interface DeliveryInterface<T> {
    public boolean createDelivery (T deliEntry);
    //create delivery object
    public T getSelectedDelivery(int position);
        //pass in id , get the selected delivery object
    public int getNumberOfEntries() ;
    //get size
    public boolean isEmpty();
    //isEmpty
}
