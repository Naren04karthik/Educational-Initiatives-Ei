// Leaf component representing a security camera
public class SecurityCamera implements BuildingComponent {
    private boolean motionMode = false;
    private double energyUsage = 0.5;
    private String name;

    public SecurityCamera(String name) {
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
        return energyUsage;
    }

    @Override
    public void evacuate() {
        System.out.println(name + " Camera continues monitoring evacuation.");
    }

    public void enableMotionMode() {
        motionMode = true;
        System.out.println(name + " Camera switched to motion-activated recording.");
    }

    @Override
    public String getName() {
        return name;
    }
}
