// Utility class for SQL helper methods
public class QueryUtils {
    // Escape single quotes to prevent SQL injection
    public static String escape(String input) {
        return input.replace("'", "''");
    }
}
