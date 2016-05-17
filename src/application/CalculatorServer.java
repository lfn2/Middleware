package application;
import java.io.IOException;
import java.net.InetAddress;
import commonServices.naming.NamingProxy;
import distribution.CalculatorInvoker;
import distribution.CalculatorProxy;
import java.util.HashMap;

import application.calculator.Calculator;

public class CalculatorServer {
	
	private static final int DEFAULT_PORT = 8080;
	private static final String NAMING_SERVICE_HOST = "localhost";
	private static final int NAMING_SERVICE_PORT = 1313;
	private static final int OBJECTS_QUANTITY = 3;
	private static final String APPLICATION_NAME = "Calculator";

	public static void main(String[] args) throws ClassNotFoundException, IOException {		
		CalculatorInvoker invoker = new CalculatorInvoker();				
		NamingProxy namingService = new NamingProxy(NAMING_SERVICE_HOST, NAMING_SERVICE_PORT);
		
		HashMap<Integer, Calculator> calculators = new HashMap<Integer, Calculator>();
		
		CalculatorProxy calculator;
		for (int i = 0; i < OBJECTS_QUANTITY; i++) {
			calculator = new CalculatorProxy(InetAddress.getLocalHost().getHostName(), DEFAULT_PORT, i);
			calculators.put(i, new Calculator());
			namingService.bind(APPLICATION_NAME, calculator);
		}
		
		invoker.invoke(DEFAULT_PORT, calculators);
	}
}	