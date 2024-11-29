import java.awt.*;
import javax.swing.*;

public class EmergencyGUI extends JFrame {
    // UI Components
    private final JTextField nameField;
    private final JTextField locationField;
    private final JComboBox<String> emergencyTypeCombo;
    private final JTextArea additionalInfoArea;
    private final JTextArea resultArea;
    private final JTextArea reminderArea;

    public EmergencyGUI() {
        // Frame settings
        setTitle("PASPAS: Emergency Assistance System");
        setSize(780, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set window icon
        ImageIcon icon = new ImageIcon("C:\\Users\\OOP PROJ\\Emergency Assistance System\\images\\logo.png"); // Replace with your icon file's path
        setIconImage(icon.getImage());

        getContentPane().setBackground(new Color(169, 214, 229)); 

        // Title Label
        JLabel titleLabel = new JLabel("P A S P A S", JLabel.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Input fields and combo box
        nameField = new JTextField(10);
        nameField.setBackground(Color.WHITE);

        locationField = new JTextField(10);
        locationField.setBackground(Color.WHITE);
        

        emergencyTypeCombo = new JComboBox<>();
        emergencyTypeCombo.addItem("Select Emergency Type");
        emergencyTypeCombo.addItem("Flood");
        emergencyTypeCombo.addItem("Fire");
        emergencyTypeCombo.addItem("Earthquake");
        emergencyTypeCombo.addItem("Medical");
        emergencyTypeCombo.addItem("Crime");

        // Text areas
        additionalInfoArea = new JTextArea(2, 15);
        additionalInfoArea.setBackground(Color.WHITE); 

        resultArea = new JTextArea(3, 30);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Response"));
        resultArea.setBackground(Color.WHITE); 

        reminderArea = new JTextArea(3, 30);
        reminderArea.setEditable(false);
        reminderArea.setBorder(BorderFactory.createTitledBorder("Emergency Reminder"));
        reminderArea.setBackground(Color.WHITE); 

        // Buttons
        JButton submitButton = new JButton("Send Request");
        JButton clearButton = new JButton("Clear");

        // Input section
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBackground(new Color(169, 214, 229));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Location:"));
        inputPanel.add(locationField);
        inputPanel.add(new JLabel("Emergency Type:"));
        inputPanel.add(emergencyTypeCombo);
        inputPanel.add(new JLabel("Additional Information:"));
        inputPanel.add(new JScrollPane(additionalInfoArea));

        // Button section
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(169, 214, 229));
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // Response section
        JPanel responsePanel = new JPanel(new GridLayout(2, 1));
        responsePanel.setBackground(new Color(169, 214, 229));
        responsePanel.add(resultArea);
        responsePanel.add(reminderArea);

        // Main layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(responsePanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Button actions
        submitButton.addActionListener(e -> handleEmergency());
        clearButton.addActionListener(e -> clearFields());
    }

    private void handleEmergency() {
        String name = nameField.getText().trim();
        String location = locationField.getText().trim();
        String emergencyType = (String) emergencyTypeCombo.getSelectedItem();
        String additionalInfo = additionalInfoArea.getText().trim();
        Emergency emergency = null;
    
        // Validate inputs separately
        if (name.isEmpty() && location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name and location to assist you.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name to assist you.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your location to assist you.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        if (emergencyType.equals("Select Emergency Type")) {
            JOptionPane.showMessageDialog(this, "Please select a valid emergency type.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Instantiate the appropriate emergency class
        switch (emergencyType) {
            case "Flood" -> emergency = new FloodEmergency(name, location);
            case "Fire" -> emergency = new FireEmergency(name, location);
            case "Earthquake" -> emergency = new EarthquakeEmergency(name, location);
            case "Medical" -> emergency = new MedicalEmergency(name, location);
            case "Crime" -> emergency = new CrimeEmergency(name, location);
        }
    
        // Confirm details
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are these details correct?\n\nName: " + name + "\nLocation: " + location +
                        "\nEmergency Type: " + emergencyType + "\nAdditional Info: " + additionalInfo,
                "Confirm Details", JOptionPane.YES_NO_OPTION);
    
        if (confirm == JOptionPane.YES_OPTION) {
            displayProcessingDialog(emergency, additionalInfo);
        }
    }
    

    private void displayProcessingDialog(Emergency emergency, String additionalInfo) {
        JDialog dialog = new JDialog(this, "Processing", true);
        JLabel label = new JLabel("Confirming details...", JLabel.CENTER);
        dialog.add(label, BorderLayout.CENTER);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);

        Timer timer1 = new Timer(2000, e -> {
            label.setText("Tracking location...");
            ((Timer) e.getSource()).stop();

            Timer timer2 = new Timer(2000, e2 -> {
                dialog.dispose();
                showResponse(emergency, additionalInfo);
                ((Timer) e2.getSource()).stop();
            });
            timer2.setRepeats(false);
            timer2.start();
        });
        timer1.setRepeats(false);
        timer1.start();

        dialog.setVisible(true);
    }

    private void showResponse(Emergency emergency, String additionalInfo) {
        if (emergency != null) {
            resultArea.setText(emergency.handleEmergency() + "\nEstimated response time: 15 minutes. Please stay calm and await assistance.\nAdditional Info: " + additionalInfo);
            reminderArea.setText(emergency.reminder());
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
    