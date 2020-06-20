
public class SimpleThread {

	
	public static class SingleThread extends Thread {		
		public void run() {
			System.out.println("I am a running thread");
		}
	}
	
	
	public static void main (String args[]) {
		SingleThread st =  new SingleThread();
		SingleThread st2 =  new SingleThread();
		st2.start();
		st.start();
	}
}
