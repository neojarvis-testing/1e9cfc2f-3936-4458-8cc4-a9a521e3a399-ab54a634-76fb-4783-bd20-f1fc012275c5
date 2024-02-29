import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TVRemoteProgram extends JFrame {
    private JLabel displayLabel;

    public TVRemoteProgram() {
        setTitle("TV Remote Program");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        displayLabel = new JLabel("Remote is ready.");

        String[] buttonLabels = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "Power", "0", "Volume"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        getContentPane().add(displayLabel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Power":
                    displayLabel.setText("TV is turned " + (displayLabel.getText().contains("ON") ? "OFF" : "ON"));
                    break;
                case "Volume":
                    displayLabel.setText("Volume adjusted.");
                    break;
                default:
                    displayLabel.setText("Button " + command + " pressed.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLat
