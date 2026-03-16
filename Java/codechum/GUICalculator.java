package codechum;

import java.awt.*;
import java.awt.event.*;

public class GUICalculator {
    public static void main(String[] args) {
        Frame frame = new Frame("Simple Calculator");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        TextField num1TextField = new TextField();
        num1TextField.setName("num1TextField");

        TextField num2TextField = new TextField();
        num2TextField.setName("num2TextField");

        Choice operationsChoice = new Choice();
        operationsChoice.setName("operationsChoice");

        operationsChoice.add("+");
        operationsChoice.add("-");
        operationsChoice.add("*");
        operationsChoice.add("/");

        Button computeButton = new Button("Compute Result");
        computeButton.setName("computeButton");

        Label resultLabel = new Label();
        resultLabel.setName("resultLabel");

       // Label num1Label = new Label("Number 1");
       // Label num2Label = new Label("Number 2");
        //Label resultDisplayLabel = new Label("Result");

       // num1TextField.setBounds(30, 50, 50, 30);
        //num2TextField.setBounds(130, 50, 50, 30);
        //operationChoice.setBounds(80, 50, 50, 30);
        //completeButton.setBounds(80, 200, 50, 50);
        //resultLabel.setBounds(0, 0, 0, 0);


        

        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    int num1 = Integer.parseInt(num1TextField.getText());
                    int num2 = Integer.parseInt(num2TextField.getText());
                    String operator = operationsChoice.getSelectedItem();
                    int result = 0;

                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                                break;
                            } else {
                                resultLabel.setText("Error: Division by 0");
                                return;
                            }

                    }
                    resultLabel.setText("" + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error; Invalid Input");
                }
            }
        
        });

        frame.add(num1TextField);
        frame.add(num2TextField);
        frame.add(operationsChoice);
        frame.add(computeButton);
        frame.add(resultLabel);
        //frame.add(num1Label);
        //frame.add(num2Label);
        //frame.add(resultDisplayLabel);

        frame.setVisible(true);

    }
}
