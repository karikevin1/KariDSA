/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import ModuleA.adt.ArrayFoodListWithIterator;
import ModuleA.adt.FoodListWithIteratorInterface;
import ModuleA.entity.Food;
import java.util.Iterator;
/**
 *
 * @author User
 */
public class TestArrayFoodListWithIterator {

   private FoodListWithIteratorInterface<Food> foodList;
   private FoodListWithIteratorInterface<Food> foodList2;
  
  public <T> void displayList(FoodListWithIteratorInterface<T> fList) {
    Iterator<T> iterator = fList.getIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  public TestArrayFoodListWithIterator() {
    foodList = new ArrayFoodListWithIterator<>();
    foodList2 = new ArrayFoodListWithIterator<>();
    initializeList();
    displayList(foodList);
    displayList(foodList2);
  }
  
  private void initializeList() {
    // Hardcoded data for testing purposes only
    foodList.addFood(new Food("ABC"));
  }
  
  public static void main(String[] args) {
    new TestArrayFoodListWithIterator();
  }
    
}
