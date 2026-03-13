package codechum;

import java.awt.Frame;

public class framePosition extends Frame{
    public static void main(String[] args) {
        framePosition frame = new framePosition();

        frame.setTitle("Frame With Position");
        frame.setSize(600, 500);
        frame.setLocation(750, 300);
        frame.setVisible(true);
        
    }
}
