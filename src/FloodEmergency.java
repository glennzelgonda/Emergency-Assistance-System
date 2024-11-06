public class FloodEmergency extends Emergency{
    public FloodEmergency (String name, String location) {
        super(name, location);
    }

    @Override
    public String handleEmergency() {
        return "Emergency Dispatch! Flood response team is on its way to assist " + getName() + " at " + getLocation() + ".\nPlease stay calm, help is on the way";  
    }

    @Override
    public String reminder() {
        return "In case of flooding, move to higher ground and stay away from floodwaters";
    }
}
    