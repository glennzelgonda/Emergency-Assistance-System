public class MedicalEmergency extends Emergency {
    public MedicalEmergency (String name, String location){
        super (name, location);
    }

    @Override
    public String handleEmergency(){
        return "Emergency Dispatch! Medical response team is on its way to assist " + getName() + " at " + getLocation() + ". Please stay calm, help is on the way."; 
    }

    @Override
    public String reminder() {
        return "Stay calm, and try to gather information. Perform First Aid if needed.";
    }
}
