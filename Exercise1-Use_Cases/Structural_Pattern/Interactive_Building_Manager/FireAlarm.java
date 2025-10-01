// Leaf component representing a fire alarm
public class FireAlarm implements BuildingComponent {
    private boolean isActive = false;
    private String name;

    public FireAlarm(String name) {
        this.name = name;
    }

    @Override
    public void adjustTemperature(int delta) {
        // Not applicable
    }

    @Override
    public void toggleLights(boolean on) {
        // Not applicable
    }

    @Override
    public double getEnergyUsage() {
        return isActive ? 0.3 : 0.0;
    }

    @Override
    public void evacuate() {
        isActive = true;
        System.out.println(name + " Fire Alarm activated! Evacuate immediately!");
    }

    @Override
    public String getName() {
        return name;
    }
}
