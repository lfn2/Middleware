package distribution;

import java.io.IOException;
import java.util.HashMap;
import application.calculator.Calculator;
import infrastructure.ServerRequestHandler;

public class CalculatorInvoker {

	private ServerRequestHandler requestHandler;

	public void invoke(int port, HashMap<Integer, Calculator> calculators) throws IOException, ClassNotFoundException {
		this.requestHandler = new ServerRequestHandler(port);
		float result = 0;
		Calculator calculator;
		
		System.out.println("CalculatorInvoker running");
		
		while (true) {
			Message message = (Message) Marshaller.unmarshall(this.requestHandler.receive());			
			calculator = calculators.get(message.getObjectId());	
			System.out.println("Using calculator " + message.getObjectId());
			
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