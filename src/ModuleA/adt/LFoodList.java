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
public class LFoodList<T> implements FoodInterface<T> {
    private FoodNode firstFoodNode;
    private int numberOfEntries;
    
    public LFoodList(){
        clearFood();
    }
    
    public final void clearFood(){
        firstFoodNode = null;
        numberOfEntries = 0;
    }
    
    public boolean addFood(T newEntry){
        FoodNode newFoodNode = new FoodNode<>(newEntry);
        
        if(isEmpty()){
            firstFoodNode = newFoodNode;
        }else{
            FoodNode<T> lastFoodNode = getNodeAt(numberOfEntries);
            lastFoodNode.setNextFoodNode(newFoodNode);
        }
        numberOfEntries ++;
        return true;
    }
    
    public boolean addFood(int newFoodPosition, T newEntry){
        boolean isSuccessful = true;
        
        if((newFoodPosition >= 1 && newFoodPosition <= numberOfEntries + 1)){
            FoodNode<T> newFoodNode = new FoodNode<T>(newEntry);
            if(isEmpty() || (newFoodPosition == 1)){
                newFoodNode.setNextFoodNode(firstFoodNode);
                firstFoodNode = newFoodNode;
            }else{
                FoodNode foodNodeBefore = getNodeAt(newFoodPosition - 1);
                FoodNode foodNodeAfter = foodNodeBefore.getNextFoodNode();
                newFoodNode.setNextFoodNode(foodNodeAfter);
                foodNodeBefore.setNextFoodNode(newFoodNode);
            }
            numberOfEntries ++;
        }else{
            isSuccessful = false;
        }
        return isSuccessful;
    }
    
    public T removeFood(int givenFoodPosition){
        T foodResult = null;
        
        if(givenFoodPosition >= 1 && (givenFoodPosition <= numberOfEntries)){
            if(givenFoodPosition == -1){
                foodResult = (T) firstFoodNode.getFoodData();
                firstFoodNode = firstFoodNode.getNextFoodNode();
            }else{
                FoodNode<T> nodeFoodBefore = getNodeAt(givenFoodPosition - 1);
                FoodNode<T> nodeFoodToRemove = nodeFoodBefore.getNextFoodNode();
                FoodNode<T> nodeFoodAfter = nodeFoodToRemove.getNextFoodNode();
                nodeFoodBefore.setNextFoodNode(nodeFoodAfter);
                foodResult = nodeFoodToRemove.getFoodData();
            }
            numberOfEntries --;
        }
        return foodResult;
    }
    
    public boolean replaceFood(int givenFoodPosition, T newEntry){
        boolean isSuccessful = true;
        
        if (givenFoodPosition >= 1 && (givenFoodPosition <= numberOfEntries)){
            FoodNode<T> desiredFoodNode = getNodeAt(givenFoodPosition);
            desiredFoodNode.setFoodData(newEntry);
        }else{
            isSuccessful =false;
        }
        return isSuccessful;
    }
    
    public T getFoodEntry(int givenFoodPosition){
        T foodResult = null;
        
        if (givenFoodPosition >= 1 && (givenFoodPosition <= numberOfEntries)){
            foodResult = getNodeAt(givenFoodPosition).getFoodData();
        }
        return foodResult;
    }
    
    public boolean contains(T anFoodEntry){
        boolean found = false;
        FoodNode<T> currentFoodNode = firstFoodNode;
        
        while(!found && (currentFoodNode != null)){
            if(anFoodEntry.equals(currentFoodNode.getFoodData())){
                found = true;
            }else{
                currentFoodNode = currentFoodNode.getNextFoodNode();
            }
        }
        return found;
    }
    
    public int getNumberFoodEntries(){
        return numberOfEntries;
    }
            
    public boolean isFull() {
        return false;
  }
    public boolean isEmpty() {
        boolean foodResult;

    if (numberOfEntries == 0) {
        foodResult = true;
    } else {
        foodResult = false;
    }
        return foodResult;
    }
     
    private FoodNode<T> getNodeAt(int givenPosition) {
    FoodNode<T> currentNode = firstFoodNode;

    // traverse the list to locate the desired node
    for (int counter = 1; counter < givenPosition; counter++) {
      currentNode = currentNode.getNextFoodNode();
    }

    return currentNode;
  }
    
    public String toString(){
        String outputStr = "";
        FoodNode<T> currentFoodNode = firstFoodNode;
        while(currentFoodNode != null){
            outputStr += currentFoodNode.getFoodData() + "\n";
            currentFoodNode = currentFoodNode.getNextFoodNode();
        }
        return outputStr;
    }
    
    private void displayChain(FoodNode foodNodeOne){
        if(foodNodeOne != null){
            System.out.print(foodNodeOne.getFoodData() + " ");
            displayChain(foodNodeOne.getNextFoodNode());
        }
    }

}
