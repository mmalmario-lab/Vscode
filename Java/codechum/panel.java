package codechum;

import java.awt.*;


public class panel extends Frame{
    public static void main(String[] args) {
        
        panel frame = new panel();
        frame.setTitle("Panels");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        
        Panel mainPanel = new  Panel();
        mainPanel.setName("mainPanel");
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainPanel.setSize(350,150);
        
        
        Panel subPanelA = new  Panel();
        subPanelA.setName("subPanelA");
        subPanelA.setSize(150, 100);
        subPanelA.setBorder(new java.awt.BorderLayout().createEtchedBorder());
        
        Panel subPanelB = new  Panel();
        subPanelB.setName("subPanelB");
        subPanelB.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        subPanelB.setSize(150,100);

        frame.add(mainPanel);
        frame.add(subPanelA);
        frame.add(subPanelB);
  
        //frame.add(panel);
        frame.setVisible(true);

    }
}
