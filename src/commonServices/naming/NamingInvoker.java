package commonServices.naming;

import java.io.IOException;

import distribution.ClientProxy;
import distribution.Marshaller;
import distribution.Message;
import infrastructure.ServerRequestHandler;
 
public class NamingInvoker {
	
	private ServerRequestHandler requestHandler;
	
	public void Invoke(int port) throws IOException, ClassNotFoundException {
		this.requestHandler = new ServerRequestHandler(port);
		
		NamingImpl naming = new NamingImpl();
		Object response = null;
		
		while (true) {
			Message message = (Message) Marshaller.unmarshall(this.requestHandler.receive());
			
			switch (message.getOperation()) {
			case "bind":
				response = naming.bind((String) message.getParameters().get(0), (ClientProxy) message.getParameters().get(1));
				break;
			case "lookup":
				response = naming.lookup((String) message.getParameters().get(0));
				break;
			case "list":
				response = naming.list();
				break;
			}
			
			requestHandler.send(Marshaller.marshall(response));
		}
	}
	
}
