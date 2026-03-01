import java.awt.*;
import java.awt.event.*;

/**
 * AWT EVENT HANDLING DEMO
 * 
 * This program demonstrates ONLY the concepts from the exact text you just sent:
 *   • Event-Driven Programming
 *   • AWT Event Model (Source, Event Object, Listener)
 *   • Event Propagation / Bubbling
 *   • Event Classes: ActionEvent, MouseEvent, KeyEvent, WindowEvent
 *   • Event Listeners: ActionListener, MouseListener, KeyListener, WindowListener
 *   • Multiple listeners on one component
 *   • Event Adapters: MouseAdapter, KeyAdapter, WindowAdapter
 *   • Event properties: getSource(), getX(), getY(), getKeyCode(), getActionCommand()
 * 
 * All comments match your lesson pages exactly.
 * Pure AWT (no Swing).
 */

public class AWTEventHandlingDemo extends Frame {

    // Status label to show live event information (demonstrates event data)
    private Label statusLabel;

    public static void main(String[] args) {
        // Create and display the demo frame
        AWTEventHandlingDemo demo = new AWTEventHandlingDemo();
        demo.setVisible(true);
    }

    public AWTEventHandlingDemo() {
        setTitle("AWT Event Handling Demo - From Your Lesson");
        setSize(700, 500);
        setLocation(100, 100);
        setLayout(new BorderLayout());

        // ===================== WINDOW EVENT + WINDOWADAPTER (Page 7, Page 17) =====================
        // Event Source: the Frame
        // Uses WindowAdapter so we only override windowClosing (simplifies code)
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowEvent - Closing (getWindow() = " + e.getWindow() + ")");
                System.exit(0);
            }
        });

        // ===================== TITLE & INSTRUCTIONS =====================
        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());
        Label title = new Label("AWT Event Handling Concepts Demo", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(title);
        add(topPanel, BorderLayout.NORTH);

        // ===================== CENTER PANEL - Components with Events =====================
        Panel centerPanel = new Panel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));

        // 1. ACTIONEVENT + ACTIONLISTENER (Page 6-9, Page 11-12)
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        Button actionBtn = new Button("Click Me! (ActionEvent)");
        Label actionResult = new Label("   Button not clicked yet.");

        // Register ActionListener - implements actionPerformed()
        actionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Event properties
                System.out.println("ActionEvent - Source: " + e.getSource() +
                                   " | ActionCommand: " + e.getActionCommand());
                actionResult.setText("Button clicked! (ActionEvent handled)");
                statusLabel.setText("ActionEvent fired - " + e.getActionCommand());
            }
        });
        p1.add(actionBtn);
        p1.add(actionResult);
        centerPanel.add(p1);

        // 2. MOUSEEVENT + MOUSEADAPTER + MULTIPLE LISTENERS (Page 13-14, Page 15-16)
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        Label mouseArea = new Label("   Hover / Click me (MouseEvent)   ");
        mouseArea.setBackground(Color.LIGHT_GRAY);

        // MouseAdapter - only override needed methods (Page 15)
        mouseArea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("MouseEvent - Clicked at (" + e.getX() + ", " + e.getY() + ")");
                statusLabel.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
            }
            public void mouseEntered(MouseEvent e) {
                mouseArea.setBackground(Color.YELLOW);
                statusLabel.setText("Mouse entered component");
            }
            public void mouseExited(MouseEvent e) {
                mouseArea.setBackground(Color.LIGHT_GRAY);
                statusLabel.setText("Mouse exited component");
            }
        });

        // Multiple listeners example on same component (Page 13-14)
        // Second listener (different behavior)
        mouseArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("Second MouseListener - Button pressed");
            }
        });

        p2.add(new Label("Mouse Area:"));
        p2.add(mouseArea);
        centerPanel.add(p2);

        // 3. KEYEVENT + KEYADAPTER (Page 9-10, Page 12)
        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        Label keyLabel = new Label("Press any key while window has focus...");

        // KeyAdapter on the Frame (Page 12)
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                int keyCode = e.getKeyCode();
                System.out.println("KeyEvent - Char: " + keyChar + " | Code: " + keyCode +
                                   " | Source: " + e.getSource());
                keyLabel.setText("Key pressed: " + keyChar + " (Code: " + keyCode + ")");
                statusLabel.setText("KeyEvent - " + keyChar);
            }
        });
        setFocusable(true);   // Required to receive key events on Frame

        p3.add(keyLabel);
        centerPanel.add(p3);

        add(centerPanel, BorderLayout.CENTER);

        // ===================== STATUS BAR (shows live event details) =====================
        statusLabel = new Label("Event status will appear here...", Label.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        statusLabel.setBackground(Color.CYAN);
        add(statusLabel, BorderLayout.SOUTH);

        // Make sure the frame can receive focus for key events
        requestFocus();
    }
}
