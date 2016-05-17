package commonServices.naming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import distribution.ClientProxy;

public class NamingRepository {
	
	private HashMap<String, LinkedList<ClientProxy>> namingRecords;
	
	public NamingRepository() {
		this.namingRecords = new HashMap<String, LinkedList<ClientProxy>>();
	}	
	
	public void addNamingRecord(String serviceName, ClientProxy clientProxy) {		
		if (this.namingRecords.containsKey(serviceName))
			this.namingRecords.get(serviceName).add(clientProxy);
		else 
			this.namingRecords.put(serviceName, new LinkedList<ClientProxy>(Arrays.asList(clientProxy)));
	}	
	
	public ClientProxy getService(String serviceName) {
		this.namingRecords.get(serviceName).add(namingRecords.get(serviceName).poll());
		return this.namingRecords.get(serviceName).getLast();
	}
	
	public Set<String> getAllServiceNames() {
		return this.namingRecords.keySet();
	}
}