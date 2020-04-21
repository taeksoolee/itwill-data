package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jHelloWorld {
	private static final Logger logger 
		= LoggerFactory.getLogger(Log4jHelloWorld.class);
	
	public String hello(String name) {
		logger.info("Ω√¿€");
		String message=name+"¥‘ æ»≥Á«œººø‰.";
		logger.info("¡æ∑·");
		return message;
	}
}
