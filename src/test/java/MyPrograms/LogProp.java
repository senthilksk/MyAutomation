package MyPrograms;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogProp {
	
	static Logger logger = Logger.getLogger(LogProp.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Info message");
		logger.fatal("fatal message");
		logger.error("error message");
		logger.debug("debug message");
		logger.warn("warn message");

	}

}
