package distribution;

import java.io.IOException;
import application.calculator.Calculator;
import infrastructure.ServerRequestHandler;

public class CalculatorInvoker {

	private ServerRequestHandler requestHandler;

	public void invoke(int port) throws IOException, ClassNotFoundException {
		this.requestHandler = new ServerRequestHandler(port);

		Calculator calculator = new Calculator();
		float result = 0;

		System.out.println("CalculatorInvoker running");

		while (true) {
			Message message = (Message) Marshaller.unmarshall(this.requestHandler.receive());

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