
package CucumberInstallation._CucumberClientServer;
//Change the package
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class server extends Thread {
	private ServerSocket serSock;
	private static int port;
	private boolean timedOut;
	private static int lastNum;
	public server(int x) throws IOException{
		port = x;
		serSock = new ServerSocket(port);
		timedOut=false;
		//Timeout if you need to use it (milliseconds)
		serSock.setSoTimeout(10000);
	}
	
	
	public void run() {
		int squared;
		while(true) {
			try {
				System.out.println("WAITING for client connection on port: "+serSock.getLocalPort());
				Socket receiveSocket = serSock.accept();
				System.out.println("RECEIVED connection from client: "+receiveSocket.getRemoteSocketAddress());
				DataInputStream fromClient = new DataInputStream(receiveSocket.getInputStream());
				
				//Place the number from the client into receivedNum
				int receivedNum = fromClient.readInt();
				System.out.println("RECEIVED from client: "+receivedNum);
				//Square the number
				squared = squareNumber(receivedNum);
				lastNum = squared;
				System.out.println("GET LAST NUM IS: "+getLastNum());
				
				System.out.println("VALUE squared is: "+squared);
				DataOutputStream toClient = new DataOutputStream(receiveSocket.getOutputStream());
				System.out.println("SENDING to client result "+squared);
				toClient.writeInt(squared);
				receiveSocket.close();
				
			}
			catch(SocketTimeoutException t){
				System.out.println("socket timed out");
				timedOut = true;
				break;
				
			}
			catch(IOException e) {
				e.printStackTrace();
				break;
				
			}
		}
	}
	
	public int getLastNum() {
		return lastNum;
	}
	
	public boolean getTimedOut() {
		return timedOut;
	}
	
	
	
	public int squareNumber(int num) {
		return (int) Math.pow(num, 2);
	}
	
	public static void main(String args[]) {
		port=123;
		try {
			Thread serverThread = new server(port);
			serverThread.start();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
