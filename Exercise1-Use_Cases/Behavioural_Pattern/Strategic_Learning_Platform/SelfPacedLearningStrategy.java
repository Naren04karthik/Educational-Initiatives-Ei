public class SelfPacedLearningStrategy implements LearningStrategy {
    @Override
    public void learn(String studentName) {
        System.out.println(studentName + " is learning through Self-Paced methods (independent study, personalized timelines).");
    }
}
