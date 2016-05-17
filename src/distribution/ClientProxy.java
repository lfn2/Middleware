package distribution;

import java.io.Serializable;

public abstract class ClientProxy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String hostName;
	protected int port;
	protected int objectId;
	
	public ClientProxy(String hostName, int port, int objectId) {
		this.hostName = hostName;
		this.port = port;
		this.objectId = objectId;
	}
	
	public String getHostName() {
		return this.hostName;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public int getObjectId() {
		return this.objectId;
	}
	
}
