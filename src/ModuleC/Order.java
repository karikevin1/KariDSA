package ModuleC;

//import Menu;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import Restaurant;

public class Order{
//    private Menu menu;
//    private Restaurant restaurant;
    String rest;
    private List<String> itemList = new ArrayList();
    private String custPhone;
    private double price;

    public void addNewItem(String item){
        this.itemList.add(item);
    }
    
    public void removeItem(int i) {
        itemList.remove(i);
    }
    
    public List getItemList(){
        return itemList;
    }

    public String getItem(int i){
        return itemList.get(i);
    }
    
    public Order getOrder(){
        return this;
    }
    
    public void clearOrder(){
        this.itemList.clear();
    }
    
    public void updateItemList(String selectedItem){
        //Check whether the list has been initialized
        if (this.itemList.size() == 0) {
            this.addNewItem(selectedItem);
        }
        else {
            boolean itemExistance = false; //count the size of item list
            //compare the selected item with evey items in the list
            for (int i = 0 ; i < itemList.size() ; i++) {
                if (itemList.get(i).equalsIgnoreCase(selectedItem)) {
                    this.removeItem(i);
                    itemExistance = true;
                }
            }
            
            //if the item didn't selected before, add it into the list
            if (!itemExistance) {
                this.addNewItem(selectedItem);
            }
        }
    }
    
    public void updateItemPanel(JPanel jpItemList){
        jpItemList.removeAll();
        jpItemList.add(new JLabel(this.toString()));
        jpItemList.validate();
        jpItemList.repaint();
    }
    
    @Override
    public String toString(){
        String formatOutput = "";
        for (int i = 0 ; i < itemList.size() ; i++) {
            formatOutput += i+1 + ". " + itemList.get(i) + " \n";
        }
        return formatOutput;
    }
}
