/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;

/**
 *
 * @author User
 */
public class Food {
    public static int foodID = 1000;
    private String foodName;
    private int foodNumber;
    private String outletRestaurant;
    private String foodPrice;
    private String foodDesc;
    
    public Food(int foodNumber){
        this.foodNumber = foodNumber;
    }
    
    public Food(String foodName){
        this.foodName = foodName;
        this.foodNumber = foodID++;
    }

    public static int getFoodID() {
        return foodID;
    }

    public static void setFoodID(int foodID) {
        Food.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }

    public String getOutletRestaurant() {
        return outletRestaurant;
    }

    public void setOutletRestaurant(String outletRestaurant) {
        this.outletRestaurant = outletRestaurant;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public String toString(){
        return String.format("FoodID : %-10d \nFood Name : %-20s \nOutlet Restaurant : %-20s \nPrice : %-20s \nFood Description : %-30s\n", foodID, foodName, outletRestaurant, foodPrice, foodDesc);
    }
}
