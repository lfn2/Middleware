package application;
import java.io.IOException;
import java.net.InetAddress;
import commonServices.naming.NamingProxy;
import distribution.CalculatorInvoker;
import distribution.CalculatorProxy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CalculatorServer {
	
	private static final int DEFAULT_PORT = 8080;
	private static final String NAMING_SERVICE_HOST = "localhost";
	private static final int NAMING_SERVICE_PORT = 1313;
	private static final int OBJECTS_QUANTITY = 3;
	private static final String APPLICATION_NAME = "Calculator";

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		int port = args.length == 1 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
		
		CalculatorInvoker invoker = new CalculatorInvoker();				
		ArrayList<CalculatorProxy> calculators = new ArrayList<CalculatorProxy>();	
		NamingProxy namingService = new NamingProxy(NAMING_SERVICE_HOST, NAMING_SERVICE_PORT);
		
		CalculatorProxy calculator;
		for (int i = 0; i < OBJECTS_QUANTITY; i++) {
			calculator = new CalculatorProxy(InetAddress.getLocalHost().getHostName(), port, i);
			calculators.add(calculator);
			namingService.bind(APPLICATION_NAME, calculator);
		}
		
		invoker.invoke(port, calculators);
	}

}	