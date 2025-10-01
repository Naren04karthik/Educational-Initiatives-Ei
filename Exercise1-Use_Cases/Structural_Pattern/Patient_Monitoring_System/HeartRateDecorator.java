import java.util.Scanner;

public class HeartRateDecorator extends MonitorDecorator {
    private int heartRate; // bpm

    public HeartRateDecorator(PatientMonitor monitor, Scanner sc) {
        super(monitor);
        System.out.print("Enter Heart Rate (bpm): ");
        this.heartRate = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void monitor() {
        super.monitor();
        System.out.println("Adding Heart Rate monitoring: " + heartRate + " bpm");
    }

    @Override
    public void evaluate() {
        super.evaluate();
        System.out.print("Heart Rate condition: ");
        if (heartRate < 60 || heartRate > 100) {
            System.out.println("Heart rate abnormal!");
        } else {
            System.out.println("Heart rate normal.");
        }
    }
}
