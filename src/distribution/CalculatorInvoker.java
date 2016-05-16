package distribution;

import java.io.IOException;
import application.calculator.Calculator;
import infrastructure.ServerRequestHandler;

public class CalculatorInvoker {

	public void invoke(int port) throws IOException, ClassNotFoundException {
		ServerRequestHandler requestHandler = new ServerRequestHandler(port);

		Calculator calculator = new Calculator();
		float result = 0;

		System.out.println("EchoInvoker running");

		while (true) {
			Message message = (Message) Marshaller.unmarshall(requestHandler.receive());

			switch(message.getOperation()) {
			case "add":
				result = calculator.add((float)message.getParameters().get(0), (float)message.getParameters().get(1));
				break;
			
			case "sub":
				result = calculator.sub((float)message.getParameters().get(0), (float)message.getParameters().get(1));
				break;
				
			case "div":
				result = calculator.div((float)message.getParameters().get(0), (float)message.getParameters().get(1));
				break;
				
			case "mult":
				result = calculator.mult((float)message.getParameters().get(0), (float)message.getParameters().get(1));
				break;
			}

			requestHandler.send(Marshaller.marshall(result));
		}
	}

}