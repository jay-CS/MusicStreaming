import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class CommunicationModuleClient {

	final int FRAGMENT_SIZE = 65000;
	DatagramSocket socket;
	int serverSocketNum;
	InetAddress serverAddress;

	public CommunicationModuleClient() throws UnknownHostException, SocketException {
		this.socket = new DatagramSocket();
		serverSocketNum = 1111;
		this.serverAddress = InetAddress.getByName("localhost");
	}

	public String sendToServer(String msg) throws IOException {

		System.out.println("Received: " + msg);

		String string = "";

		while (true) {


			byte[] msgBytes = msg.getBytes();
			DatagramPacket request = new DatagramPacket(msgBytes, msgBytes.length, serverAddress, serverSocketNum);
			socket.send(request);

			byte[] buffer = new byte[FRAGMENT_SIZE];
			//receive reply from server
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			socket.receive(reply);
			System.out.println("Client recieved here: " + new String(reply.getData()));
			string = new String(reply.getData());
			System.out.println("Sending: " + string);
			socket.close();
			break;
		}

		return string;

	}
	public DatagramSocket getSocket() {
		return this.socket;
	}
	public int getServerSocketNum() {
		return this.serverSocketNum;
	}
	public InetAddress getServerAddress() {
		return this.serverAddress;
	}
	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}
	public void setServerSocketNum(int serverSocketNum) {
		this.serverSocketNum = serverSocketNum;
	}
	public void setServerSocketAddress(String string) throws UnknownHostException {
		serverAddress = InetAddress.getByName(string);
	}
}
