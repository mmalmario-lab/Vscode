package codechum;

import java.awt.*;

public class labels extends Frame {
    public static void main(String[] args) {
        labels frame = new labels();
        frame.setTitle("Hello World!");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        Label helloWorldLabel = new Label("helloWorldlabel");
        helloWorldLabel.setText("Hello World! I love Java!");

        frame.add(helloWorldLabel);
        frame.setVisible(true);
    }
}
