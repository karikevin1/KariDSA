package ModuleC.entity;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import Restaurant;

public class Order{
//    private Menu menu;
//    private Restaurant restaurant;
    private List<OrderItem> itemList = new ArrayList();
    private String custPhone;

    public void Order() {}
    
    public void setItem(String selectedItem) {
        itemList.add(new OrderItem(selectedItem));
    }
    
    public List getItemList(){
        return itemList;
    }

    public OrderItem getItem(int i){
        return itemList.get(i);
    }
    
    @Override
    public String toString(){
        String formatOutput = "";
        for (int i = 0 ; i < itemList.size() ; i++) {
            formatOutput += i+1 + ". " + itemList.get(i).getMenuItem() + " \n";
        }
        return formatOutput;
    }
}
