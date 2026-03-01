import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

/**
 * AWT GRAPHICS COMPREHENSIVE DEMO
 * 
 * This single program demonstrates EVERY concept from the exact lesson you
 * sent:
 * • Java AWT Graphics Class (Pages 5-8)
 * • Java AWT Color Class (Pages 9-12)
 * • Java AWT Fonts (Pages 12-16)
 * • Java AWT Canvas (Pages 16-20)
 * • Java AWT Image (Pages 20-24)
 * • Java AWT Drawing Shapes (Pages 25-28)
 * 
 * All comments match your lesson pages exactly.
 * Pure AWT – no Swing.
 * Self-contained (no external image file needed – we create one with
 * BufferedImage).
 */

public class AWTGraphicsDemo extends Frame {

    public static void main(String[] args) {
        AWTGraphicsDemo frame = new AWTGraphicsDemo();
        frame.setVisible(true);
    }

    public AWTGraphicsDemo() {
        setTitle("AWT Graphics, Color, Font, Canvas, Image & Shapes Demo");
        setSize(950, 650);
        setLocation(50, 50);
        setResizable(false);

        // Handle window closing (Page 8 example)
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Add our custom Canvas that does all the drawing
        CustomGraphicsCanvas canvas = new CustomGraphicsCanvas();
        add(canvas);
    }

    // ===================== CUSTOM CANVAS CLASS (Page 16-20) =====================
    // We extend Canvas and override paint(Graphics g) – exactly as taught
    class CustomGraphicsCanvas extends Canvas {

        private Image demoImage; // for Image section (Page 20-24)

        public CustomGraphicsCanvas() {
            setBackground(Color.WHITE);

            // Create a BufferedImage programmatically (Page 23-24)
            // So no external file is needed
            BufferedImage bufImg = new BufferedImage(150, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufImg.createGraphics();
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, 150, 100);
            g2.setColor(Color.BLUE);
            g2.drawRect(10, 10, 130, 80);
            g2.setColor(Color.RED);
            g2.drawString("Buffered Image", 20, 55);
            g2.dispose();
            demoImage = bufImg;
        }

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g; // Cast to Graphics2D for advanced features (Page 7, 15)

            // ===================== 1. GRAPHICS CLASS BASICS (Pages 5-8)
            // =====================
            g.setColor(Color.BLACK);
            g.drawString("Graphics Class Demo (Pages 5-8)", 30, 30);

            // Drawing Shapes and Lines (Page 5-6)
            g.drawLine(50, 50, 150, 150); // Line
            g.drawRect(200, 50, 120, 80); // Rectangle
            g.drawOval(350, 50, 100, 80); // Oval
            g.drawArc(480, 50, 100, 100, 30, 120); // Arc
            int[] xPoly = { 620, 680, 740 };
            int[] yPoly = { 90, 40, 90 };
            g.drawPolygon(xPoly, yPoly, 3); // Polygon (Triangle)

            // Filling Shapes with Colors (Page 6)
            g.setColor(Color.RED);
            g.fillRect(50, 180, 120, 80);

            g.setColor(Color.GREEN);
            g.fillOval(200, 180, 100, 80);

            g.setColor(Color.BLUE);
            g.fillArc(350, 180, 100, 100, 30, 120);

            g.setColor(Color.YELLOW);
            g.fillPolygon(xPoly, yPoly, 3); // xPoly and yPoly reused

            // ===================== 2. COLOR CLASS (Pages 9-12) =====================
            g.setColor(Color.BLACK);
            g.drawString("Color Class Demo (Pages 9-12)", 30, 320);

            // RGB Colors
            g.setColor(new Color(255, 0, 0)); // Pure Red
            g.fillRect(50, 340, 60, 60);

            g.setColor(new Color(0, 255, 0)); // Pure Green
            g.fillRect(130, 340, 60, 60);

            g.setColor(new Color(0, 0, 255)); // Pure Blue
            g.fillRect(210, 340, 60, 60);

            // Predefined Colors
            g.setColor(Color.ORANGE);
            g.fillRect(290, 340, 60, 60);

            g.setColor(Color.MAGENTA);
            g.fillRect(370, 340, 60, 60);

            g.setColor(Color.CYAN);
            g.fillRect(450, 340, 60, 60);

            // System Color (Page 11)
            g.setColor(SystemColor.windowText);
            g.drawString("System Text Color", 530, 380);

            // ===================== 3. FONTS (Pages 12-16) =====================
            g.setColor(Color.BLACK);
            g.drawString("Fonts Demo (Pages 12-16)", 30, 460);

            // Different fonts and styles
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Plain Arial 18", 50, 500);

            g.setFont(new Font("Times New Roman", Font.BOLD, 20));
            g.drawString("Bold Times New Roman 20", 50, 530);

            g.setFont(new Font("Courier New", Font.ITALIC, 22));
            g.drawString("Italic Courier 22", 50, 560);

            g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
            g.drawString("Bold+Italic Arial 24", 50, 590);

            // Anti-aliasing example (Page 15)
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(new Font("Arial", Font.PLAIN, 26));
            g.drawString("Anti-Aliased Text!", 480, 550);

            // ===================== 4. IMAGE & BUFFEREDIMAGE (Pages 20-24)
            // =====================
            g.setColor(Color.BLACK);
            g.drawString("Image & BufferedImage (Pages 20-24)", 30, 620);

            // Draw the programmatically created BufferedImage
            g.drawImage(demoImage, 480, 420, this);

            // ===================== 5. DRAWING SHAPES ADVANCED (Pages 25-28)
            // =====================
            g.setColor(Color.BLACK);
            g.drawString("Advanced Shapes & Transformations (Pages 25-28)", 30, 670);

            // Path2D example (Page 26)
            g2d.setColor(Color.PINK);
            Path2D path = new Path2D.Double();
            path.moveTo(650, 420);
            path.lineTo(720, 380);
            path.lineTo(790, 450);
            path.closePath();
            g2d.fill(path);

            // Transformations (Page 7-8)
            g2d.setColor(Color.DARK_GRAY);
            g2d.translate(700, 500); // Move origin
            g2d.rotate(Math.toRadians(45)); // Rotate 45 degrees
            g2d.fillRect(0, 0, 80, 40); // Draw rotated rectangle
        }
    }
}