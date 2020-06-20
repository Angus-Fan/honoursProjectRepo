package CucumberInstallation._CucumberClientServer;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;

public class serverTestExampleGlueCode extends TestCase {
	private server serv;
	private client cli;
	
	
	@Given("The server is on and a client makes a proper connection")
	public void the_server_is_on_and_a_client_makes_a_proper_connection() {
		  try {
				serv = new server(123);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   serv.start();
	}

	@When("The connection is established and the number five is sent")
	public void the_connection_is_established_and_the_number_five_is_sent() {
	    cli = new client(5);
	    cli.run();
	}

	@Then("The server will square five to twenty-five and return it")
	public void the_server_will_square_five_to_twenty_five_and_return_it() {
	  assertEquals(25,serv.squareNumber(5));
	  assertEquals(25,serv.getLastNum());
	  
	}

}
