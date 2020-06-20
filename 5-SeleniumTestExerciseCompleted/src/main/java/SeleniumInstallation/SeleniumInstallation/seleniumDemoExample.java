//change the package to your own eclipse package.
package SeleniumInstallation.SeleniumInstallation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class seleniumDemoExample {
	
	@Test
	public void invalidLogin() {
		
		//Set your driver here
		System.setProperty("webdriver.geckoDriver","[Your Path Here]\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//The objective of this program is to experiment with the basics of selenium
		//We will begin by going to students.carleton.ca
		//This can be done by evoking the fireFoxDrivers .get method and then the string of the website
		//http://students.carleton.ca/
		driver.get("http://students.carleton.ca");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
		
		//Now we will start trying to login with your credentials, you will need to check where
		//to place the information right click the webpage and inspect the webpage to find
		//the location where you input your username and password.
		//use the selenium find element by id and input the information into the correct field
		//The username id is "user", driver.findElement(By,id("user)).sendKeys("yourUserNameHere");
		//We can also create tests to ensure that our application does not crash '💻' this laptop emoji
		//can be used for such tests, placing improper information into fields will allow you to
		//test the robustness of your application.
		driver.findElement(By.id("user")).sendKeys("💻");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Then do the same for the password
		driver.findElement(By.id("pass")).sendKeys("💻");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Then we need to get selenium to press the login button, we can do this by finding the element
		//of the button and then using selenium's click
		//https://www.seleniumhq.org/docs/03_webdriver.jsp
		
		driver.findElement(By.name("login_btn")).click();
		
				
		//Then finally use selenium to logout of the webpage (In the case of the correct login test)
		
		

	}
	@Test
	public void invalidCredentialsLogin() {
		
		//Set your driver here
		System.setProperty("webdriver.geckoDriver","[Your Path Here]\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//The objective of this program is to experiment with the basics of selenium
		//We will begin by going to students.carleton.ca
		//This can be done by evoking the fireFoxDrivers .get method and then the string of the website
		//http://students.carleton.ca/
		driver.get("http://students.carleton.ca");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
		
		//Now we will start trying to login with your credentials, you will need to check where
		//to place the information right click the webpage and inspect the webpage to find
		//the location where you input your username and password.
		//use the selenium find element by id and input the information into the correct field
		//The username id is "user", driver.findElement(By,id("user)).sendKeys("yourUserNameHere");
		//We can also create tests to ensure that our application does not crash '💻' this laptop emoji
		//can be used for such tests, placing improper information into fields will allow you to
		//test the robustness of your application.
		driver.findElement(By.id("user")).sendKeys("exampleName");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Then do the same for the password
		driver.findElement(By.id("pass")).sendKeys("examplePassword");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Then we need to get selenium to press the login button, we can do this by finding the element
		//of the button and then using selenium's click
		//https://www.seleniumhq.org/docs/03_webdriver.jsp
		
		driver.findElement(By.name("login_btn")).click();
		
				
		//Then finally use selenium to logout of the webpage (In the case of the correct login test)
		
		

	}
	
	@Test
	public void validLogin() {
		
		//Set your driver here
		System.setProperty("webdriver.geckoDriver","[Your Path Here]\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//The objective of this program is to experiment with the basics of selenium
		//We will begin by going to students.carleton.ca
		//This can be done by evoking the fireFoxDrivers .get method and then the string of the website
		//http://students.carleton.ca/
		driver.get("http://students.carleton.ca");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
		
		//Now we will start trying to login with your credentials, you will need to check where
		//to place the information right click the webpage and inspect the webpage to find
		//the location where you input your username and password.
		//use the selenium find element by id and input the information into the correct field
		//The username id is "user", driver.findElement(By,id("user)).sendKeys("yourUserNameHere");
		//We can also create tests to ensure that our application does not crash '💻' this laptop emoji
		//can be used for such tests, placing improper information into fields will allow you to
		//test the robustness of your application.
		driver.findElement(By.id("user")).sendKeys("Your Name");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Then do the same for the password
		driver.findElement(By.id("pass")).sendKeys("Your Pass");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Then we need to get selenium to press the login button, we can do this by finding the element
		//of the button and then using selenium's click
		//https://www.seleniumhq.org/docs/03_webdriver.jsp
		
		driver.findElement(By.name("login_btn")).click();
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
		//Then finally use selenium to logout of the webpage (In the case of the correct login test)
		
		driver.findElement(By.name("ee")).click();

	}
	
	

}
