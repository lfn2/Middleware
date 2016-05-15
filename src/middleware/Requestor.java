package middleware;

import java.io.IOException;
import java.net.UnknownHostException;

public class Requestor {

	public Object invoke(String hostName, int port, String remoteObject, String operation, Object... parameters) throws UnknownHostException, IOException, ClassNotFoundException {
		ClientRequestHandler requestHandler = new ClientRequestHandler(hostName, port);			
		Message message = new Message(remoteObject, operation, parameters);		
		
		Message response = (Message) Marshaller.unmarshall(requestHandler.sendAndReceive(Marshaller.marshall(message)));		
		
		return response.getResult();		
	}
}
