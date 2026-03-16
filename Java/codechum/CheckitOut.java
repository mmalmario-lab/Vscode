package codechum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckitOut {
    public static void main(String[] args) {
        Frame frame = new Frame("CheckBoxes");
        frame.setLayout(new FlowLayout());

       
        Checkbox firstCheckBox = new Checkbox("First");
        Checkbox secondCheckBox = new Checkbox("Second");
        Checkbox thirdCheckBox = new Checkbox("Third");
        Button displaySelectedButton = new Button("Display");
        Label checkBoxLabel = new Label();
        
        firstCheckBox.setName("firstCheckBox");
        secondCheckBox.setName("secondCheckBox");
        thirdCheckBox.setName("thirdCheckBox");
        displaySelectedButton.setName("displaySelectedButton");
        checkBoxLabel.setName("checkBoxesLabel");

        displaySelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedLabels = new StringBuilder();
                if (firstCheckBox.getState()) {
                    selectedLabels.append("First, ");
                }
                if (secondCheckBox.getState()) {
                    selectedLabels.append("Second, ");
                }
                if (thirdCheckBox.getState()) {
                    selectedLabels.append("Third");
                }
                checkBoxLabel.setText(selectedLabels.toString());         
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.add(firstCheckBox);
        frame.add(secondCheckBox);
        frame.add(thirdCheckBox);
        frame.add(displaySelectedButton);
        frame.add(checkBoxLabel);
        
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }

    
}

