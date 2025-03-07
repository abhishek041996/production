package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.uiCases;

public class stepsEmcUi {
	int statusCode;
	uiCases login=new uiCases();
	@Given ("user given the url to launch the dashboard")
	public void launch_dashboard() {
		//login.launch();
	}
	@When ("user provides the {string} and {string} to login")
	public void login_to_dashboard() {
		
	}
	@Then ("user validates the login is successful")
	public void validate_the_dashboard_header() {
		
	}
	@And ("user validates {string}")
	public void validate_username(){
		
	}


}
