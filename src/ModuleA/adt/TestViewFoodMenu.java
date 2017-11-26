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
public class TestViewFoodMenu {
    public static void main(String args[]){
        FoodNode<String> node1 = new FoodNode<>("Food ID : 1000");
        FoodNode<String> node2 = new FoodNode<>("Food Name : McD Chicken");
        FoodNode<String> node3 = new FoodNode<>("Outlet Restaurant : MCD");
        FoodNode<String> node4 = new FoodNode<>("Price : RM12.00");
        FoodNode<String> node5 = new FoodNode<>("Food Description : Delicious");
        
        FoodNode<String> firstNode;
       
        
        System.out.println("Menu List\n");
        
        for(firstNode = node1; firstNode!=null; firstNode=firstNode.getNextFoodNode()){
            System.out.println(firstNode.getFoodData() + "");
        }
        
        for(firstNode=node2; firstNode!=null; firstNode=firstNode.getNextFoodNode()){
            System.out.println(firstNode.getFoodOutlet());
        }
        
        System.out.println();
    }
}

