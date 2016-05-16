package infrastructure;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestHandler implements Closeable{
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public ServerRequestHandler(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);		
	}
	
	public void send(byte[] message) throws IOException {
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		out.writeInt(message.length);
		out.write(message);
	}
	
	public byte[] receive() throws IOException {
		this.clientSocket = serverSocket.accept();		
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		
		int messageLength = in.readInt();
		byte[] message = new byte[messageLength];
		in.read(message, 0, messageLength);		
		
		return message;
	}

	@Override
	public void close() throws IOException {
		clientSocket.close();
		serverSocket.close();
	}
	
}
