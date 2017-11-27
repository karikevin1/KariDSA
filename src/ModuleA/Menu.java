/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulea;

/**
 *
 * @author User
 */
public class Menu {
    private String menuName;
    private double menuPrice;
    private String menuStatus;
    private String menuPromo;
    
    String [] menuNameList = {"Mcd Chicken", "Jimat Box", "Pepperoni", "BBQ Chicken"};
    String [] menuPriceList = {"9.00", "13.00", "15.50", "12.50"};
    String [] menuStatusList = {"Available", "Not Available", "Available", "Not Available"};
    String [] menuPromoList = {"In promotion", "Not in promotion", "In promotion", "Not in promotion"};

    
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus;
    }

    public String getMenuPromo() {
        return menuPromo;
    }

    public void setMenuPromo(String menuPromo) {
        this.menuPromo = menuPromo;
    }
    
    public String toString(){
        return String.format("Restaurant Menu \n Menu Name : %-20s Menu Price : %.2f Menu Status : %-20s Menu Promotion : %-20s", menuName, menuPrice, menuStatus, menuPromo);
    }
   
}
