
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
                socket.receive(request);
                String message = new String(request.getData()).trim();
                System.out.println("Received: " + message);
                String retString = dispatcher.dispatch(message);
                byte[] msgBytes = (retString).getBytes();
                DatagramPacket reply = new DatagramPacket(msgBytes, msgBytes.length, request.getAddress(), request.getPort());
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
