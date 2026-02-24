
import java.awt.*;
import java.awt.event.*;

public class CheckBoxGGroupHandlingExample {
    public static void main(String[] args) {
        // Create a Frame
        Frame frame = new Frame("Check Box Group Handling Example");
        // Create a CheckboxGroup
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        // Create individual Checkboxes and associate them with the group
        Checkbox checkbox1 = new Checkbox("Option 1",
                checkboxGroup, false);
        Checkbox checkbox2 = new Checkbox("Option 2",
                checkboxGroup, false);
        Checkbox checkbox3 = new Checkbox("Option 3",
                checkboxGroup, false);
        // Add the Checkboxes to the Frame
        frame.add(checkbox1);
        frame.add(checkbox2);

        frame.add(checkbox3);
        // Add an ItemListener to the Checkboxes
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Selected option: " +
                        ((Checkbox) e.getItem()).getLabel());
            }
        };

        checkbox1.addItemListener(itemListener);
        checkbox2.addItemListener(itemListener);
        checkbox3.addItemListener(itemListener);
        // Set Frame properties
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}