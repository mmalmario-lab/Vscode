package codechum;

import java.awt.*;

public class arrangingpanels extends Frame {
    public static void main(String[] args) {
        arrangingpanels frame = new arrangingpanels();
        frame.setTitle("Panels With Position");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        Panel mainPanel = new Panel();
        mainPanel.setName("mainPanel");
        mainPanel.setLayout(null);

        Panel subPanelA = new Panel();
        subPanelA.setName("subPanelA");
        subPanelA.setBounds(10, 10, 100, 100);
        subPanelA.setBackground(Color.blue);

        Panel subPanelB = new Panel();
        subPanelB.setName("subPanelB");
        subPanelB.setBounds(200, 90, 100, 100);
        subPanelB.setBackground(Color.red);

        frame.add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(subPanelA);
        mainPanel.add(subPanelB);

        frame.setVisible(true);

    }
}