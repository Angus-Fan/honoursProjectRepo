package CucumberInstallation._CucumberClientServer;
//Change the package
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;




public class client extends Thread {
	private int testNum;
	private int result;
	//Check your ipv4 and set address to it
	//in windows -> windows -> cmd -> ipconfig -> ipv4
	private String address = "change ipv4 here";
	
	
	public client(int x) {
		testNum=x;
	}
	public void run() {
		
		if(intSizeCheck(testNum)) {
			try {
				int userNum = testNum;
				Socket clientSock = new Socket(address,123);
				OutputStream toServer =clientSock.getOutputStream();
				DataOutputStream outToServer = new DataOutputStream(toServer);
				outToServer.writeInt(userNum);
				System.out.println("TO server number: "+ userNum);
				
				InputStream fromServer = clientSock.getInputStream();
				DataInputStream inFromServer = new DataInputStream(fromServer);
				setResult(inFromServer.readInt());
				System.out.println("FROM server, square of the number is "+result);
				testNum = result;
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("NO CONNECTION, shutting down");
			} 
		}
		else {
			System.out.println("The number entered is too large for the system, exiting");
		}
	}
	//If you square 46341 then its too large for int 
	public boolean intSizeCheck(int x) {
		if(x>46340 || x<-46340) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void setNum(int x){
		testNum = x;
	}
	public int getNum() {
		return testNum;
	}
	public void setResult(int x) {
		result = x;
	}
	
	public int getResult() {
		return result;
	}
	
	
	public static void main(String args[]) {		
		Thread client = new client(12);
		client.run();
		
	}
}
