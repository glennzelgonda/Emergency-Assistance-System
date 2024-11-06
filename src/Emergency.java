public abstract class Emergency {
    private final String name;
    private final String location;
    

    public Emergency (String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }    

    
    public abstract String handleEmergency();
    public abstract String reminder();
    
}
