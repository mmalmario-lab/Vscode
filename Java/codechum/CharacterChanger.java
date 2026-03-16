package codechum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CharacterChanger extends Frame {
    public static void main(String[] args) {

        CharacterChanger frame = new CharacterChanger();
        frame.setTitle("Case Swicth");
        frame.setSize(500, 300);
        frame.setLayout(new FlowLayout());

        Label textLabel = new Label();
        textLabel.setText("I love programming!");
        textLabel.setName("textLabel");

        Button switchVowelCaseButton = new Button("Vowels");
        switchVowelCaseButton.setName("switchVowelCaseButton");
        switchVowelCaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textLabel.getText();
                StringBuilder result = new StringBuilder();
                for (char c : text.toCharArray()) {
                    if (isVowels(c)) {
                        result.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
                    } else {
                        result.append(c);
                    }
                }
                textLabel.setText(result.toString());
            }

        });

        Button switchConsonantCaseButton = new Button("Consonant");
        switchConsonantCaseButton.setName("switchConsonantCaseButton");
        switchConsonantCaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textLabel.getText();
                StringBuilder result = new StringBuilder();
                for (char c : text.toCharArray()) {
                    if (isConsonant(c))
                        result.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
                    else
                        result.append(c);
                }
                textLabel.setText(result.toString());
            }

        });

        Button switchAllCaseButton = new Button("All");
        switchAllCaseButton.setName("switchAllCaseButton");
        switchAllCaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textLabel.getText();
                StringBuilder result = new StringBuilder();
                for (char c : text.toCharArray()) {
                    result.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
                }
                textLabel.setText(result.toString());
            }

        });

        frame.add(textLabel);
        frame.add(switchVowelCaseButton);
        frame.add(switchConsonantCaseButton);
        frame.add(switchAllCaseButton);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

    }

    private static boolean isVowels(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowels(c);
    }

}
