// Class representing a specific type of emergency: Crime.
// This class extends the abstract Emergency class.
public class CrimeEmergency extends Emergency {

    // Constructor to initialize the CrimeEmergency with name and location.
    public CrimeEmergency(String name, String location) {
        // Calls the parent class (Emergency) constructor.
        super(name, location);
    }

    // Overrides the abstract handleEmergency method from the Emergency class.
    @Override
    public String handleEmergency() {
        return "Emergency Dispatch! Police is on its way to assist " + getName() + 
               " at " + getLocation() + ". Please stay calm, help is on the way.";
    }

    // Overrides the abstract reminder method from the Emergency class.
    @Override
    public String reminder() {
        return """
               Stay calm. If you are in immediate danger, prioritize your safety and escape if you can do so without risk.
               Try to observe and wait for the help.""";
    }
}
