package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import middleware.client.ClientRequestHandler;
import middleware.client.EchoProxy;
import middleware.common.Marshaller;

public class Client {

	public static final int DEFAULT_PORT = 80;
	public static final String DEFAULT_HOSTNAME = "localhost";
	
	public static void main(String[] args) {
		String hostname = args.length == 2 ? args[0] : DEFAULT_HOSTNAME;
		int port = args.length == 2 ? Integer.parseInt(args[1]) : DEFAULT_PORT;
		String input = "";
		String echoedMessage;
		EchoProxy echoProxy = new EchoProxy(hostname, port, "echo");
		
		try (
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		) {
			while (input != null) {	
				System.out.println("Type your message to be echoed: ");
				input = in.readLine();
				if (input != null) {
					echoedMessage = echoProxy.echo(input);
					System.out.println("Echo: " +echoedMessage);
				}				
			}
			
			System.out.println("Goodbye!");
		} catch (IOException e) {
			System.out.println("Não foi possível se conectar  ao servidor " +hostname+ " na porta " +port+ ".");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
