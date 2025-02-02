package MyPrograms;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LogBasicConfigure {
	
	static Logger logger = Logger.getLogger(LogBasicConfigure.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BasicConfigurator.configure();
		logger.info("Info message");
		logger.fatal("fatal message");
		logger.error("error message");
		logger.debug("debug message");
		logger.warn("warn message");

	}

}
