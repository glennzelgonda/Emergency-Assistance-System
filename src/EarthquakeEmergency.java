public class EarthquakeEmergency extends Emergency {
    public EarthquakeEmergency (String name, String location){
        super(name, location);
    }

    @Override
    public String handleEmergency() {
        return "Emergency Dispatch! Earthquake response team is on its way to assist " + getName() + " at " + getLocation() + ". Please stay calm, help is on the way."; 
    }

    @Override
    public String reminder() {
        return "DROP, COVER AND HOLD! If you are indoors, remain there. Stay away from windows, glass, and heavy furniture that may fall. \nIf you are outside, move to an open space away from buildings, trees, streetlights, and utility wires. Be prepared for the aftershocks";
    }
}