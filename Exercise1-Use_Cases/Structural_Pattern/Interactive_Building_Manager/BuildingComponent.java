// Abstract interface for all building components (devices and composites)
public interface BuildingComponent {
    void adjustTemperature(int delta);   // Adjust temperature by delta (e.g., -2°C)
    void toggleLights(boolean on);       // Turn lights ON or OFF
    double getEnergyUsage();             // Return energy usage in kWh
    void evacuate();                     // Trigger emergency evacuation procedure
    String getName();                    // Return component name
}
