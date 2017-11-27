/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;
import ModuleB.entity.Delivery;

/**
 *
 * @author kevin lim
 */
public interface DeliveryInterface {
    public ListInterface<Delivery> retrieveList();
}
