package middleware.client;

import java.io.IOException;
import java.net.UnknownHostException;

import middleware.common.Marshaller;
import middleware.common.Message;

public class Requestor {

	public Object invoke(String hostName, int port, String remoteObject, String operation, Object... parameters) throws UnknownHostException, IOException, ClassNotFoundException {
		ClientRequestHandler requestHandler = new ClientRequestHandler(hostName, port);			
		Message message = new Message(remoteObject, operation, parameters);		
		
		return Marshaller.unmarshall(requestHandler.sendWithResponse(Marshaller.marshall(message)));
	}
}
