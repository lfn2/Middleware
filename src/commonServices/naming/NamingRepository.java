package commonServices.naming;

import java.util.HashMap;
import java.util.Set;

import distribution.ClientProxy;

public class NamingRepository {
	
	private HashMap<String, ClientProxy> namingRecords;
	
	public NamingRepository() {
		this.namingRecords = new HashMap<String, ClientProxy>();
	}	
	
	public boolean addNamingRecord(String serviceName, ClientProxy clientProxy) {
		return this.namingRecords.putIfAbsent(serviceName, clientProxy) == null;
	}	
	
	public ClientProxy getService(String serviceName) {
		return this.namingRecords.get(serviceName);
	}
	
	public Set<String> getAllServiceNames() {
		return this.namingRecords.keySet();
	}
}