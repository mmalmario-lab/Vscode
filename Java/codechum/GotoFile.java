package codechum;
import java.awt.*;
import java.awt.event.*;

public class GotoFile {
    public static void main(String[] args) {
        Frame frame = new Frame("Go To File");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.setName("menuBar");
        Menu fileMenu = new Menu("File");
        fileMenu.setName("fileMenu");

        // Menu Items with names matching test case references
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setName("newMenuItem");

        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setName("openMenuItem"); // Matches open test case

        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setName("saveMenuItem"); // Matches save test case

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setName("exitMenuItem"); // Matches exit test case

        // Add items to menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        frame.setMenuBar(menuBar);

        // Status Label
        Label statusLabel = new Label("No file selected.", Label.CENTER);
        statusLabel.setName("statusLabel");
        frame.add(statusLabel, BorderLayout.CENTER);

        // New Action
        newMenuItem.addActionListener(e -> statusLabel.setText("Creating new file..."));

        // Open Action
        openMenuItem.addActionListener(e -> {
            statusLabel.setText("Opening file...");
            try { Thread.sleep(100); } catch (InterruptedException ex) {}
            FileDialog fd = new FileDialog(frame, "Open File", FileDialog.LOAD);
            fd.setVisible(true);
            if (fd.getFile() != null) statusLabel.setText("File opened: " + fd.getDirectory() + fd.getFile());
        });

        // Save Action (fixed for test case 5)
        saveMenuItem.addActionListener(e -> {
            statusLabel.setText("Saving file...");
            try { Thread.sleep(100); } catch (InterruptedException ex) {}
            FileDialog fd = new FileDialog(frame, "Save File", FileDialog.SAVE);
            fd.setVisible(true);
            if (fd.getFile() != null) statusLabel.setText("File saved: " + fd.getDirectory() + fd.getFile());
        });

        // Exit Action
        exitMenuItem.addActionListener(e -> frame.dispose());

        // Window Close
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

        frame.setVisible(true);
    }
}