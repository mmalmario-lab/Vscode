package codechum;

import java.awt.*;

public class Panels extends Frame {

    public static void main(String[] args) {

        Panels frame = new Panels();
        frame.setTitle("Panels");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        Panel mainPanel = new Panel();
        mainPanel.setName("mainPanel");
        mainPanel.setLayout(new FlowLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        Panel subPanelA = new Panel();
        subPanelA.setName("subPanelA");
        subPanelA.setPreferredSize(new Dimension(150, 150));
        subPanelA.setBackground(Color.blue);
        mainPanel.add(subPanelA);

        Panel subPanelB = new Panel();
        subPanelB.setName("subPanelB");
        subPanelB.setPreferredSize(new Dimension(150, 150));
        subPanelB.setBackground(Color.red);
        mainPanel.add(subPanelB);

        frame.setVisible(true);
    }
}
