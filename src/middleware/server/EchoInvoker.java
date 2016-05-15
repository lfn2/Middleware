package middleware.server;

import java.io.IOException;

import application.Echo;
import middleware.client.ClientProxy;
import middleware.common.Marshaller;
import middleware.common.Message;

public class EchoInvoker {

	public void invoke(int port) throws IOException, ClassNotFoundException {
		ServerRequestHandler requestHandler = new ServerRequestHandler(port);
		
		Echo echo = new Echo();
		Object result = null;
		
		System.out.println("EchoInvoker running");
		
		while (true) {
			Message message = (Message) Marshaller.unmarshall(requestHandler.receive());
			
			switch(message.getOperation()) {
			case "echo":
				String s = (String) message.getParameters().get(0);
				result = echo.echo(s);
			}
			
			requestHandler.send(Marshaller.marshall(result));
		}
		
	}
	
	
}
