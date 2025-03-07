@EmcTest
Feature: Api testing Framework[EMC]

@sendOTP
Scenario Outline: Send OTP to emailId
Given the api to send OTP to "<emailId>"
Then  validate the response code "<statusCode>"
Examples:
|emailId|statusCode|
|abhiamilkanthwar96@gmail.com|200|

@login
Scenario Outline: get the refresh Token
Given the api to get the login details with "<username>" and "<password>"
Then  validate the response code "<statusCode>"
Examples: 
|username|password|statusCode|
|ashish.taldeokar@sustlabs.com|India@12345|200|

@RefreshAPIToken
Scenario Outline: get the accesstoken
Given the api to get the access token
Then  validate the response code "<statusCode>"
Examples: 
|statusCode|
|200|

@getCurrentOrganization
Scenario Outline: get organisation id
Given the api to get the organisation id
Then  validate the response code "<statusCode>"
Examples: 
|statusCode|
|200|

@getCurrentMonthBotConsumption
Scenario Outline: get current month consumption 
Given the api to get current month consumption for a "<botId>" 
Then  validate the response code "<statusCode>"
Examples:
|botId|statusCode|
|5696|200|

@totalOrganisationLivePower
Scenario Outline: get total organization live power
Given the api to get total organization live power
Then  validate the response code "<statusCode>"
Examples: 
|statusCode|
|200|

@totalsOnDashboard
Scenario Outline: get total bot data and energy consumption
Given the api to get graph data for "<param>" for  the particular "<timeFilter>" 
Then  validate the response code "<statusCode>"
Examples: 
|statusCode|
|200|

@totalGraphData
Scenario Outline: get total graph data
Given the api to get graph data for "<param>" for  the particular "<timeFilter>" 
Then  validate the response code "<statusCode>"
Examples: 
|statusCode|param|timeFilter|
|200|e|1d|
|200|e|1w|
|200|e|1m|
|200|e|1y|
|200|a|1d|
|200|a|1w|
|200|a|1m|
|200|a|1y|
|200|v|1d|
|200|v|1w|
|200|v|1m|
|200|v|1y|

@botGraphData
Scenario Outline: get individual  graph data
Given the api to get individual bot graph data for "<param>" for  the particular "<timeFilter>" 
Then  validate the response code "<statusCode>"
Examples: 
|statusCode|param|timeFilter|
|200|e|1d|
|200|e|1w|
|200|e|1m|
|200|e|1y|
|200|a|1d|
|200|a|1w|
|200|a|1m|
|200|a|1y|
|200|v|1d|
|200|v|1w|
|200|v|1m|
|200|v|1y|

@daywiseBotsConsumptionData
Scenario Outline: get day wise all bots data
Given the api to get day wise all bots data from "<date1>" to "<date2>"
Then  validate the response code "<statusCode>"
Examples:
|statusCode|date1|date2|
|200|2024/03/01|2024/03/20|

@topConsumers
Scenario Outline: get top three consumers
Given the api to get top three consumers
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|


@getUnreadAlerts
Scenario Outline: get all the unread alerts
Given the api to get unread alerts
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|

@markAlertStatus
Scenario Outline: mark the alert as read
Given the api to mark alert to read status
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|


@daywiseBotData
Scenario Outline: get day wise bot data
Given the api to get day wise data for "<botId>" from "<date1>" to "<date2>"
Then  validate the response code "<statusCode>"
Examples:
|botId|statusCode|date1|date2|
|5696|200|20240301|20240320|

@getCurrentMonthBotConsumption
Scenario Outline: get current month consumption 
Given the api to get current month consumption for a "<botId>" 
Then  validate the response code "<statusCode>"
Examples:
|botId|statusCode|
|5696|200|

@getCurrentUser
Scenario Outline: get details of the user
Given the api to get user details
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|

@updateCurrentUser
Scenario Outline: update the user details
Given the api to update the user details to "<newName>"
Then  validate the response code "<statusCode>"
Examples:
|statusCode|newName|
|200|Atul|

@getSensorById
Scenario Outline: get the bot details
Given the api to get the details of the "<bot>"
Then  validate the response code "<statusCode>"
Examples:
|bot|statusCode|
|5054|200|

@listAllSensorsByOrgId
Scenario Outline: get the total bots of organization
Given the api to get the total bots
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|

@listAllTagsByOrgId
Scenario Outline: get tag list
Given the api to get list of tags
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|

@updateSensorById
Scenario Outline: update the sensor bot details
Given the api to update the "<nickname>" of the "<bot>"
Then  validate the response code "<statusCode>"
Examples:
|nickname|bot|statusCode|
|141422335|5054|200|

@createSupportTicket
Scenario Outline: create support ticket
Given  the api to create the ticket
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|

@getSupportTickets
Scenario Outline: get the ticket status
Given the api to get the ticket status
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|

@updateOrganizationById
Scenario Outline: update organization details
Given the api to update organization details as "<city>" and "<name>"
Then  validate the response code "<statusCode>"
Examples:
|statusCode|city|name|
|200|Mumbai|aaaa|

@verifyAndSignUp
Scenario Outline: verify  email and signup successfully
Given the api to verify "<emailId>" an signUp
Then  validate the response code "<statusCode>"
Examples:
|emailId|statusCode|
|abhiamilkanthwar96@gmail.com|200|
@sendPasswordResetLink
Scenario Outline: send the reset password link to the registered emailId
Given the api to send rest password link to "<emailId>"
Then  validate the response code "<statusCode>"
Examples:
|emailId|statusCode|
|abhiamilkanthwar96@gmail.com|200|

@createOrganization
Scenario Outline: create a new organization
Given the api to create the organization with "<companyName>" and "<gstNumber>"
Then  validate the response code "<statusCode>"
Examples:
|companyName|gstNumber|statusCode|
|myCompany1|22AAAAA0000A1Z5|200|

@resetPassword
Scenario Outline: reset the password
Given  user extracts the otp from the link sent and set up new password
Then  validate the response code "<statusCode>"
Examples:
|statusCode|
|200|

#@WebSocketConnection
#Scenario Outline: reset the password
#Given user given the url to launch the dashboard
#When user provides the {string} and {string} to login
#Then user validates the login is successful