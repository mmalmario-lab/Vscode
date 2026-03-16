package codechum;
import java.awt.*;
import java.awt.event.*;

public class MenuinaMenu {
    public static void main(String[] args) {
        // Create main frame
        Frame frame = new Frame("Menu In A Menu");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // 1. MenuBar setup
        MenuBar menuBar = new MenuBar();
        menuBar.setName("menuBar");
        frame.setMenuBar(menuBar);

        // 2. File Menu and its items
        Menu fileMenu = new Menu("File");
        fileMenu.setName("fileMenu");
        menuBar.add(fileMenu);

        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setName("newMenuItem");
        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setName("openMenuItem");
        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setName("saveMenuItem");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setName("exitMenuItem");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        // 3. Format Menu with Font Color sub-menu
        Menu formatMenu = new Menu("Format");
        formatMenu.setName("formatMenu");
        menuBar.add(formatMenu);

        Menu fontColorMenu = new Menu("Font Color");
        fontColorMenu.setName("fontColorMenu");
        formatMenu.add(fontColorMenu);

        MenuItem redColorMenuItem = new MenuItem("Red");
        redColorMenuItem.setName("redColorMenuItem");
        MenuItem greenColorMenuItem = new MenuItem("Green");
        greenColorMenuItem.setName("greenColorMenuItem");
        MenuItem blueColorMenuItem = new MenuItem("Blue");
        blueColorMenuItem.setName("blueColorMenuItem");

        fontColorMenu.add(redColorMenuItem);
        fontColorMenu.add(greenColorMenuItem);
        fontColorMenu.add(blueColorMenuItem);

        // 4. Status Label setup
        Label statusLabel = new Label("Ready.", Label.CENTER);
        statusLabel.setName("statusLabel");
        // Set initial font size for better visibility
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(statusLabel, BorderLayout.CENTER);

        // 5. Action Listeners for File Menu items
        newMenuItem.addActionListener(e -> statusLabel.setText("Creating new file..."));
        openMenuItem.addActionListener(e -> statusLabel.setText("Opening file..."));
        saveMenuItem.addActionListener(e -> statusLabel.setText("Saving file..."));
        exitMenuItem.addActionListener(e -> frame.dispose());

        // 6. Action Listeners for Font Color sub-menu items
        redColorMenuItem.addActionListener(e -> statusLabel.setForeground(Color.RED));
        greenColorMenuItem.addActionListener(e -> statusLabel.setForeground(Color.GREEN));
        blueColorMenuItem.addActionListener(e -> statusLabel.setForeground(Color.BLUE));

        // 7. Window close handler
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}