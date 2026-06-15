
public class Logger {
    private static Logger instance;
    private Logger() {
        System.out.println("Logger initialized.");
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Application started.");
        logger2.log("Processing data...");
        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Error: Different instances created.");
        }
    }
}