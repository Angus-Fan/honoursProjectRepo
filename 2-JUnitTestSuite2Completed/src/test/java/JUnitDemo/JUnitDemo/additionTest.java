package JUnitDemo.JUnitDemo;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class additionTest extends TestCase {
	
	@Test
	public void testAddOne() {	
		int x = 1;
		int answer = 2;
		additionClass addClass = new additionClass();
		
		//Create an assertEquals test to check that the addOne function returns the correct answer
		//Call the addOne method from the additionClass in the assertEquals parameter
		//Example:
		//This will initially be incorrect when you run it
		//After running it, check the failure trace to see the expected and gotten results
		//Change the first parameter to pass the correct answer
		assertEquals(answer,addClass.addOne(x));
		
	
	}
		
	@Test
	public void testDoubleAddition() {	
		double x = 5.5;	
		double y = 4.5;		
		double answer = 10.0;
		
		additionClass addClass = new additionClass();
		
		//Create an assertEquals test to check that the addTwoNumbers function returns the correct answer
		//Call the addTwoNumbers method from the additionClass in the assertEquals parameter
		assertEquals(answer,addClass.addTwoNumbers(x,y));
	}
	@Test
	public void testAdditionClassComparison() {
		additionClass addClass = new additionClass();
		additionClass addClass2 = new additionClass();
		ArrayList<additionClass> addClassList = new ArrayList<additionClass>();
		addClassList.add(addClass);
		addClassList.add(addClass2);
		additionClass checkClass = new additionClass();
		
		//Create an assertSame test to check that the two items in the addClassList are indeed the objects that were added
		assertSame(addClass,addClassList.get(0));
		assertSame(addClass2,addClassList.get(1));
		//Create an assertEquals test to check that the length of the addClassList is 2
		assertEquals(2,addClassList.size());
		
	}
	
	
}
