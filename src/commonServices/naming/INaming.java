package commonServices.naming;

import java.util.Set;

import distribution.ClientProxy;

public interface INaming {

	/**
	 * Binds a service to the naming service.
	 * @param serviceName
	 * @param clientProxy
	 * @return boolean indicating if the service was bound.
	 * @throws Throwable 
	 */
	public boolean bind(String serviceName, ClientProxy clientProxy) throws Throwable;
	
	/**
	 * Searches for a service in the naming service.
	 * @param serviceName
	 * @return The Client Proxy associated with the requested service or null if the service was not found.
	 * @throws Throwable 
	 */
	public ClientProxy lookup(String serviceName) throws Throwable;
	
	/**
	 * @return A set containing all of the names of the services available on the naming service.
	 * @throws Throwable 
	 */
	public Set<String> list() throws Throwable;	
}
