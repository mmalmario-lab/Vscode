package codechum;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;


public class MultipleChoice extends Frame {
    public static void main(String[] args) {
        Frame frame = new Frame("Questionnaire");
        CheckboxGroup cbGroup = new CheckboxGroup();

        Checkbox charCheckBox = new Checkbox("char", cbGroup, false);
        charCheckBox.setName("charCheckBox");
        Checkbox booleanCheckBox = new Checkbox("boolean", cbGroup, false);
        booleanCheckBox.setName("booleanCheckBox");
        Checkbox intCheckBox = new Checkbox("int", cbGroup, false);
        intCheckBox.setName("intCheckBox");
        Checkbox stringCheckBox = new Checkbox("String", cbGroup, false);
        stringCheckBox.setName("stringCheckBox");

        Button checkButton = new Button("Check");
        checkButton.setName("checkButton");

        Label resultLabel = new Label("");
        resultLabel.setName("resultLabel");

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbGroup.getSelectedCheckbox() == stringCheckBox) {
                    resultLabel.setText("Correct!");
                } else {
                    resultLabel.setText("Incorrect!");
                }
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(charCheckBox);
        frame.add(booleanCheckBox);
        frame.add(intCheckBox);
        frame.add(stringCheckBox);
        frame.add(checkButton);
        frame.add(resultLabel);

        frame.setSize(300, 200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}