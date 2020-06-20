import java.util.ArrayList;

public class ThreadExample extends Thread {
	public int threadNumber;
	
	public boolean hasItem;
	public Item heldItem;
	
	public ArrayList<Item> boxOfItems;
	
	
	public ThreadExample(int num,ArrayList box) {
		hasItem = false;
		threadNumber = num;
		boxOfItems=box;
	}
	
	
	
	public  void getItem() {
		System.out.println("T["+threadNumber+"] has determined that there is an item to grab");		
		
		heldItem = boxOfItems.remove(0);
		hasItem = true;
		
		System.out.println("T["+threadNumber+"] OBTAINED ITEM: "+heldItem);	
		System.out.println("ITEMS LEFT ARE: "+boxOfItems);	
		
		
		
	}	
	
	
	public void run() {
		System.out.println("T["+threadNumber+"] has started");	
		
		
		
		while(true) {
			System.out.println("T["+threadNumber+"] has access to: "+boxOfItems);
		
			if(!boxOfItems.isEmpty()) {
			
				getItem();	
				break;
				
				
			}
			else {
				System.out.println("T["+threadNumber+"] NO ITEMS LEFT, TERMINATING");
				break;
			}
		
		}
	}
	
	
	public static void main(String args[]) {
		ArrayList<Item> box = new ArrayList<Item>();
		ArrayList<ThreadExample> listOfThreads = new ArrayList<ThreadExample>();
		
		
		
		for(int i =0;i<3;i++) {
			box.add( new Item("ITEM: "+i));
		}
		
		for(int i =0;i<4;i++) {
			ThreadExample itemThread = new ThreadExample(i,box);
			listOfThreads.add(itemThread);	
			
		}
		
		for(int i =0;i<4;i++) {
			listOfThreads.get(i).start();
				
			
		}
		
	}
	
	
}
