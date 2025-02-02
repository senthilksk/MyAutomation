package seleniumPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogDemo {
	
	Logger logger=LogManager.getLogger(LogDemo.class);
	
	@Test
	public void logMethod() {
		
		logger.info("Info message");
		logger.fatal("fatal message");
		logger.error("error message");
		logger.debug("debug message");
		logger.warn("warn message");
		
	}

}
