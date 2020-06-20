
public class threadSequence extends Thread {
	
	public int threadNum;

	public threadSequence(int n){
		threadNum=n;
	}
	public void run() {
		System.out.println("Thread "+threadNum+":Line 1");
		
		System.out.println("Thread "+threadNum+":Line 2");
		
		//System.out.println("Thread "+threadNum+":Line 3");
	}
	
	public static void main(String args[]) {
		threadSequence t1 = new threadSequence(1);
		threadSequence t2 = new threadSequence(2);
		threadSequence t3 = new threadSequence(3);
		t1.start();
		t2.start();
		t3.start();
	}
}
