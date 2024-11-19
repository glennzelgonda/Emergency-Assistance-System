// Abstract class representing a general emergency.
// This is the base class for all specific types of emergencies.
public abstract class Emergency {

    // Encapsulated fields for name and location (private with getters).
    private final String name;
    private final String location;

    // Constructor to initialize the emergency with a name and location.
    public Emergency(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getter for the name of the person involved in the emergency.
    public String getName() {
        return name;
    }

    // Getter for the location of the emergency.
    public String getLocation() {
        return location;
    }

    // Abstract method to handle emergency-specific actions.
    // Must be implemented by subclasses.
    public abstract String handleEmergency();

    // Abstract method to provide emergency reminders.
    // Must be implemented by subclasses.
    public abstract String reminder();
}
