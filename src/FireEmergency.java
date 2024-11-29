// Class representing a specific type of emergency: Fire.
// This class extends the abstract Emergency class.
public class FireEmergency extends Emergency {

    // Constructor to initialize the FireEmergency with name and location.
    public FireEmergency(String name, String location) {
        // Calls the parent class (Emergency) constructor.
        super(name, location);
    }

    // Overrides the abstract handleEmergency method from the Emergency class.
    @Override
    public String handleEmergency() {
        return "Emergency Dispatch! Firefighters is on its way to assist " + getName() + 
               " at " + getLocation() + ". Please stay calm, help is on the way.";
    }

    // Overrides the abstract reminder method from the Emergency class.
    @Override
    public String reminder() {
        return "Stay Low! Evacuate immediately.";
    }
}
