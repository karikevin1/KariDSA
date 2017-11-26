/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import java.util.Iterator;
import ModuleA.entity.Food;
import ModuleA.adt.FoodListWithIteratorInterface;
import ModuleA.adt.FoodListWithIterator;
/**
 *
 * @author User
 */
public class TestFoodListWithIterator {
    private FoodListWithIteratorInterface<Food> foodList;
    

   
    public <T> void displayList(FoodListWithIteratorInterface<T> fList){
        Iterator<T> iterator = fList.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
    public TestFoodListWithIterator(){
        foodList = new FoodListWithIterator<>();

        initializeList();
        displayList(foodList);
 
    }
    
    private void initializeList(){
        foodList.addFood(new Food("ABC"));
        foodList.addFood(new Food("AAA"));
        foodList.addOutletRest(new Food("DEF"));
        
    }
    public static void main(String[] args) {
        new TestFoodListWithIterator();
    }
    
}
