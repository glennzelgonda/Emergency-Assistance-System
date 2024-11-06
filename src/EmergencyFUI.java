import java.util.Scanner;

public class EmergencyFUI {
    private final Scanner scanner;

    public EmergencyFUI() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("===== P A S P A S =====");
        System.out.println("Welcome to the Emergency Assistance System\n");

        // Get user inputs
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter your location: ");
        String location = scanner.nextLine().trim();

        System.out.println("\nSelect Emergency Type:");
        System.out.println("1. Flood");
        System.out.println("2. Fire");
        System.out.println("3. Earthquake");
        System.out.println("4. Medical");
        System.out.println("5. Crime");
        System.out.print("Enter the number corresponding to your emergency type: ");
        int emergencyChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline left by nextInt()

        System.out.print("Enter additional information (or leave blank): ");
        String additionalInfo = scanner.nextLine().trim();

        // Validate inputs
        if (name.isEmpty() || location.isEmpty()) {
            System.out.println("Please enter both your name and location to assist you.");
            return;
        }

        // Emergency type validation
        if (emergencyChoice < 1 || emergencyChoice > 5) {
            System.out.println("Please select a valid emergency type.");
            return;
        }

        // Instantiate the appropriate emergency class
        Emergency emergency = null;
        switch (emergencyChoice) {
            case 1 -> emergency = new FloodEmergency(name, location);
            case 2 -> emergency = new FireEmergency(name, location);
            case 3 -> emergency = new EarthquakeEmergency(name, location);
            case 4 -> emergency = new MedicalEmergency(name, location);
            case 5 -> emergency = new CrimeEmergency(name, location);
        }

        // Display the emergency response and tips
        if (emergency != null) {
            System.out.println("\nEmergency Response: " + emergency.handleEmergency());
            System.out.println("Estimated response time: 15 minutes. Please stay calm and await assistance.");
            if (!additionalInfo.isEmpty()) {
                System.out.println("Additional Information: " + additionalInfo);
            }
            System.out.println("Reminder: " + emergency.reminder());
        }
    }

    public static void main(String[] args) {
        EmergencyFUI fui = new EmergencyFUI();
        fui.run();
    }
}
