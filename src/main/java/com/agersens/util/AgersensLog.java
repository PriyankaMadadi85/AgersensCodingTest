package com.agersens.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AgersensLog {
	
	private static Logger logger = null;
	
	public static void createLogFile() {
		if(logger == null) {
			logger = Logger.getLogger("Agersens Log");  
			FileHandler fh;  
		    try {  

		        // logger with handler and formatter  
		        fh = new FileHandler(System.getProperty("user.home")+"/agersens.log");  
		        logger.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);  
		        setLogger(logger);

		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		    
		}		
	}
	
	public static void writeToLog(String message) {
		if(getLogger() != null) {
			getLogger().info(message);
		}
	}

	public static Logger getLogger() {
		createLogFile();
		return logger;
	}

	public static void setLogger(Logger logger) {
		AgersensLog.logger = logger;
	}
	
	
}
