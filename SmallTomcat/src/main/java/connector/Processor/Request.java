package connector.Processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
	private InputStream inputStream;
	
	public enum RequestType {
		POST, PUT, DELETE, GET
	}
	
	private  RequestType requestType;
	
	private  String uri;
	
	public Request(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	// 初始化Request， 给两个属性赋值
	public void Init() {
		InputStreamReader inputReader = new InputStreamReader(inputStream);
		try {
			StringBuffer sb = new StringBuffer();
			char[] temp = new char[1024];
			int b;
			while ((b = inputReader.read(temp)) != -1) {
				sb.append(new String(temp).substring(0, b));
			}
			String requestMessage = sb.toString();
			
			// get URI and requestType
			String[] parseResult = getFirstLineOfRequest(requestMessage);
			if(parseResult.length == 3) {
				uri = parseResult[1];
				requestType = RequestType.valueOf(parseResult[0]);
				System.out.println("URI : " + uri);
				System.out.println("reType : " + requestType);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] getFirstLineOfRequest(String requestMessage) {
		int index = requestMessage.indexOf("\r\n");
		if(index != -1) {
			return requestMessage.substring(0, index).split(" ");
		}
		return null;
	}
	
	public String getUri() {
		return uri;
	}
	
	public RequestType geRequestType() {
		return requestType;
	}
	
}
