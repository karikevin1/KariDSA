package ModuleC.entity;

public class OrderItem {
//    private Menu menuItem;
    private String menuItem;
    private int itemQTY;
    private double subTotal;

    OrderItem() {}

    
    OrderItem(String item) {
        this.menuItem = item;
    }  
    
    OrderItem(/*Menu menuItem,*/String item, int qty) {
//        this.menuItem = menuItem;
        this.menuItem = item;
        this.itemQTY = qty;
    }
//    public Menu getMenuItem() {
//        return menuItem;
//    }

//    public void setMenuItem(Menu menuItem) {
//        this.menuItem = menuItem;
//    }
    
    public String getMenuItem() {
        return menuItem;
    }
    
    public void setmenuItem(String item) {
        this.menuItem = item;
    }

    public int getItemQTY() {
        return itemQTY;
    }

    public void setItemQTY(int itemQTY) {
        this.itemQTY = itemQTY;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
