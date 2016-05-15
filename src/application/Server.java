package application;
import java.io.IOException;

import middleware.Marshaller;
import middleware.ServerRequestHandler;

public class Server {
	
	private static final int DEFAULT_PORT = 80;

	public static void main(String[] args) {
		int port = args.length == 1 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
		byte[] message;
		String clientString;
		
		try(
			ServerRequestHandler requestHandler = new ServerRequestHandler(port);
		) {
			System.out.println("Server Running!");
			while (true) {
				message = requestHandler.receive();
				clientString = (String) Marshaller.unmarshall(message);
				System.out.println("Message received: " + clientString);
				requestHandler.send(Marshaller.marshall(clientString));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
