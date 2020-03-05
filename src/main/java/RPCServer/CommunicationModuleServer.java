
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class CommunicationModuleServer {
	
    Dispatcher dispatcher = new Dispatcher();
    final int FRAGMENT_SIZE = 65000;
    int socketNum;
    
    public static void main(String[] args) throws IOException {
    	CommunicationModuleServer server = new CommunicationModuleServer();
        server.recieveFromClient();
    }

    
    public void recieveFromClient() throws IOException {

        DatagramSocket socket = new DatagramSocket(socketNum);
            byte[] buffer = new byte[FRAGMENT_SIZE];

            while (true) {
            	
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                //blocks until message arrives
                socket.receive(request);
                String message = new String(request.getData()).trim();
                System.out.println("Received: " + message);
                String retString = dispatcher.dispatch(message);
                byte[] msgBytes = (retString).getBytes();
                
                //get client address and port
                InetAddress address = request.getAddress();
                int port = request.getPort();
                
                //reply to client
                DatagramPacket reply = new DatagramPacket(msgBytes, msgBytes.length, address, port);
                socket.send(reply);
                buffer = new byte[FRAGMENT_SIZE];

            }
            
        

    }
    public int getSocketNum() {
    	return this.socketNum;
    }
    public void setSocketNum(int socketNum) {
    	this.socketNum = socketNum;
    }

}
