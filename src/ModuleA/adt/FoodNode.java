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
public class FoodNode<T> {
    private T foodData;
    private FoodNode nextFoodNode;
    
    public FoodNode(T foodData){
        this.foodData = foodData;
        nextFoodNode = null;
    }
    
    public FoodNode(T foodData, FoodNode nextFoodNode){
        this.foodData = foodData;
        this.nextFoodNode = nextFoodNode;
    }
    
    public void setFoodData(T foodData){
        this.foodData = foodData;
    }
    
    public void setNextFoodNode(FoodNode nextFoodNode){
        this.nextFoodNode = nextFoodNode;
    }
    
    public T getFoodData(){
        return foodData;
    }
    
    public FoodNode getNextFoodNode(){
        return nextFoodNode;
    }
}
