package commonServices.naming;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Set;

import distribution.ClientProxy;
import distribution.Requestor;

public class NamingProxy extends ClientProxy implements INaming{
	
	private Requestor requestor;
	
	public NamingProxy(String hostName, int port) {
		super(hostName, port, 0);
		this.requestor = new Requestor();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean bind(String serviceName, ClientProxy clientProxy) throws UnknownHostException, ClassNotFoundException, IOException {
		return (boolean) requestor.invoke(this.hostName, this.port, this.objectId, "bind", serviceName, clientProxy);
	}

	@Override
	public ClientProxy lookup(String serviceName) throws UnknownHostException, ClassNotFoundException, IOException {
		return (ClientProxy) requestor.invoke(this.hostName, this.port, this.objectId, "lookup", serviceName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<String> list() throws UnknownHostException, ClassNotFoundException, IOException {
		return (Set<String>) requestor.invoke(this.hostName, this.port, this.objectId, "lookup");
	}

}