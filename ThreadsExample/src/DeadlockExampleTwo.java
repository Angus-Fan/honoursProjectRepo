
public class DeadlockExampleTwo {
	
	
		public static class NumberHolder{
			public int number;
			public String numberHolderName;
			NumberHolder(int n,String name){
				number=n;
				numberHolderName=name;
			}
			
			public void setNum(int n) {
				number=n;
			}
		}
	
		public static class ThreadUser extends Thread {
			private NumberHolder a;
			private NumberHolder b;
			private String threadName;
			
			public ThreadUser(String name, NumberHolder nh1,NumberHolder nh2) {
				threadName=name;
				a=nh1;
				b=nh2;
			}
			
			public void run() {
				System.out.println("Thread:"+threadName+" has been accessed");
				synchronized(a){
					//Comment this out to remove deadlock
					/*
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					synchronized(b){
						int answer = a.number+b.number;
						a.setNum(answer);
						b.setNum(answer);
						System.out.println("NumberHolder:"+a.numberHolderName+" has value:"+a.number);
						System.out.println("NumberHolder:"+b.numberHolderName+" has value:"+b.number);
					}
				}
				
				System.out.println("Thread:"+threadName+" has been terminated");
			}
			
		}
		
		
		public static void main(String args[]) {
			NumberHolder nh1 = new NumberHolder(1,"NumHolderOne");
			NumberHolder nh2 = new NumberHolder(1,"NumHolderTwo");
			
			ThreadUser t1 = new ThreadUser("THREAD1",nh1,nh2);
			ThreadUser t2 = new ThreadUser("THREAD2",nh2,nh1);
			ThreadUser t3 = new ThreadUser("THREAD3",nh1,nh2);
			ThreadUser t4 = new ThreadUser("THREAD4",nh2,nh1);
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			
			
		}
}
