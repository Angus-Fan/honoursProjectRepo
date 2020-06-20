package JUnitDemo.JUnitDemo;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class additionalClassTest extends TestCase {
	
	
public void testMult() {
	additionalClassForTestSuite acft = new additionalClassForTestSuite();
	int x = 5;
	int answer = 25;
	assertEquals(answer,acft.square(x));
}

	
}
