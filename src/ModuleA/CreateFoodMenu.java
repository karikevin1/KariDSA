/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import java.awt.*;
import ModuleA.adt.FoodInterface;
import ModuleA.adt.LFoodList;
import ModuleA.entity.Food;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author User
 */
public class CreateFoodMenu extends JFrame {
    private JLabel jblTitle =  new JLabel("Create Food Menu Item");
    private JLabel jblFoodName = new JLabel("Food Name :");
    private JTextField jtfFoodName = new JTextField();
    private JLabel jblFoodID = new JLabel("Food ID :");
    private JTextField jtfFoodID = new JTextField();
    private JLabel jbloutLetRest = new JLabel("Outlet Restaurant :");
    String [] outletRestaurant = {"McD", "KFC", "Pizza Hut", "Domino Pizza"};
    private JComboBox<String> jcbOutletRest = new JComboBox<String>(outletRestaurant);
    private JLabel jblPrice = new JLabel("Price :");
    private JTextField jtfPrice = new JTextField();
    private JLabel jblDesc = new JLabel("Food Description :");
    private JTextField jtfDesc = new JTextField();
    private JButton jbtCreate = new JButton("Create Food Item");
    private JTextArea jtaDisplayMenu = new JTextArea(5,20);
   
    private FoodInterface<Food> foodList = new LFoodList<>();
   
    
    public CreateFoodMenu(){
        setTitle("Create Food Menu Item");
        Font fontTitle = new Font("Arial", Font.BOLD, 18);
        Font font = new Font("Arial", Font.BOLD, 14);
        jblTitle.setFont(fontTitle);
        jblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodName.setFont(font);
        jblFoodID.setFont(font);
        jbloutLetRest.setFont(font);
        jblPrice.setFont(font);
        jblDesc.setFont(font);
        
        JPanel jpInput = new JPanel(new GridLayout(6,6));
        jpInput.add(jblFoodID);
        jpInput.add(jtfFoodID);
        jtfFoodID.setText("" + Food.getFoodID());
        jtfFoodID.setEditable(false);
        jpInput.add(jblFoodName);
        jpInput.add(jtfFoodName);
        jpInput.add(jbloutLetRest);
        jpInput.add(jcbOutletRest);
        jpInput.add(jblPrice);
        jpInput.add(jtfPrice);
        jpInput.add(jblDesc);
        jpInput.add(jtfDesc);
        jpInput.add(jbtCreate);
        add(jpInput, BorderLayout.WEST);
        
        add(jblTitle, BorderLayout.NORTH);
        
        
        InputListener listener = new InputListener();
        jbtCreate.addActionListener(listener);
        
        jtaDisplayMenu.setLineWrap(true);
        jtaDisplayMenu.setWrapStyleWord(true);
        jtaDisplayMenu.setEditable(false);
        jtaDisplayMenu.setFont(font);
        JScrollPane scrollPane = new JScrollPane(jtaDisplayMenu);
        add(scrollPane, BorderLayout.EAST);
        jtfFoodName.grabFocus();
    }
    
    private class InputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           String foodName = jtfFoodName.getText();  
           String foodOutlet = (String)jcbOutletRest.getSelectedItem();
           String foodPrice = jtfPrice.getText();
           String foodDesc = jtfDesc.getText();
           Food food = new Food(foodName);
           foodList.addFood(food);
           jtfFoodName.grabFocus();
           
     
           jtfFoodID.setText("" + Food.getFoodID());
           jtaDisplayMenu.setText("Menu List :\n" + foodList);
           jtfFoodName.setText("");
           jcbOutletRest.setSelectedItem("");
           jtfPrice.setText("");
           jtfDesc.setText("");
           
        }
    }
    
    

    public static void main(String[] args) {
    CreateFoodMenu frame = new CreateFoodMenu();
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
    
}
