package codechum;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class OpentheMessage {
    public static void main(String[] args) {
        Frame frame = new Frame("File Reader");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        Button openFileDialogButton = new Button("Open");
        openFileDialogButton.setName("openFileDialogButton");

        Label fileContentLabel = new Label();
        fileContentLabel.setName("fileContentLabel");

        FileDialog fileDialog = new FileDialog(frame, "Open File", FileDialog.LOAD);
        fileDialog.setName("fileDialog");

        openFileDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileDialog.setVisible(true);
                String filePath = fileDialog.getFile();
                String directory = fileDialog.getDirectory();
                if (filePath != null) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(directory + filePath));
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }
                        reader.close();
                        fileContentLabel.setText(content.toString());
                    } catch (IOException ex) {
                        fileContentLabel.setText("Error reading file.");
                    }
                }
            }
        });

        frame.add(openFileDialogButton);
        frame.add(fileContentLabel);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
