package codechum;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

public class FindtheSpy {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        String[] buttonLabels = { "2156", "2256", "124", "2014", "1214", "562", "11", "22", "213", "54136" };
        String[] buttonNames = { "button1", "button2", "button3", "button4", "button5", "button6", "button7", "button8",
                "button9", "button10" };

        for (int i = 0; i < buttonLabels.length; i++) {
            Button button = new Button(buttonLabels[i]);
            button.setName(buttonNames[i]);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Button srcbutton = (Button) e.getSource();
                    String id = srcbutton.getLabel();

                    boolean spy = isSpy(id);
                    if (spy) {
                        showDialog(frame, true);
                    }
                }
            });
            frame.add(button);
        }

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static void showDialog(Frame frame, boolean isSpy) {
        String message = isSpy ? "Spy found!" : "Not a Spy";
        Dialog noticeDialog = new Dialog(frame, "Message", true);
        noticeDialog.setName("noticeDialog");
        Label label = new Label(message);
        label.setName(isSpy ? "spyLabel" : "noticeLabel");
        noticeDialog.setLayout(new FlowLayout());
        noticeDialog.add(label);
        noticeDialog.setSize(200, 100);
        noticeDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                noticeDialog.dispose();
            }
        });
        noticeDialog.setVisible(true);
    }

    public static boolean isSpy(String id) {
        int sum = 0;
        BigInteger product = BigInteger.valueOf(1);
        for (char c : id.toCharArray()) {
            int digit = Character.getNumericValue(c);
            sum += digit;
            product = product.multiply(BigInteger.valueOf(digit));
        }
        return sum == product.intValue() && sum != 0;
    }
}