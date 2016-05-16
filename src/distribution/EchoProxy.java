package distribution;

import java.io.IOException;
import java.net.UnknownHostException;

public class EchoProxy extends ClientProxy {
	
	private static final long serialVersionUID = 1L;

	public EchoProxy(String hostName, int port, String remoteObject) {
		super(hostName, port, remoteObject);
	}
	
	public String echo(String s) throws UnknownHostException, ClassNotFoundException, IOException {
		Requestor requestor = new Requestor();
		
		String echo = (String) requestor.invoke(this.hostName, this.port, this.remoteObject, "echo", s);
		
		return echo;
	}
	
}
