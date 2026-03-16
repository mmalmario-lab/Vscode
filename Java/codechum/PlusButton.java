package codechum;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusButton extends Frame {
    public static void main(String[] args) {
        PlusButton frame = new PlusButton();
        frame.setTitle("Conter");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
       
        Label counterLabel = new Label();
        counterLabel.setText("0");
        counterLabel.setName("counterLabel");
        
        Button incrementButton = new Button("Click");
        incrementButton.setName("incrementButton");

        incrementButton.addActionListener(new ActionListener() {
            int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                counterLabel.setText(String.valueOf(count));
            }
        });


        
        frame.add(counterLabel);
        frame.add(incrementButton);
        
        frame.setVisible(true);
    }
}
