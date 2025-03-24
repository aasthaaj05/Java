abstract class Logger {
    protected Logger nextLogger;
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }
    public void logMessage(String level, String message) {
        if (canHandle(level)) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }
    protected abstract boolean canHandle(String level);
    protected abstract void write(String message);
}

class DebugLogger extends Logger {
    protected boolean canHandle(String level) { return level.equals("DEBUG"); }
    protected void write(String message) { System.out.println("DEBUG: " + message); }
}

class InfoLogger extends Logger {
    protected boolean canHandle(String level) { return level.equals("INFO"); }
    protected void write(String message) { System.out.println("INFO: " + message); }
}

class ErrorLogger extends Logger {
    protected boolean canHandle(String level) { return level.equals("ERROR"); }
    protected void write(String message) { System.out.println("ERROR: " + message); }
}

public class Chain {
    public static void main(String[] args) {
        Logger errorLogger = new ErrorLogger();
        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();

        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);

        debugLogger.logMessage("INFO", "This is an info message.");
        debugLogger.logMessage("ERROR", "This is an error message.");
    }
}
