public class FireEmergency extends Emergency {
    public FireEmergency(String name, String location){
        super(name, location);
    }

    @Override
    public String handleEmergency(){
        return "Emergency Dispatch! Fire response team is on its way to assist " + getName() + " at " + getLocation() + ". Please stay calm, help is on the way."; 
    }

    @Override
    public String reminder() {
        return "Stay Low! Evacuate immediately";
    }
}
