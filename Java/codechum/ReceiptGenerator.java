
package codechum;

import java.awt.*;
import java.awt.event.*;

public class ReceiptGenerator {
    public static void main(String[] args) {
        Frame frame = new Frame("Receipt Generator");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 500);
        // Components
        Checkbox shoesCheckBox = new Checkbox("Shoes");
        Checkbox pantsCheckBox = new Checkbox("Pants");
        Checkbox shirtCheckBox = new Checkbox("Shirt");
        Checkbox defaultCheckBox = new Checkbox();
        Checkbox specialCheckBox = new Checkbox();
        TextField nameTextField = new TextField(20);
        Choice paymentMethodChoice = new Choice();
        paymentMethodChoice.add("Cash");
        paymentMethodChoice.add("Credit Card");
        paymentMethodChoice.add("Debit Card");
        TextArea receiptTextArea = new TextArea(10, 40);
        Button generateButton = new Button("Generate Receipt");

        defaultCheckBox.addItemListener(e -> {
            if (defaultCheckBox.getState())
                specialCheckBox.setState(false);
        });
        specialCheckBox.addItemListener(e -> {
            if (specialCheckBox.getState())
                defaultCheckBox.setState(false);
        });

        shoesCheckBox.setName("shoesCheckBox");
        pantsCheckBox.setName("pantsCheckBox");
        shirtCheckBox.setName("shirtCheckBox");
        defaultCheckBox.setName("defaultCheckBox");
        specialCheckBox.setName("specialCheckBox");
        nameTextField.setName("nameTextField");
        paymentMethodChoice.setName("paymentMethodChoice");
        receiptTextArea.setName("receiptTextArea");
        generateButton.setName("generateButton");

        // Button action
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double shoesPrice = 200.0;
                double pantsPrice = 150.0;
                double shirtPrice = 120.0;
                double defaultDiscount = 0.05;
                double specialDiscount = 0.15;
                double subtotal = 0.0;
                StringBuilder items = new StringBuilder();
                if (shoesCheckBox.getState()) {
                    subtotal += shoesPrice;
                    items.append("Shoes, ");
                }
                if (pantsCheckBox.getState()) {
                    subtotal += pantsPrice;
                    items.append("Pants, ");
                }
                if (shirtCheckBox.getState()) {
                    subtotal += shirtPrice;
                    items.append("Shirt, ");
                }

                if (items.length() > 0) {
                    items.setLength(items.length() - 2); // remove last ", "
                }
                double discount = 0.0;

                if (specialCheckBox.getState()) {
                    discount = specialDiscount;
                } else if (defaultCheckBox.getState() && subtotal >= 300) {
                    discount = defaultDiscount;
                }
                double total = subtotal * (1 - discount);
                String name = nameTextField.getText();
                String paymentMethod = paymentMethodChoice.getSelectedItem();
                // Updated receipt format
                String receipt = "Name: " + name + "\n" +
                        "Items: " + items.toString() + "\n" +
                        "Payment Method: " + paymentMethod + "\n" +
                        "Total Cost: " + String.format("%.2f", total);
                receiptTextArea.setText(receipt);
            }
        });
        // Add components to frame
        frame.add(new Label("Name:"));
        frame.add(nameTextField);
        frame.add(new Label("Select Items:"));
        frame.add(shoesCheckBox);
        frame.add(pantsCheckBox);
        frame.add(shirtCheckBox);
        frame.add(new Label("Select Promo:"));
        frame.add(defaultCheckBox);
        frame.add(specialCheckBox);
        frame.add(new Label("Payment Method:"));
        frame.add(paymentMethodChoice);
        frame.add(generateButton);
        frame.add(receiptTextArea);
        // Window close handler
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}