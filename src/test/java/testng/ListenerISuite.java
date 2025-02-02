package testng;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ListenerISuite implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
	
		ISuiteListener.super.onFinish(suite);
	}

}
