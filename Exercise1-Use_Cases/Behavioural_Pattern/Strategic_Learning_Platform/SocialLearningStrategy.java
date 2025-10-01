public class SocialLearningStrategy implements LearningStrategy {
    @Override
    public void learn(String studentName) {
        System.out.println(studentName + " is learning through Social interactions (group projects, peer discussions).");
    }
}
