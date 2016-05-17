package distribution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import application.calculator.Calculator;
import infrastructure.ServerRequestHandler;

public class CalculatorInvoker {

	private ServerRequestHandler requestHandler;

	public void invoke(int port, ArrayList<CalculatorProxy> calculators) throws IOException, ClassNotFoundException {
		this.requestHandler = new ServerRequestHandler(port);
		float result = 0;
		Calculator calculator;
		
		System.out.println("CalculatorInvoker running");
		
		HashMap<Integer, Calculator> map = new HashMap<Integer, Calculator>();
		for (CalculatorProxy c : calculators) {
			map.put(c.getObjectId(), new Calculator());
		}
		
		while (true) {
			Message message = (Message) Marshaller.unmarshall(this.requestHandler.receive());			
			calculator = map.get(message.getObjectId());		
			
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