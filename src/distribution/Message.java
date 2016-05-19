package distribution;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int objectId;
	private String operation;
	private ArrayList<Object> parameters;
	
	public Message(int remoteObject, String operation, Object... parameters) {
		this.objectId = remoteObject;
		this.operation = operation;
		
		this.parameters = new ArrayList<Object>();
		for (Object parameter : parameters)
			this.parameters.add(parameter);
	}

	public String getOperation() {
		return this.operation;
	}

	public ArrayList<Object> getParameters() {
		return this.parameters;
	}

	public int getObjectId() {
		return this.objectId;
	}
	
}