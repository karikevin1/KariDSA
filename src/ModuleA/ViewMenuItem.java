/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import java.util.*;
import javax.swing.*;
import ModuleA.adt.FoodInterface;
import ModuleA.adt.ArrayFoodList;
import ModuleA.adt.LFoodList;
import ModuleA.entity.Food;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author User
 */
public class ViewMenuItem extends JFrame {
    private JLabel jblTitle = new JLabel("View Menu");
    private JLabel jblRestList = new JLabel("Restaurant Outlet List :");
    String [] RestList = {"McD", "KFC", "Pizza Hut", "Domino Pizza"};
    private JComboBox<String> jcbOutletRest = new JComboBox<String>(RestList);
    private JTextArea jtaDisplayMenuList = new JTextArea(5,20);
    private JLabel jblFoodID = new JLabel("Food ID :");
    private JTextField jtfFoodID = new JTextField();
    
    
    private FoodInterface<Food> foodList = new LFoodList<>();
    
    public ViewMenuItem(){
        setTitle("View Menu Item");
        Font fontTitle = new Font("Arial", Font.BOLD, 18);
        Font font = new Font("Arial", Font.BOLD, 14);
        jblTitle.setFont(fontTitle);
        jblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jblRestList.setFont(font);
        jcbOutletRest.setFont(font);
        jblFoodID.setFont(font);
        jtfFoodID.setFont(font);
        
        JPanel jpInput = new JPanel(new GridLayout(2,2));
        jpInput.add(jblTitle);
        jpInput.add(jblRestList);
        jpInput.add(jcbOutletRest);
        add(jpInput, BorderLayout.WEST);
        add(jblTitle, BorderLayout.NORTH);
        
        InputListener listener = new InputListener();
        jcbOutletRest.addActionListener(listener);
        
        jtaDisplayMenuList.setLineWrap(true);
        jtaDisplayMenuList.setWrapStyleWord(true);
        jtaDisplayMenuList.setEditable(false);
        jtaDisplayMenuList.setFont(font);
        JScrollPane scrollPane = new JScrollPane(jtaDisplayMenuList);
        add(scrollPane, BorderLayout.EAST);
        
        
        
    }
    private class InputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
          
       //    foodList.addOutletRest(foodRestOut);
       //    foodList.addFoodPrice(FoodPrice);
       //    foodList.addFoodDesc(FoodDesc);          
           jtaDisplayMenuList.setText("Menu List :");
           if(jcbOutletRest.getSelectedItem() == "McD"){
               jtaDisplayMenuList.setText("Food ID : 1001\n  Food Name : McD Chicken\n  Price : RM8.50 \n Description : Delicious!!");
               
           }
           else if(jcbOutletRest.getSelectedItem() == "KFC"){
               jtaDisplayMenuList.setText("Food ID : 1010 \n Food Name : KFC Chizza \n Price : RM12.50 \n Description : Good Chicken Favour!!");
           }
           else if(jcbOutletRest.getSelectedItem() == "Pizza Hut"){
               jtaDisplayMenuList.setText("Food ID : 1020 \n Food Name : Pepperoni \n Price : RM15.00 \n Description : New Favour!!");
           }
           else if(jcbOutletRest.getSelectedItem() == "Domino Pizza"){
               jtaDisplayMenuList.setText("Food ID : 1030 \n Food Name : BBQ Chicken \n Price : RM13.00 \n Description : New Favour!!");
           }
           
        }
    }
    public static void main(String[] args) {
    ViewMenuItem frame = new ViewMenuItem();
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
    
}
