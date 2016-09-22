package container;

import connector.Processor.Request;
import connector.Processor.Response;

public class StaticResourceHandler {
	
	public static void service(Request request, Response response) {
		String meseage = "HTTP/1.1 404 File Not Found \r\n" + 
				"Contend-Type: text/html\r\n" + 
				"Content-Length: 23\r\n" + 
				"\r\n" +
				"<h1> File Not Found</h1>";
		response.sendStaticMessage(meseage);
	}

}
