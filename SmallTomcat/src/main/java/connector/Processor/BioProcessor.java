package connector.Processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.print.attribute.standard.JobHoldUntil;

import container.StaticResourceHandler;

public class BioProcessor {
	private Socket socket;
	
	public BioProcessor(Socket socket) {
		this.socket = socket;
	}
	
	public void process() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			
			Request request = new Request(inputStream);
			request.Init();
			
			Response response = new Response(outputStream);
			
			if(request.getUri() != null && request.getUri().startsWith("/servlet")) {
				
			}
			
			else {
				StaticResourceHandler.service(request, response);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
