import java.util.Scanner;

public class ECGDecorator extends MonitorDecorator {
    private int heartRhythm; // bpm

    public ECGDecorator(PatientMonitor monitor, Scanner sc) {
        super(monitor);
        System.out.print("Enter ECG Heart Rhythm (bpm): ");
        this.heartRhythm = sc.nextInt();
        sc.nextLine(); // consume newline
    }

    @Override
    public void monitor() {
        super.monitor();
        System.out.println("Adding ECG monitoring: Heart Rhythm=" + heartRhythm + " bpm");
    }

    @Override
    public void evaluate() {
        super.evaluate();
        System.out.print("ECG condition: ");
        if (heartRhythm < 60 || heartRhythm > 100) {
            System.out.println("Abnormal heart rate detected!");
        } else {
            System.out.println("Heart rate normal.");
        }
    }
}
