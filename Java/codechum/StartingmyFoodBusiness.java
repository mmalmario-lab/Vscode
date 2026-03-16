package codechum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartingmyFoodBusiness {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setTitle("Food Kiosk");
        frame.setLayout(new FlowLayout());

     
       Checkbox pizzaCheckBox = new Checkbox("Pizza");
       Checkbox burgerCheckBox = new Checkbox("Burger");
      Checkbox  teaCheckBox = new Checkbox("Tea");
      Button  orderButton = new Button("Order");
      Label totalCostLabel = new Label("Total Cost: 0.00");
      
        pizzaCheckBox.setName("pizzaCheckBox");
        burgerCheckBox.setName("burgerCheckBox");
        teaCheckBox.setName("teaCheckBox");
        orderButton.setName("orderButton");
        totalCostLabel.setName("totalCostLabel");

        frame.add(pizzaCheckBox);
        frame.add(burgerCheckBox);
        frame.add(teaCheckBox);
        frame.add(orderButton);
        frame.add(totalCostLabel);

     orderButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
                 double totalCost = 0.0;
        if (pizzaCheckBox.getState()) {
            totalCost += 100.0;
        }
        if (burgerCheckBox.getState()) {
            totalCost += 80.0;
        }
        if (teaCheckBox.getState()) {
            totalCost += 50.0;
        }
             totalCostLabel.setText(String.format("%.2f", totalCost));
            }
        });
        
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        frame.setSize(300,150);
        frame.setVisible(true);

    }
}
