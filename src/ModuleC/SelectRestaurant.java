package ModuleC;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//extend this class with JPanel
public class SelectRestaurant extends JFrame{
    private JButton[] jbtRestaurantList = new JButton[10];
    private JPanel jpSelectRestaurant = new JPanel(new GridLayout(2, 5)); // change the row format refer to restaurantlist size, formular => row(divident | if(remainder != 0, divident++)) = restaurantlist/5
    
    public SelectRestaurant(){
        PassSelectedRestaurant passSelectedRest = new PassSelectedRestaurant();
        int loopCnt = 0;
        // get restaurantlist from restaurant class
        String[] restaurantList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        
        //change the loop refer to restaurantlist size
        for (int i = 0 ; i < 2 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                jbtRestaurantList[loopCnt] = new JButton("" + restaurantList[loopCnt]); // change the restaurantList[loopCnt] to restaurant class
                jbtRestaurantList[loopCnt].addActionListener(passSelectedRest);
                jpSelectRestaurant.add(jbtRestaurantList[loopCnt++]);
            }
        }
        
        add(jpSelectRestaurant, BorderLayout.CENTER);
        //move to main page.
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //wait for the restaurant class
    private class PassSelectedRestaurant implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();

            for (int i = 0 ; i < jbtRestaurantList.length ; i++) {
                if (src == jbtRestaurantList[i]) {
                    changePanel(new SelectMenuItem(jbtRestaurantList[i].getText()));
                }
            }
        }
    }
    
    //move this to main page, change the jpSelectRestaurant name
    public void changePanel(JPanel newPanel){
        jpSelectRestaurant.removeAll();
        jpSelectRestaurant.add(newPanel, BorderLayout.CENTER);
        jpSelectRestaurant.validate();
        jpSelectRestaurant.repaint();
    }
    
    //move to main page.
    public static void main(String args[]){
        new SelectRestaurant();
    }
    
    //test case
    public class Menu{
        int price;
        String status;
        String name;
        Restaurant restaurant;
        
        public void Menu(){
            price = 10;
            status = "Avalable";
            name = "snack plate";
        }
    }
    public class Restaurant{
        String name;
        public void Restaurant(){
            name = "kfc";
        }
    }
}
