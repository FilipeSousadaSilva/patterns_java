/**
*pass requests along a chain of handlers. 
*Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
*/

abstract class Logger {
    public static int INFO = 1;
    public static int WARNING = 2;
    public static int ERROR = 3;
    protected int level;
    protected Logger next;
    public void setNext(Logger nextLogger) {
        next = nextLogger;
    }
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (next != null) {
            next.logMessage(level, message);
        }
    }
    abstract protected void write(String message);
}

class ConsoleLogger extends Logger {
    public ConsoleLogger(int level) {
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

class FileLogger extends Logger {
    public FileLogger(int level) {
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);
        Logger errorLogger = new ErrorLogger(Logger.WARNING);
        Logger fileLogger = new FileLogger(Logger.ERROR);
        consoleLogger.setNext(errorLogger);
        errorLogger.setNext(fileLogger);
        consoleLogger.logMessage(Logger.INFO, "This is an information.");
        consoleLogger.logMessage(Logger.WARNING, "This is a warning.");
        consoleLogger.logMessage(Logger.ERROR, "This is an error.");
    }
}
