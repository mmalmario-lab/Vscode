package codechum;

import java.awt.*;
import java.awt.event.*;
public class February29 {
    private static Frame mainFrame;
    private static TextField yearTextField;
    private static Button checkYearButton;
    private static Dialog leapYearDialog;
    private static Dialog notLeapYearDialog;
    public static void main(String[] args) {
        mainFrame = new Frame("February 29");
        mainFrame.setSize(300, 100);
        mainFrame.setLayout(new FlowLayout());
        yearTextField = new TextField(10);
        yearTextField.setName("yearTextField");
        mainFrame.add(new Label("Enter Year:"));
        mainFrame.add(yearTextField);
        checkYearButton = new Button("Check");
        checkYearButton.setName("checkYearButton");
        checkYearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkLeapYear();
            }
        });
        mainFrame.add(checkYearButton);
        leapYearDialog = new Dialog(mainFrame, "Message", true);
        leapYearDialog.setName("leapYearDialog");
        Label leapYearLabel = new Label("Leap year");
        leapYearLabel.setName("leapYearLabel");
        leapYearDialog.setLayout(new FlowLayout());
        leapYearDialog.add(leapYearLabel);
        leapYearDialog.setSize(200, 100);
        leapYearDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                leapYearDialog.dispose();
            }
        });
        notLeapYearDialog = new Dialog(mainFrame, "Message", true);
        notLeapYearDialog.setName("notLeapYearDialog");
        Label notLeapYearLabel = new Label("Not a leap year");
        notLeapYearLabel.setName("notLeapYearLabel");
        notLeapYearDialog.setLayout(new FlowLayout());
        notLeapYearDialog.add(notLeapYearLabel);
        notLeapYearDialog.setSize(200, 100);
        notLeapYearDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                notLeapYearDialog.dispose();
            }
        });
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        mainFrame.setVisible(true);
    }
    private static void checkLeapYear() {
        try {
            int year = Integer.parseInt(yearTextField.getText());
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear) {
                leapYearDialog.setVisible(true);
            } else {
                notLeapYearDialog.setVisible(true);
            }
        } catch (NumberFormatException ex) {
            
        }
    }
}