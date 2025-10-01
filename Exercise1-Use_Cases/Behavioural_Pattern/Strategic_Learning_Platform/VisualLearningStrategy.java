public class VisualLearningStrategy implements LearningStrategy {
    @Override
    public void learn(String studentName) {
        System.out.println(studentName + " is learning through Visual aids (diagrams, videos, infographics).");
    }
}
