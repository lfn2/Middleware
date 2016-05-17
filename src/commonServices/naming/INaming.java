package commonServices.naming;

import java.util.Set;

import distribution.ClientProxy;

public interface INaming {
	
	public void bind(String serviceName, ClientProxy clientProxy) throws Throwable;

	public ClientProxy lookup(String serviceName) throws Throwable;

	public Set<String> list() throws Throwable;	
	
}