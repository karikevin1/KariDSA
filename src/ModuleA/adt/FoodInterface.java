/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;

/**
 *
 * @author User
 */
public interface FoodInterface<T> {
    public boolean addFood(T newEntry);
    public boolean addFood(int newPosition, T newEntry);
    public boolean addOutletRest(T newEntry);
    public boolean addOutletRest(int newPosition, T newEntry);
    public boolean addFoodPrice(T newEntry);
    public boolean addFoodPrice(int newPosition, T newEntry);
    public boolean addFoodDesc(T newEntry);
    public boolean addFoodDesc(int newPosition, T newEntry);
//   public T remove(int givenPosition);
    public void clear();
 //   public boolean replace(int givenPosition, T newEntry);
    public T getEntry(int givenPosition);
    public boolean contains(T anEntry);
    public int getNumberOfEntries();
    public boolean isEmpty();
    public boolean isFull();


}
