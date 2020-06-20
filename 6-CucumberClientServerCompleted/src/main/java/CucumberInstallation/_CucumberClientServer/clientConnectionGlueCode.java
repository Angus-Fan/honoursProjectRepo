package CucumberInstallation._CucumberClientServer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;

public class clientConnectionGlueCode extends TestCase {
	private client cli;
	@Given("the server is offline")
	public void the_server_is_offline() {
	    //Some logic to turn the server off if its on
		//Check if server is off
	}

	@When("the client attempts to make a connection")
	public void the_client_attempts_to_make_a_connection() {
	   cli = new client(5);
	   cli.run();
	}

	@Then("the client fails to connect gracefully")
	public void the_client_fails_to_connect_gracefully() {
		assertEquals(0,cli.getResult());
	}
}
