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
    public T removeFood(int givenPosition);
    public void clearFood();
    public boolean replaceFood(int givenPosition, T newEntry);
    public T getFoodEntry(int givenPosition);
    public boolean contains(T anEntry);
    public int getNumberFoodEntries();
    public boolean isEmpty();
    public boolean isFull();


}
