package application;
import java.io.IOException;
import java.net.InetAddress;
import commonServices.naming.NamingProxy;
import distribution.CalculatorInvoker;
import distribution.CalculatorProxy;

public class CalculatorServer {
	
	private static final int DEFAULT_PORT = 80;
	private static final String NAMING_SERVICE_HOST = "localhost";
	private static final int NAMING_SERVICE_PORT = 1313;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		int port = args.length == 1 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
		
		CalculatorInvoker invoker = new CalculatorInvoker();
		
		CalculatorProxy calculator = new CalculatorProxy(InetAddress.getLocalHost().getHostName(), DEFAULT_PORT);		
		NamingProxy namingService = new NamingProxy(NAMING_SERVICE_HOST, NAMING_SERVICE_PORT);
		namingService.bind("Calculator", calculator);
		
		invoker.invoke(port);
	}

}	