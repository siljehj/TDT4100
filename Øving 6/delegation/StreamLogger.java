package oving6.delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {

    private OutputStream stream;
    private String formatString = "%s: %s (%s)";
    public String ERROR = "error", WARNING = "warning", INFO = "info";

    public StreamLogger(OutputStream stream) {
        this.stream = stream;
    }

    public void log(String severity, String message, Exception exception) {
        String s = String.format(formatString, severity, message, exception);
        byte[] bytes = s.getBytes();
        try {
            stream.write(bytes);
            stream.flush();
        } catch (IOException ex) {
            System.out.println("Something went wrong lol");
        }
    }

    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }

}
