// Concrete Component: Basic vitals monitor
import java.util.Random;

public class BasicVitals implements PatientMonitor {
    protected String patientName;
    protected int temperature;        // in °C
    protected int bloodPressure;      // systolic

    public BasicVitals(String patientName) {
        this.patientName = patientName;
        Random rand = new Random();
        this.temperature = 36 + rand.nextInt(4); // 36-39°C
        this.bloodPressure = 100 + rand.nextInt(40); // 100-139
    }

    @Override
    public void monitor() {
        System.out.println("Monitoring basic vitals for " + patientName + ": Temperature=" + temperature 
                           + "°C, Blood Pressure=" + bloodPressure + " mmHg");
    }

    @Override
    public void evaluate() {
        System.out.print("Basic vitals condition: ");
        if (temperature > 38 || bloodPressure > 130) {
            System.out.println("Patient is at risk!");
        } else {
            System.out.println("Vitals are normal.");
        }
    }
}
