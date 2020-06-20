package CucumberInstallation._CucumberClientServer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;

public class clientServerGlueCode extends TestCase{

	private client cli;
	@Given("The server is online")
	public void the_server_is_online() {
	    //Some logic that turns on the server (thread.start() works)
	}

	@When("The client sends the number five to the server")
	public void the_client_sends_the_number_five_to_the_server() {
	   cli = new client(5);
	   cli.run();
	}

	@Then("The client receives the squared number twenty-five from the server")
	public void the_client_receives_the_squared_number_twenty_five_from_the_server() {
	   assertEquals(25,cli.getResult());
	}
	
	@When("The client sends the invalid number to the server")
	public void the_client_sends_the_invalid_number_to_the_server() {
		 cli = new client(46341);
		 cli.run();
	}

	@Then("The client receives zero from the server")
	public void the_client_receives_zero_from_the_server() {
		 assertEquals(0,cli.getResult());
	}

}
