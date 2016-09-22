package connector.Processor;

import java.io.IOException;
import java.io.OutputStream;

public class Response {
	private OutputStream output;
	
	public Response(OutputStream output) {
		this.output = output;
	}
	
	public void sendStaticMessage(String message) {
		try {
			output.write(message.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
