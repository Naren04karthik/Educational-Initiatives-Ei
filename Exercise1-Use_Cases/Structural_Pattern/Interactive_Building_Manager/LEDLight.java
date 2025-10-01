// Leaf component representing an LED light
public class LEDLight implements BuildingComponent {
    private boolean isOn = false;
    private double brightness = 100.0; // %
    private double energyUsage = 0.2;  // kWh
    private String name;

    public LEDLight(String name) {
        this.name = name;
    }

    @Override
    public void adjustTemperature(int delta) {
        // Lights do not adjust temperature
    }

    @Override
    public void toggleLights(boolean on) {
        isOn = on;
        brightness = on ? 70.0 : 0.0;
        System.out.println(name + " LED Light " + (on ? "dimmed to 70%" : "turned off"));
    }

    @Override
    public double getEnergyUsage() {
        return isOn ? energyUsage : 0.0;
    }

    @Override
    public void evacuate() {
        isOn = true;
        brightness = 100.0;
        System.out.println(name + " Emergency lights ON at 100% brightness!");
    }

    @Override
    public String getName() {
        return name;
    }
}
