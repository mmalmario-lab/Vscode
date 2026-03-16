package codechum;

import java.awt.*;
import java.awt.event.*;

public class EnablemeEnablemeNot {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setTitle("Text Field Enable/Disable");
        frame.setLayout(null);

        TextField tf = new TextField();
        tf.setName("textField");

        Button enableButton = new Button("Enable");
        enableButton.setName("enableButton");

        Button disableButton = new Button("Disable");
        disableButton.setName("disableButton");

        //setbounds
        tf.setBounds(100,50, 100, 30);
        enableButton.setBounds(50, 100, 100, 50);
        disableButton.setBounds(150, 100, 100, 50);

        enableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                tf.setEnabled(true);
                
            }
        });
        
        disableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                tf.setEnabled(false);
                
            }
        });

        frame.add(tf);
        frame.add(enableButton);
        frame.add(disableButton);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
