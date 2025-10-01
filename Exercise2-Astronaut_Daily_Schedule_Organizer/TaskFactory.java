
// TaskFactory.java
// Factory Pattern - creates Task objects safely with validation of time format and ranges.

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    // Creates a task by validating start and end times
    public static Task createTask(String description, String start, String end, String priority) throws CustomException {
        try {
            // Parse input strings into LocalTime objects
            LocalTime startTime = LocalTime.parse(start);
            LocalTime endTime = LocalTime.parse(end);

            // Validate that end time is not before start
            if (endTime.isBefore(startTime)) {
                throw new CustomException("End time cannot be before start time.");
            }

            // Create and return a new Task
            return new Task(description, startTime, endTime, priority);

        } catch (DateTimeParseException e) {
            // If the time format is wrong, throw custom exception
            throw new CustomException("Invalid time format. Use HH:mm (e.g., 09:30).");
        }
    }
}
