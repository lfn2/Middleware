package distribution;

import java.io.IOException;
import java.net.UnknownHostException;

import application.calculator.ICalculator;

public class CalculatorProxy extends ClientProxy implements ICalculator {
	
	private static final long serialVersionUID = 3790118147520601326L;
	
	private Requestor requestor;
	
	public CalculatorProxy(String hostName, int port, int objectId) {		
		super(hostName, port, objectId);
		this.requestor = new Requestor();
	}	

	@Override
	public float add(float a, float b) throws UnknownHostException, ClassNotFoundException, IOException {
		return (float) this.requestor.invoke(this.hostName, this.port, this.objectId, "add", a, b);
	}

	@Override
	public float sub(float a, float b) throws UnknownHostException, ClassNotFoundException, IOException {
		return (float) this.requestor.invoke(this.hostName, this.port, this.objectId, "sub", a, b);
	}

	@Override
	public float div(float a, float b) throws UnknownHostException, ClassNotFoundException, IOException {
		return (float) this.requestor.invoke(this.hostName, this.port, this.objectId, "div", a, b);
	}

	@Override
	public float mult(float a, float b) throws UnknownHostException, ClassNotFoundException, IOException {
		return (float) this.requestor.invoke(this.hostName, this.port, this.objectId, "mult", a, b);
	}

}
