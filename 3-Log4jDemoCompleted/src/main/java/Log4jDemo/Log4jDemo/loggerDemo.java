package Log4jDemo.Log4jDemo;
import org.apache.log4j.*;
import java.util.ArrayList;

public class loggerDemo {
	
	final static Logger logger = Logger.getLogger(loggerDemo.class);
	public static void main(String[] args) {
		logger.info("entered the main");
		logger.trace("we have set x to 5");
		int x =5;
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		//numList.add(x);
		logger.trace("we have added x to the list");
		
		try {
			numList.remove(0);
			logger.info("Successfully removed the variable");
			
		}
		catch(Exception e) {
			logger.error("Could not successfully remove the variable");
		}
	}

}
