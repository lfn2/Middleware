package distribution;

import java.io.IOException;
import application.StringOperator;
import infrastructure.ServerRequestHandler;

public class StringOperatorInvoker {

	public void invoke(int port) throws IOException, ClassNotFoundException {
		ServerRequestHandler requestHandler = new ServerRequestHandler(port);
		
		StringOperator stringOperator = new StringOperator();
		String result = null;
		
		System.out.println("EchoInvoker running");
		
		while (true) {
			Message message = (Message) Marshaller.unmarshall(requestHandler.receive());
			
			switch(message.getOperation()) {
			case "concat":
				result = stringOperator.concat((String) message.getParameters().get(0), (String) message.getParameters().get(1));
				break;
				
			case "replace":
				result = stringOperator.replace((String) message.getParameters().get(0), (String) message.getParameters().get(1), (String) message.getParameters().get(2));
				break;
				
			case "reverse":
				result = stringOperator.reverse((String) message.getParameters().get(0));
				break;
				
			case "lowercase":
				result = stringOperator.lowercase((String) message.getParameters().get(0));
				break;
				
			case "uppercase":
				result = stringOperator.uppercase((String) message.getParameters().get(0));
				break;
			}
			
			requestHandler.send(Marshaller.marshall(result));
		}
		
	}
	
	
}
