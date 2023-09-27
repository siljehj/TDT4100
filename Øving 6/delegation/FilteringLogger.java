package oving6.delegation;

import java.util.HashMap;
import java.util.Map;

public class FilteringLogger implements ILogger {

    public String ERROR = "error", WARNING = "warning", INFO = "info";
    private Map<String, Boolean> myMap = new HashMap<String, Boolean>();
    private ILogger logger;

    public FilteringLogger(ILogger logger, String... severities) {
        this.logger = logger;
        myMap.put(ERROR, false);
        myMap.put(WARNING, false);
        myMap.put(INFO, false);
        for (String s : severities) {
            myMap.put(s, true);
        }
    }

    public void log(String severity, String message, Exception exception) {
        if (myMap.get(severity)) {
            logger.log(severity, message, exception);
        }
    }

    public boolean isLogging(String severity) {
        return myMap.get(severity);
    }

    public void setIsLogging(String severity, boolean value) {
        myMap.put(severity, value);
    }

}
