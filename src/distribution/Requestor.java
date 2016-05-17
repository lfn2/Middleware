package distribution;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;

import infrastructure.ClientRequestHandler;

public class Requestor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ClientRequestHandler requestHandler;

	public Object invoke(String hostName, int port, int objectId, String operation, Object... parameters) throws UnknownHostException, IOException, ClassNotFoundException {
		requestHandler = new ClientRequestHandler(hostName, port);			
		Message message = new Message(objectId, operation, parameters);		
		
		return Marshaller.unmarshall(requestHandler.sendWithResponse(Marshaller.marshall(message)));
	}
}
