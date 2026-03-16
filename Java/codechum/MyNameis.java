package codechum;

import java.awt.*;
import java.awt.event.*;


public class MyNameis {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setTitle("Text Display");
        //frame.setLayout(new FlowLayout());
        frame.setLayout(null);

        TextField tf = new TextField();
        tf.setName("nameTextField");

        Label label = new Label();
        label.setName("nameLabel");

        Button button = new Button("Display Text");
        button.setName("displayButton");

        //setbounds
        tf.setBounds(20,50, 100, 30);
        label.setBounds(125, 50, 100, 30);
        button.setBounds(100, 100, 100, 50);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String text = tf.getText();
                label.setText(text);
            }
        });

        frame.add(tf);
        frame.add(label);
        frame.add(button);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
