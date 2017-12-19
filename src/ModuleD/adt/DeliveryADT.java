/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD.adt;

import ModuleD.adt.Schedule;

/**
 *
 * @author kevin lim
 */
public class DeliveryADT<T> implements DeliveryInterface<T>{
    private DeliveryNode<T> firstNode;
    private int numberOfDelivery;
    
    @Override
    public boolean createDelivery (T deliEntry){
         DeliveryNode <T> newDelivery = new DeliveryNode<>(deliEntry);
           
           if(isEmpty())
           {
               firstNode = newDelivery;   
           }else{
              DeliveryNode<T> last = getNodeAt(numberOfDelivery);
              last.nextDeli = newDelivery;
           }
           
           numberOfDelivery++;
           return true;
    }
    
    @Override
    public T getSelectedDelivery(int positon){
        T result = null;
            result = (T)getNodeAt(positon+1).delivery;
        return result;
    }
    
    private DeliveryNode<T> getNodeAt(int givenPosition) {
           DeliveryNode<T> current = firstNode;

           // traverse the list to locate the desired node
           for (int counter = 1; counter < givenPosition; counter++) {
             current = current.nextDeli;
           }
           
           return current;
    }
    
    @Override
    public boolean isEmpty() {
          boolean result;

          result = numberOfDelivery == 0;

          return result;
    }
    
    @Override
    public int getNumberOfEntries() {
          return numberOfDelivery;
    }
    
    private class DeliveryNode<T> {

          private T delivery;
          private DeliveryNode nextDeli;

          private DeliveryNode(T delivery) {
            this.delivery = delivery;
            this.nextDeli = null;
          }

          private DeliveryNode(T delivery, DeliveryNode nextDeli) {
            this.delivery = delivery;
            this.nextDeli = nextDeli;
          }
    } // end Node
}
