package connector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import connector.Processor.BioProcessor;

/**
 * 从头开始构建一个简单的Http服务器
 * @author wzpmovingday@gmail.com
 * @since 1.0
 */
public class ServerBoot {

	public static void main(String[] args) {
		ServerBoot serverBoot = new ServerBoot();
		serverBoot.await();
	}
	
	public void await() {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
			Socket socket = null;
			while (true) {
				socket = serverSocket.accept();
				BioProcessor processor = new BioProcessor(socket);
				processor.process();
			}	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
