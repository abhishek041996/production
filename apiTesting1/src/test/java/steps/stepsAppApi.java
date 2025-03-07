package steps;

import appApi.common;
import appApi.energyConsumptionAPI;
import appApi.getCurrentUserAPI;
import appApi.updateUserDataAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsAppApi {
	getCurrentUserAPI currentUser=new getCurrentUserAPI();
	updateUserDataAPI updateuserdata=new updateUserDataAPI();
	common com=new common();
	energyConsumptionAPI energy=new energyConsumptionAPI();
	@Given ("user given with the {string} to fetch the details")
	public void user(String botId){
		energy.getConsumption(botId);
	    }
	@Given("user given the api to get the account details")
	public void user_given_the_api_to_get_the_account_details() {
		currentUser.getDetails();
		}
	@Then("user validates thek {string}")
	public void user_validates(String statusCode) {
		currentUser.verifyStatusCode(Integer.parseInt(statusCode));
	    }
	@And("user validates {string} and {string} and {string} and {string} and {string}")
	public void user_validates_all_the_details_from_the_api(String mobileNumber,String accountName,String activeStatus,String emailId,String accountCreationDate) {
		currentUser.validate(mobileNumber,accountName,activeStatus,emailId,accountCreationDate);
		}
	@When ("user updates the name to {string} and emailid to {string}")
	public void user_updates_the_name_emailId(String name,String emailId) {
		updateuserdata.update(name,emailId);
	    }
	@Then ("user validates the response {string}")
	public void user_validates_the_response(String statusCode) {
		updateuserdata.validateStatusCode(Integer.parseInt(statusCode));
		}
	
	@And("user validates the updated {string} and {string} from response")
	public void user_validates_response(String name,String emailId) {
		updateuserdata.validateDataResponse(name,emailId);
		}
	@And("user validates updated {string} and {string} in the profile details")
	public void  validates_updated_details_in_profile(String name,String emailId) {
		currentUser.validateUpdatedDetails(name,emailId);
		}
	@Given ("the api to get the account details")
	public void get_the_account_details() {
		com.getAccountDetails();
	}
	@Then ("validate the {string}")
	public void user_validates1(String code) {
		com.val(Integer.parseInt(code));
	}
	@Given ("the api to get appliance usage logs")
	public void user_given_the_api_to_get_appliance_usage_logs() {
		com.applianceUsageAPI();
	}
	@Given("the api to get energy consumption in a month")
       public void get_energy_consumptipon() {
		com.getEnergyConsumptionAPI();
	}
	@Given ("the api to get the details of the bot")
	public void get_bot_details() {
		com.getDetailsAPI();	
	}
	@Given ("the api to get daywise energy consumption")
	public void get_dayWise_energy_consumption() {
		com.getDaywiseConsumptionAPI();
	}
	@Given ("the api to get daywise uptime")
	public void get_dayWise_up_time() {
		com.gatDaywiseAPI();
	}
	@Given ("the api to get total number of appliance for the bot")
    public void get_total_number_of_appliances() {
		com.getTotalAppliancesAPI();
	}
	@Given ("the api to get the service history for the applaince")
    public void get_sefrvice_history() {
		com.getServiceHistoryAPI();
	}
	@Given ("the api to get the appliance usage for a particular day")
    public void get_Appliance_usage_for_a_particular_day() {
		com.gatApplianceUsageForDayAPI();
	}
	@Given ("the api to get the total number of utilities available")
    public void get_total_utilities() {
		com.getTotalUtilitiesAPI();
	}
	@Given ("the api to get the subscription plans")
    public void get_plans() {
		com.getSubscriptionPlansAPI();
	}
	@Given ("the api to get the current subscription plans")
    public void get_currentplan() {
		com.getCurrentSubscriptionAPI();
	}
	@Given ("the api to get the energy statement")
	public void get_energy_statement() {
		com.getStatement();
	}
	@Given("the api to update the bot details")
	public void update_bot_details() {
		com.update();
	}
	@Given ("the api to update the user details")
	public void update_the_user_details() {
		com.updateDetails();
	}
	
	
	

}
