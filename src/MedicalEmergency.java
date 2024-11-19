// Class representing a specific type of emergency: Medical.
// This class extends the abstract Emergency class.
public class MedicalEmergency extends Emergency {

    // Constructor to initialize the MedicalEmergency with name and location.
    public MedicalEmergency(String name, String location) {
        // Calls the parent class (Emergency) constructor.
        super(name, location);
    }

    // Overrides the abstract handleEmergency method from the Emergency class.
    @Override
    public String handleEmergency() {
        return "Emergency Dispatch! Medical response team is on its way to assist " + getName() + 
               " at " + getLocation() + ". Please stay calm, help is on the way.";
    }

    // Overrides the abstract reminder method from the Emergency class.
    @Override
    public String reminder() {
        return "Stay calm, and try to gather information. Perform First Aid if needed.";
    }
}
