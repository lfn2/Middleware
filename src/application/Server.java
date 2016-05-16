package application;
import java.io.IOException;

import distribution.StringOperatorInvoker;
import infrastructure.ServerRequestHandler;

public class Server {
	
	private static final int DEFAULT_PORT = 80;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		int port = args.length == 1 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
		StringOperatorInvoker invoker = new StringOperatorInvoker();
		invoker.invoke(port);
	}

}
