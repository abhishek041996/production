package steps;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;

import Apis.authorization;
import Apis.botGraphData;
import Apis.createOrganizationAPI;
import Apis.createSupportTicket;
import Apis.daywiseBotData;
import Apis.daywiseBotsConsumptionData;
import Apis.getCurrentMonthBotConsumption;
import Apis.getCurrentUser;
import Apis.getSensorById;
import Apis.getSupportTickets;
import Apis.getUnreadAlerts;
import Apis.listAllTagsByOrgId;
import Apis.loginAPI;
import Apis.markAlertStatus;
import Apis.organizationAPI;
import Apis.resetPassword;
import Apis.sendOtpAPI;
import Apis.sendPasswordResetLinkAPI;
import Apis.topConsumers;
import Apis.totalGraphData;
import Apis.totalOrganizationLivePowerAPI;
import Apis.totalsOnDashboardAPI;
import Apis.updateCurrentUser;
import Apis.updateOrganizationById;
import Apis.updateSensorById;
import Apis.verifyAndSignUpAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsEmcApi {
	int statusCode;
	organizationAPI org=new organizationAPI();
	totalGraphData graph=new totalGraphData();
	botGraphData gr=new botGraphData();
	totalsOnDashboardAPI total=new totalsOnDashboardAPI();
	totalOrganizationLivePowerAPI power=new totalOrganizationLivePowerAPI();
    String organizationId=organizationAPI.organizationId;
	getCurrentMonthBotConsumption month= new getCurrentMonthBotConsumption();
	daywiseBotData rt=new daywiseBotData();
	topConsumers top=new topConsumers();
	daywiseBotsConsumptionData dy=new daywiseBotsConsumptionData();
	getCurrentUser get=new getCurrentUser();
	updateCurrentUser user=new updateCurrentUser();
	listAllTagsByOrgId tg=new listAllTagsByOrgId();
	updateOrganizationById update=new updateOrganizationById();
	getUnreadAlerts alert=new getUnreadAlerts();
	markAlertStatus mark=new markAlertStatus();
	sendOtpAPI send=new sendOtpAPI();
	verifyAndSignUpAPI verify=new verifyAndSignUpAPI();
	sendPasswordResetLinkAPI reset=new sendPasswordResetLinkAPI();
	authorization token= new authorization();
	loginAPI login=new loginAPI();
	getSensorById bot=new getSensorById();
	updateSensorById name=new updateSensorById();
	resetPassword resetpass=new resetPassword();
	createOrganizationAPI create=new createOrganizationAPI();
	createSupportTicket createticket=new createSupportTicket();
	getSupportTickets getTicket=new getSupportTickets();

	

	@Given ("the api to get the login details with {string} and {string}")
	public void get_login_details(String username,String password) throws JsonProcessingException {
		 statusCode = login.test(username,password);
	}
	@Given ("the api to get the access token")
	public void get_access_token() {
		 statusCode = token.test();
	}
	
	@Given("the api to get the organisation id")
	public void the_api_to_get_the_organisation_id() {
		 statusCode = org.test();
	}
	
	@Then ("validate the response code {string}")
	public void user_validates(String statuscode) {
		assertEquals(Integer.parseInt(statuscode),statusCode);
	}
	@Given("the api to get total organization live power")
	public void  get_organization_power() {
		 statusCode= power.test(organizationId);
		
	}
	@Given ("the api to get total bots and the energy consumption")
	public void get_total_bots_and_organisation_power() {
		 statusCode= total.test(organizationId);
	}
	@Given ("the api to get graph data for {string} for  the particular {string}")
	public void  get_graph_data(String param,String timeFilter) {
		 statusCode=graph.test(param,timeFilter);
	}
	@Given ("the api to get individual bot graph data for {string} for  the particular {string}")
    public void get_individual_bot_graph_data(String param1,String timeFilter1) {
	     statusCode=gr.test(param1,timeFilter1);
		 }
	@Given ("the api to get current month consumption for a {string}")
    public void get_current_month_consumption(String botId){
		 statusCode=month.test(botId);
			}

	@Given ("the api to get day wise data for {string} from {string} to {string}")
    public void get_real_time_data(String botId,String startDate,String endDate) {
		 statusCode=rt.test(botId,startDate,endDate);
	}
    @Given ("the api to get top three consumers")
    public void get_top_three_consumers() {
    	 statusCode=top.test();
    }
    @Given ("the api to get day wise all bots data from {string} to {string}")
    public void get_daywise_data_for_all_bots(String date1,String date2) {
     	 statusCode=dy.test(date1,date2);
    }
    @Given ("the api to get user details")
    public void get_user_details(){
    	statusCode=get.test();
    }
    @Given ("the api to update the user details to {string}")
    public void update_user_details(String name) {
    	statusCode=user.test(name);

       }
    @Given ("the api to get list of tags")
    public void get_list_of_tags() {
    	statusCode=tg.test();

    }
    @Given ("the api to update organization details as {string} and {string}")
    public void update_organization_details(String city,String name) {
    	statusCode=update.test(name, city);
    }
    @Given ("the api to get unread alerts")
    public void get_unread_alerts() {
    	statusCode=alert.test();

    }
    @Given ("the api to mark alert to read status")
    public void mark_alert_to_read_status() {
    	statusCode=mark.test();

    }
    @Given ("the api to send OTP to {string}")
    public void send_otp(String emailId) {
    	statusCode=send.test(emailId);
    }
    @Given ("the api to verify {string} an signUp")
    public void verify_signUp(String emailId) {
    	statusCode=verify.test(emailId);
    }
    @Given ("the api to send rest password link to {string}")
    public void send_reset_password_link(String emailId) {
    	statusCode=reset.test(emailId);
    }
    @Given ("the api to get the details of the {string}")
    public void get_the_details(String botId) {
    	statusCode=bot.test(botId);
    }
    @Given ("the api to update the {string} of the {string}")
    public void update_nickname(String newNickName,String botId ) {
    	statusCode=name.test(newNickName,botId);
    
    }
    @Given ("user extracts the otp from the link sent and set up new password")
    public void set_up_new_password() {
    	statusCode=resetpass.test();
    }
    @Given ("the api to create the organization with {string} and {string}")
    public void create_new_organization(String companyName,String gstNumber) throws JsonProcessingException {
    	statusCode=create.test(companyName,gstNumber);
    }
    @Given ("the api to create the ticket")
    public void create_the_ticket() {
    	statusCode=createticket.test();
    }
    @Given  ("the api to get the ticket status")
    public void get_ticket_status() {
    	statusCode=getTicket.test();
    }
    @Given ("the api to get the total bots")
    public void get_all_bots_of_organization() {
    	statusCode=getTicket.test();
    }

}
