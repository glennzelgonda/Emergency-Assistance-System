// Class representing a specific type of emergency: Flood.
// This class extends the abstract Emergency class.
public class FloodEmergency extends Emergency {

    // Constructor to initialize the FloodEmergency with name and location.
    public FloodEmergency(String name, String location) {
        // Calls the parent class (Emergency) constructor.
        super(name, location);
    }

    // Overrides the abstract handleEmergency method from the Emergency class.
    @Override
    public String handleEmergency() {
        return "Emergency Dispatch! Flood response team is on its way to assist " + getName() + 
               " at " + getLocation() + ".\nPlease stay calm, help is on the way.";
    }

    // Overrides the abstract reminder method from the Emergency class.
    @Override
    public String reminder() {
        return "In case of flooding, move to higher ground and stay away from floodwaters.";
    }
}
