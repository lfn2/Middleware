package commonServices.naming;

import java.util.Set;

import distribution.ClientProxy;

public class NamingImpl implements INaming {
	
	private NamingRepository namingRepository;
	
	public NamingImpl() {
		this.namingRepository = new NamingRepository();
	}

	@Override
	public boolean bind(String serviceName, ClientProxy clientProxy) {
		return this.namingRepository.addNamingRecord(serviceName, clientProxy);
	}

	@Override
	public ClientProxy lookup(String serviceName) {
		return this.namingRepository.getService(serviceName);
	}

	@Override
	public Set<String> list() {
		return this.namingRepository.getAllServiceNames();
	}

}