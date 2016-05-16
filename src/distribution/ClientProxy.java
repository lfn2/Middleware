package distribution;

import java.io.Serializable;

public abstract class ClientProxy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String hostName;
	protected int port;
	protected String objectId;
	
	public ClientProxy(String hostName, int port, String remoteObject) {
		this.hostName = hostName;
		this.port = port;
		this.objectId = remoteObject;
	}
	
	public String getHostName() {
		return this.hostName;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public String getObjectId() {
		return this.objectId;
	}
	
}
