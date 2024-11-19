// Class representing a specific type of emergency: Earthquake.
// This class extends the abstract Emergency class.
public class EarthquakeEmergency extends Emergency {

    // Constructor to initialize the EarthquakeEmergency with name and location.
    public EarthquakeEmergency(String name, String location) {
        // Calls the parent class (Emergency) constructor.
        super(name, location);
    }

    // Overrides the abstract handleEmergency method from the Emergency class.
    @Override
    public String handleEmergency() {
        return "Emergency Dispatch! Earthquake response team is on its way to assist " + getName() + 
               " at " + getLocation() + ". Please stay calm, help is on the way.";
    }

    // Overrides the abstract reminder method from the Emergency class.
    @Override
    public String reminder() {
        return """
               DROP, COVER AND HOLD! If you are indoors, remain there. Stay away from windows, glass, and heavy furniture that may fall.
               If you are outside, move to an open space away from buildings, trees, streetlights, and utility wires. Be prepared for the aftershocks.""";
    }
}
