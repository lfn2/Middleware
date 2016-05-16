package infrastructure;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRequestHandler implements Closeable{
	private String hostName;
	private int port;
	
	private Socket socket;
	
	public ClientRequestHandler(String hostName, int port) throws UnknownHostException, IOException {
		this.hostName = hostName;
		this.port = port;	
	}
	
	public byte[] sendWithResponse(byte[] message) throws UnknownHostException, IOException {
		send(message);
		return receive();
	}
	
	private void send(byte[] message) throws UnknownHostException, IOException {	
		this.socket = new Socket(this.hostName, this.port);
		DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());
		
		out.writeInt(message.length);
		out.write(message);
	}
	
	private byte[] receive() throws IOException {
		DataInputStream in = new DataInputStream(this.socket.getInputStream());
		byte[] message = null;
		
		int length = in.readInt();
		if (length > 0) {
			message = new byte[length];
			in.read(message, 0, length);
		}
		
		return message;
	}	

	@Override
	public void close() throws IOException {
		socket.close();
	}
	
}
