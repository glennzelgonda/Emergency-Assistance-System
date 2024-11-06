import java.awt.*;
import javax.swing.*;

public class EmergencyGUI extends JFrame {
    private final JTextField nameField;
    private final JTextField locationField;
    private final JComboBox<String> emergencyTypeCombo;
    private final JTextArea additionalInfoArea;
    private final JTextArea resultArea;
    private final JTextArea reminderArea;

    public EmergencyGUI() {
        
        setTitle("PASPAS: Emergency Assistance System");
        setSize(750, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JLabel titleLabel = new JLabel("===== P A S P A S =====", JLabel.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        
        nameField = new JTextField(10); 
        locationField = new JTextField(10); 

        emergencyTypeCombo = new JComboBox<>();
        emergencyTypeCombo.addItem("Select Emergency Type");
        emergencyTypeCombo.addItem("Flood");
        emergencyTypeCombo.addItem("Fire");
        emergencyTypeCombo.addItem("Earthquake");
        emergencyTypeCombo.addItem("Medical");
        emergencyTypeCombo.addItem("Crime");

        additionalInfoArea = new JTextArea(2, 15);

        JButton submitButton = new JButton("Send Request");
        JButton clearButton = new JButton("Clear");

        resultArea = new JTextArea(3, 30);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Response"));

        reminderArea = new JTextArea(3, 30);
        reminderArea.setEditable(false);
        reminderArea.setBorder(BorderFactory.createTitledBorder("Emergency Reminder"));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Location:"));
        inputPanel.add(locationField);
        inputPanel.add(new JLabel("Emergency Type:"));
        inputPanel.add(emergencyTypeCombo);
        inputPanel.add(new JLabel("Additional Information:"));
        inputPanel.add(new JScrollPane(additionalInfoArea));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        JPanel responsePanel = new JPanel(new GridLayout(2, 1));
        responsePanel.add(resultArea);
        responsePanel.add(reminderArea);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(responsePanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        submitButton.addActionListener(e -> handleEmergency());
        clearButton.addActionListener(e -> clearFields());
    }

    private void handleEmergency() {
        String name = nameField.getText().trim();
        String location = locationField.getText().trim();
        String emergencyType = (String) emergencyTypeCombo.getSelectedItem();
        String additionalInfo = additionalInfoArea.getText().trim();
        Emergency emergency = null;

        if (name.isEmpty() && location.isEmpty()) {
            resultArea.setText("Please enter your name and location to assist you.");
            reminderArea.setText("");
            return;
        } else if (name.isEmpty()) {
            resultArea.setText("Please enter your name to assist you.");
            reminderArea.setText("");
            return;
        } else if (location.isEmpty()) {
            resultArea.setText("Please enter your location to assist you.");
            reminderArea.setText("");
            return;
        }

        if (emergencyType.equals("Select Emergency Type")) {
            resultArea.setText("Please select a valid emergency type.");
            reminderArea.setText("");
            return;
        }

        switch (emergencyType) {
            case "Flood" -> emergency = new FloodEmergency(name, location);
            case "Fire" -> emergency = new FireEmergency(name, location);
            case "Earthquake" -> emergency = new EarthquakeEmergency(name, location);
            case "Medical" -> emergency = new MedicalEmergency(name, location);
            case "Crime" -> emergency = new CrimeEmergency(name, location);
        }

        if (emergency != null) {
            resultArea.setText(emergency.handleEmergency() + "\nEstimated response time: 15 minutes. Please stay calm and await assistance.\nAdditional Info: " + additionalInfo);
            reminderArea.setText( emergency.reminder());
        }
    }

    private void clearFields() {
        nameField.setText("");
        locationField.setText("");
        emergencyTypeCombo.setSelectedIndex(0);
        additionalInfoArea.setText("");
        resultArea.setText("");
        reminderArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmergencyGUI gui = new EmergencyGUI();
            gui.setVisible(true);
        });
    }
}
