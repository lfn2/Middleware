package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import commonServices.naming.NamingProxy;
import distribution.CalculatorProxy;

public class CalculatorClient {

	public static final int DEFAULT_PORT = 80;
	public static final String DEFAULT_HOSTNAME = "localhost";
	private static final String NAMING_SERVICE_HOST = "localhost";
	private static final int NAMING_SERVICE_PORT = 1313;
	
	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		String hostname = args.length == 2 ? args[0] : DEFAULT_HOSTNAME;
		int port = args.length == 2 ? Integer.parseInt(args[1]) : DEFAULT_PORT;
		String input = "";
		float a, b, result = 0;
		
		NamingProxy namingService = new NamingProxy(NAMING_SERVICE_HOST, NAMING_SERVICE_PORT);			
		CalculatorProxy	calculatorProxy = (CalculatorProxy) namingService.lookup("Calculator");
		
		System.out.println("Welcome to Middleware Calculator!");
		
		try (			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		) {
			while (input != null) {		
				
				
				System.out.println("Type 1-4 for your desired operation:");
				System.out.println("1. Add");
				System.out.println("2. Sub");
				System.out.println("3. Div");
				System.out.println("4. Mult");
				System.out.println("9. Exit");
				input = in.readLine();
				
				if(input.compareTo("9") == 0 || input.toLowerCase().compareTo("exit") == 0) {
					System.out.println("Goodbye!");
					System.exit(0);
				}
				
				System.out.println("Type your first operand: ");
				a = Float.parseFloat(in.readLine());				
				
				System.out.println("Type your second operand: ");
				b = Float.parseFloat(in.readLine());				
				if (input != null) {
					switch (input.toLowerCase()) {
					case "1":
					case "add":
						result = calculatorProxy.add(a, b);
						break;
					case "2":
					case "sub":
						result = calculatorProxy.sub(a, b);
						break;
					case "3":
					case "div":
						result = calculatorProxy.div(a, b);
						break;
					case "4":
					case "mult": 
						result = calculatorProxy.mult(a, b);
						break;
					default:
						System.out.println("Operação inválida!");
					}				
					
					System.out.println("Result: " +result);
					System.out.println();
				}				
			}
			
			
		} catch (IOException e) {
			System.out.println("Não foi possível se conectar  ao servidor " +hostname+ " na porta " +port+ ".");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
