package distribution;

import java.io.Serializable;

public abstract class ClientProxy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String hostName;
	protected int port;
	protected String remoteObject;
	
	public ClientProxy(String hostName, int port, String remoteObject) {
		this.hostName = hostName;
		this.port = port;
		this.remoteObject = remoteObject;
	}
	
	public String getHostName() {
		return this.hostName;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public String getRemoteObject() {
		return this.remoteObject;
	}
	
}
