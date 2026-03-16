package codechum;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MakingaMessage extends Frame {
    public static void main(String[] args) {
        Frame frame = new Frame("File Saver");
        Button createFileButton = new Button("Create File");
        createFileButton.setName("createFileButton");
        Label fileContentLabel = new Label("");
        fileContentLabel.setName("fileContentLabel");
        FileDialog fileDialog = new FileDialog(frame, "Save File", FileDialog.SAVE);
        fileDialog.setName("fileDialog");

        createFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileDialog.setVisible(true);
                String fileName = fileDialog.getFile();
                String directory = fileDialog.getDirectory();
                if (fileName != null && directory != null) {
                    String filePath = directory + fileName;
                    String content = "File handling";
                    try (FileWriter writer = new FileWriter(filePath)) {
                        writer.write(content);
                        fileContentLabel.setText(content);
                    } catch (IOException ex) {
                        fileContentLabel.setText("Error creating file!");
                    }
                }
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(createFileButton);
        frame.add(fileContentLabel);

        frame.setSize(350, 150);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}