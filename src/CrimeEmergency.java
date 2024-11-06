public class CrimeEmergency extends Emergency {
    public CrimeEmergency (String name, String location){
        super (name, location);
    }


    @Override
    public String handleEmergency(){
        return "Emergency Dispatch! Police is on its way to assist " + getName() + " at " + getLocation() + ". Please stay calm, help is on the way."; 
    }

    
    
    @Override
    public String reminder() {
        return "Stay calm, if you are in immediate danger, prioritize your safety and escape if you can do so without risk.\nTry to observe and wait for the help";
    }
}
