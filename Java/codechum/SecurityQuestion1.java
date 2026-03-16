package codechum;

import java.awt.*;
import java.awt.event.*;

public class SecurityQuestion1 {
    public static void main(String[] args) {
        Frame frame = new Frame("My Pet");
        frame.setSize(300, 200);
        frame.setLayout(null);

        TextField textField = new TextField();
        textField.setName("petNameTextField");

        Choice choice = new Choice();
        choice.setName("petTypeChoice");

        choice.add("Dog");
        choice.add("Cat");
        choice.add("Rabbit");
        choice.add("Parrot");

        Button button = new Button("Generate");
        button.setName("generateTextButton");

        Label label = new Label();
        label.setName("displayLabel");
        
        Label petNameLabel = new Label("Pet's Name");
        Label petTypeLabel = new Label("Pet's Type");

        textField.setBounds(120, 50, 100, 20);
        petNameLabel.setBounds(50, 50, 70, 20);
        petTypeLabel.setBounds(50, 70, 70, 20);
        choice.setBounds(120, 70, 100, 20);
        button.setBounds(70, 100, 100, 20);
        label.setBounds(50, 120, 250, 20);

        button.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                String  petName = textField.getText();
                String petType = choice.getSelectedItem();
                label.setText("The pet is a "+ petType.toLowerCase() + " named "+ petName);
            }
        });


        
        frame.add(textField);
        frame.add(button);
        frame.add(choice);
        frame.add(label);
        frame.add(petNameLabel);
        frame.add(petTypeLabel);

        frame.setVisible(true);
        
    }
}
