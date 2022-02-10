import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance = null;
    private int count = 1;

    private Logger() {
    }

    public static Logger get() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");

    void log(String msg) {
        System.out.println("[" + formatForDateNow.format(new Date()) + " " + count + "] " + msg);
        count++;
    }
}
