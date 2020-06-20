Feature: client test feature
	I want to use this template for my client file
	
	@tag1
	Scenario: client test with valid number
		Given The server is online
		When The client sends the number five to the server
		Then The client receives the squared number twenty-five from the server
		
@tag2
	Scenario: client test with invalid number
		Given The server is online
		When The client sends the invalid number to the server
		Then The client receives zero from the server
		