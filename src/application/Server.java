package application;
import java.io.IOException;
import middleware.server.EchoInvoker;
import middleware.server.ServerRequestHandler;

public class Server {
	
	private static final int DEFAULT_PORT = 80;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		int port = args.length == 1 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
		EchoInvoker invoker = new EchoInvoker();
		invoker.invoke(port);
	}

}
