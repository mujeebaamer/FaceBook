package helpers;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import org.apache.log4j.Logger;


public class LogHelpers {
	//Initialize Log4j instance
    private static Logger Log = Logger.getLogger(LogHelpers.class.getName());
 
    //We can use it when starting tests
    public static void startLog (String testClassName){
        Log.info(testClassName);
    }
 
    //We can use it when ending tests
    public static void endLog (String testClassName){
        Log.info(testClassName);
    }
 
    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }
    
 
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
 
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }
 
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }
 
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }    

}
