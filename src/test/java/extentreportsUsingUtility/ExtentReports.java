package extentreportsUsingUtility;

import org.testng.SkipException;
import org.testng.annotations.Test;



public class ExtentReports {

	@Test
	public void sampleOne(){
		
		org.testng.Assert.assertTrue(true);
		System.out.println("sampleOne");
		
	}
	
	@Test
	public void sampleTwo(){
		
		System.out.println("sampleTwo");
		
	}
	
	@Test
	public void sampleThree(){
		
		throw new SkipException("Skipping Message Z");
		
	}
	
}
