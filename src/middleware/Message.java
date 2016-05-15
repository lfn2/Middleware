package middleware;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String remoteObject;
	private String operation;
	private ArrayList<Object> parameters;
	private Object result;
	
	public Message(String remoteObject, String operation, Object... parameters) {
		this.remoteObject = remoteObject;
		this.operation = operation;
		
		this.parameters = new ArrayList<Object>();
		for (Object parameter : parameters)
			this.parameters.add(parameter);
	}

	public String getOperation() {
		return operation;
	}

	public ArrayList<Object> getParameters() {
		return parameters;
	}

	public String getRemoteObject() {
		return remoteObject;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
