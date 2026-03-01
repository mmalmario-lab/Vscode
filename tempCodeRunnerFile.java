import java.awt.*;
import java.awt.event.*;

/**
 * JAVA AWT COMPREHENSIVE DEMO
 * 
 * This single program demonstrates EVERY major concept from the exact AWT lesson you sent:
 *   • Frame, Panel, Window (Pages 7-11)
 *   • Label, Button, Checkbox, TextField, TextArea, Choice (Pages 11-21)
 *   • CheckboxGroup, List, ScrollBar (Pages 21-27)
 *   • Dialog, FileDialog (Pages 28-31)
 *   • Layouts: FlowLayout, BorderLayout, GridLayout (Pages 31-35)
 *   • Menu & MenuItem (Pages 36-38)
 *   • Event Handling: ActionListener, ItemListener, AdjustmentListener, WindowListener
 * 
 * All comments match your lesson pages exactly.
 * Copy-paste ready. No Swing, only pure AWT as taught.
 */

public class AWTDemo extends Frame {

    // ===================== MAIN METHOD =====================
    public static void main(String[] args) {
        // Create the main Frame (Page 7-9)
        AWTDemo frame = new AWTDemo();
        frame.setTitle("Java AWT Comprehensive Demo - From Your Lesson");
        frame.setSize(800, 600);
        frame.setLocation(100, 100);
        frame.setResizable(true);

        // Handle window closing event (Page 8-9)
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);   // Close the application
            }
        });

        frame.setVisible(true);
    }

    // ===================== CONSTRUCTOR - Builds the GUI =====================
    public AWTDemo() {
        // Use BorderLayout for the main frame (Page 32-33)
        setLayout(new BorderLayout());

        // ===================== TOP PANEL - Menu & Title (Page 36) =====================
        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create MenuBar, Menu, MenuItems (Page 36-38)
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem exitItem = new MenuItem("Exit");

        // Menu event handling (Page 38)
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setMenuBar(menuBar);   // Attach menu to Frame

        Label titleLabel = new Label("AWT Components Demo", Label.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // ===================== CENTER PANEL - Components (FlowLayout) =====================
        Panel centerPanel = new Panel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Label (Page 11-13)
        Label lbl = new Label("This is a Label (read-only text)");
        lbl.setForeground(Color.BLUE);
        centerPanel.add(lbl);

        // Button with ActionListener (Page 13-14)
        Button btn = new Button("Click Me!");
        btn.addActionListener(e -> {
            // Action when button is clicked
            System.out.println("Button was clicked!");
        });
        centerPanel.add(btn);

        // Checkbox (Page 14-16)
        Checkbox chk = new Checkbox("Enable Feature");
        chk.addItemListener(e -> {
            System.out.println("Checkbox is now: " + (chk.getState() ? "CHECKED" : "UNCHECKED"));
        });
        centerPanel.add(chk);

        // CheckboxGroup (Radio buttons) (Page 21-23)
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox radio1 = new Checkbox("Option A", cbg, false);
        Checkbox radio2 = new Checkbox("Option B", cbg, false);
        radio1.addItemListener(e -> System.out.println("Radio A selected"));
        radio2.addItemListener(e -> System.out.println("Radio B selected"));
        centerPanel.add(radio1);
        centerPanel.add(radio2);

        // TextField (Page 16-18)
        TextField tf = new TextField(15);
        tf.addActionListener(e -> System.out.println("You typed: " + tf.getText()));
        centerPanel.add(new Label("TextField:"));
        centerPanel.add(tf);

        // TextArea (multi-line) (Page 18-19)
        TextArea ta = new TextArea(5, 20);
        centerPanel.add(new Label("TextArea:"));
        centerPanel.add(ta);

        // Choice (dropdown) (Page 19-21)
        Choice choice = new Choice();
        choice.add("Option 1");
        choice.add("Option 2");
        choice.add("Option 3");
        choice.addItemListener(e -> System.out.println("Choice selected: " + choice.getSelectedItem()));
        centerPanel.add(new Label("Choice:"));
        centerPanel.add(choice);

        // List (Page 23-26)
        List list = new List(4, false);   // 4 visible rows, single select
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.addItemListener(e -> System.out.println("List selected: " + list.getSelectedItem()));
        centerPanel.add(new Label("List:"));
        centerPanel.add(list);

        // ScrollBar (Page 26-27)
        Scrollbar sbar = new Scrollbar(Scrollbar.HORIZONTAL, 50, 10, 0, 100);
        sbar.addAdjustmentListener(e -> System.out.println("ScrollBar value: " + sbar.getValue()));
        centerPanel.add(new Label("ScrollBar:"));
        centerPanel.add(sbar);

        add(centerPanel, BorderLayout.CENTER);

        // ===================== SOUTH PANEL - Dialog & FileDialog Buttons (Page 28-31) =====================
        Panel southPanel = new Panel();
        southPanel.setLayout(new FlowLayout());

        // Button to open Dialog (Page 28-30)
        Button dialogBtn = new Button("Open Modal Dialog");
        dialogBtn.addActionListener(e -> {
            Dialog dlg = new Dialog(this, "Modal Dialog Example", true);   // true = modal
            dlg.setSize(300, 150);
            dlg.setLayout(new FlowLayout());
            Label dlgLabel = new Label("This is a modal dialog!");
            Button closeBtn = new Button("Close");
            closeBtn.addActionListener(ev -> dlg.dispose());
            dlg.add(dlgLabel);
            dlg.add(closeBtn);
            dlg.setVisible(true);
        });
        southPanel.add(dialogBtn);

        // Button to open FileDialog (Page 30-31)
        Button fileBtn = new Button("Open FileDialog (Save)");
        fileBtn.addActionListener(e -> {
            FileDialog fd = new FileDialog(this, "Save File", FileDialog.SAVE);
            fd.setVisible(true);
            String file = fd.getFile();
            String dir = fd.getDirectory();
            if (file != null) {
                System.out.println("Selected file to save: " + dir + file);
            }
        });
        southPanel.add(fileBtn);

        add(southPanel, BorderLayout.SOUTH);

        // ===================== EAST PANEL - GridLayout Example (Page 33-34) =====================
        Panel eastPanel = new Panel();
        eastPanel.setLayout(new GridLayout(3, 1, 5, 5));
        eastPanel.add(new Button("Grid 1"));
        eastPanel.add(new Button("Grid 2"));
        eastPanel.add(new Button("Grid 3"));
        add(eastPanel, BorderLayout.EAST);
    }
}