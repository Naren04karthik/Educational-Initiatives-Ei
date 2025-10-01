
// LoggerUtil.java
// Utility class for standardized logging setup across project.

import java.util.logging.*;

public class LoggerUtil {
    public static Logger getLogger(String className) {
        Logger logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false); // Avoid duplicate logs

        // Console log handler with simple formatting
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        return logger;
    }
}
