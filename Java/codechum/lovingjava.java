package codechum;

import java.awt.*;

public class lovingjava extends Frame{
    public static void main(String[] args) {
        lovingjava frame = new lovingjava();
    
        frame.setTitle("My First App!");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        Label label1 = new Label();
        label1.setName("label1");
        label1.setText("Hello World!");
        
        Label label2 = new Label();
        label2.setName("label2");
        label2.setText("I love programming");


        Label label3 = new Label();
        label3.setName("label3");
        label3.setText("I love CodeChum");

        Label label4 = new Label();
        label4.setName("label4");
        label4.setText("I love Java");

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

        frame.setVisible(true);
    }
}
