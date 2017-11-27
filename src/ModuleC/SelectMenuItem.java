package ModuleC;

import ModuleC.adt.CreateOrder;
import ModuleC.entity.Order;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectMenuItem extends JPanel{
    private JButton[] jbtMenuList = new JButton[10];
    private JButton jbtOrder = new JButton("Confirm Order");
    private JButton jbtCancel = new JButton("Cancel Order");
    private JButton jbtReset = new JButton("Clear Cart");
    private JPanel jpSelectMenu = new JPanel(new GridLayout(2, 5));
    private JPanel jpOrder = new JPanel(new BorderLayout());
    private JPanel jpItemList = new JPanel();
    private JPanel jpOrderAction = new JPanel();
    public CreateOrder createOrder = new CreateOrder();
    //change to restaurant class
    String rest;
    
    public SelectMenuItem(String rest){
        this.rest = rest;
        
        PassSelectedMenu passSelectedMenu = new PassSelectedMenu();
        int loopCnt = 0;
        //change to menu class
        String[] menuList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        
        // show all available Item on the Frame
        for (int i = 0 ; i < 2 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                jbtMenuList[loopCnt] = new JButton("" + menuList[loopCnt]);
                jbtMenuList[loopCnt].addActionListener(passSelectedMenu);
                jpSelectMenu.add(jbtMenuList[loopCnt++]);
            }
        }
        
        //initialize GUI
        setLayout(new BorderLayout());
        OrderActListn orderAL = new OrderActListn();
        jbtOrder.addActionListener(orderAL);
        jbtCancel.addActionListener(orderAL);
        jbtReset.addActionListener(orderAL);
        add(jpSelectMenu, BorderLayout.CENTER);
        
        jpOrderAction.add(jbtOrder);
        jpOrderAction.add(jbtCancel);
        jpOrderAction.add(jbtReset);
        jpOrder.add(jpItemList, BorderLayout.CENTER);
        jpOrder.add(jpOrderAction, BorderLayout.SOUTH);
        add(jpOrder, BorderLayout.EAST);
    }
    
    private class PassSelectedMenu implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();
            //get the selected button to update the item list.
            for (JButton jbt : jbtMenuList) {
                if (jbt == buttonClicked){
                    System.out.println(jbt.getText());
                    createOrder.updateItemList(jbt.getText());
                }
            }
            System.out.print(createOrder.order.toString());
            createOrder.updateItemPanel(jpItemList);
        } 
    }
    
    private class OrderActListn implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            
            if (src.equals(jbtOrder)){
                System.out.println("Order");
                
            }else if (src.equals(jbtReset)){
                System.out.println("Reset");
                createOrder.clearOrder();
                createOrder.updateItemPanel(jpItemList);
            }else if (src.equals(jbtCancel)){
                System.out.println("Cancel");
                
            }
        }
    }
}
