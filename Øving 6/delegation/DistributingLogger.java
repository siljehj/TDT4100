package oving6.delegation;

public class DistributingLogger implements ILogger {

public String ERROR = "error", WARNING = "warning", INFO = "info";
private ILogger errorLogger, warrningLogger, infoLogger;

public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
    this.errorLogger = errorLogger;
    this.warrningLogger = warningLogger;
    this.infoLogger = infoLogger;
}

public void setLogger(String severity, ILogger logger) {
    if (severity.equals(ERROR)) {
        errorLogger = logger;
    }
    else if (severity.equals(WARNING)) {
        warrningLogger = logger;
    }
    else if (severity.equals(INFO)) {
        infoLogger = logger;
    }
}

public void log(String severity, String message, Exception exception) {
    if (severity.equals(ERROR)) {
        errorLogger.log(severity, message, exception);
    }
    else if (severity.equals(WARNING)) {
        warrningLogger.log(severity, message, exception);
    }
    else if (severity.equals(INFO)) {
        infoLogger.log(severity, message, exception);
    }
}
    
}
