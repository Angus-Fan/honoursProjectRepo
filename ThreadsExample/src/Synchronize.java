import java.util.ArrayList;

public class Synchronize extends Thread {
	public int threadNumber;
	public boolean hasItem;
	public Item heldItem;
	public boolean heldAnItem;
	public ArrayList<Item> boxOfItems;
	
	
	public Synchronize(int num,ArrayList box) {
		hasItem = false;
		threadNumber = num;
		boxOfItems=box;
	}
	
	
	
	public void getItem() {	
		synchronized(boxOfItems) {
			if(boxOfItems.isEmpty()) {
				try {
					System.out.println("T["+threadNumber+"]["+heldAnItem+"] WAITING");
					boxOfItems.wait();
					System.out.println("T["+threadNumber+"]["+heldAnItem+"] RESUMED");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				heldItem = boxOfItems.remove(0);
				hasItem=true;
				System.out.println("T["+threadNumber+"]["+heldAnItem+"] RETRIEVED ITEM");
			}
		}
		
		
	}
	
	public void putItem() {	
		synchronized(boxOfItems) {
			if(boxOfItems.size()<3) {
				boxOfItems.add(heldItem);
				heldItem = null;
				hasItem=false;
				System.out.println("T["+threadNumber+"]["+heldAnItem+"] RETURNED ITEM");
				boxOfItems.notifyAll();//notify()
			}
			
		}
		
		
	}
	
	public void useItem() {
		 try {
			 System.out.println("T["+threadNumber+"]["+heldAnItem+"] USING ITEM");
			Thread.sleep(20000);
			heldAnItem=true;
			 System.out.println("T["+threadNumber+"]["+heldAnItem+"] FINISHED ITEM");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		while(true) {
			getItem();
			useItem();
			putItem();
		}
	}
	
	
	public static void main(String args[]) {
		ArrayList<Item> box = new ArrayList<Item>();
		ArrayList<Synchronize> listOfThreads = new ArrayList<Synchronize>();
		
		
		
		for(int i =0;i<3;i++) {
			box.add( new Item("ITEM: "+i));
		}
		
		for(int i =0;i<10;i++) {
			Synchronize itemThread = new Synchronize(i,box);
			listOfThreads.add(itemThread);	
			
		}
		
		for(int i =0;i<10;i++) {
			listOfThreads.get(i).start();
				
			
		}
		
	}
	
	
}
