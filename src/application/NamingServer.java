package application;

import java.io.IOException;

import commonServices.naming.NamingInvoker;

public class NamingServer {
	
	private static final int DEFAULT_PORT = 1313;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		NamingInvoker namingInvoker = new NamingInvoker();
		
		namingInvoker.Invoke(DEFAULT_PORT);
	}
	
}
