package ModuleC.adt;

import ModuleC.entity.Order;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateOrder implements CreateOrderInterface{
    public Order order = new Order();
    
    public void CreateOrder() {}
    
    public void updateItemList(String selectedItem){
        //Check whether the list has been initialized
        if (order.getItemList().size() == 0) {
            addNewItem(selectedItem);
        }
        else {
            boolean itemExistance = false; //count the size of item list
            //compare the selected item with evey items in the list
            for (int i = 0 ; i < order.getItemList().size() ; i++) {
                if (order.getItem(i).getMenuItem().equalsIgnoreCase(selectedItem)) {
                    removeItem(i);
                    itemExistance = true;
                }
            }
            
            //if the item didn't selected before, add it into the list
            if (!itemExistance) {
                addNewItem(selectedItem);
            }
        }
    }
    
    public void addNewItem(String selectedItem) {
        order.setItem(selectedItem);
    }
    
    public void removeItem(int i) {
        order.getItemList().remove(i);
    }
    
    public void clearOrder(){
        order.getItemList().clear();
    }
    
    public void updateItemPanel(JPanel jpItemList){
        jpItemList.removeAll();
        jpItemList.add(new JLabel(order.toString()));
        jpItemList.validate();
        jpItemList.repaint();
    }
}
