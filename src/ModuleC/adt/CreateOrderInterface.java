package ModuleC.adt;

import ModuleC.entity.Order;

public interface CreateOrderInterface {
    public void addNewItem(String menuItem);
    public void updateItemList(String selectedItem);
    public void removeItem(int i);
    public void clearOrder();
}
