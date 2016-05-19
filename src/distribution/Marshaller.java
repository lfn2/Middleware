package distribution;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Marshaller {

	public static byte[] marshall(Object o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(baos);
		out.writeObject(o);		
		return baos.toByteArray();
	}
	
	public static Object unmarshall(byte[] object) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(object);
		ObjectInput in = new ObjectInputStream(bais);
		return in.readObject();		
	}	
}