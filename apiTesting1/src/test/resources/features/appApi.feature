@appApitest
Feature: Api testing Framework


@getCurrentUser
Scenario Outline: get details of the user
Given the api to get the account details
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getApplianceUsageLogs
Scenario Outline: get the appliance usage logs
Given the api to get appliance usage logs
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getEnergyConsumptionMonth
Scenario Outline: get energy consumption in a month
Given the api to get energy consumption in a month
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getBotInfo
Scenario Outline: get the details of the bot
Given the api to get the details of the bot
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getDayWiseEnergyConsumption
Scenario Outline: get daywise energy consumption
Given the api to get daywise energy consumption
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getDaywiseUptime
Scenario Outline: get daywise uptime
Given the api to get daywise uptime
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@fetchApplianceCountsByMeterId
Scenario Outline: get total number of appliance for the bot
Given the api to get total number of appliance for the bot
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getServiceHistory
Scenario Outline: Get the service history for the applaince
Given the api to get the service history for the applaince
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getBreakDownV2
Scenario Outline: get the appliance usage for a particular day
Given the api to get the appliance usage for a particular day
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getStateWiseUtility
Scenario Outline: get the total number of utilities available
Given the api to get the total number of utilities available
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@getSubscriptionPlans
Scenario Outline: get the subscription plans
Given the api to get the subscription plans
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@currentSubscription
Scenario Outline: get the current subscription plan 
Given the api to get the current subscription plans
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|

@requestStatement
Scenario Outline: get the energy statement for the particular period 
Given the api to get the energy statement
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|
@updateBotInfo
Scenario Outline: update the utility details for the bot
Given the api to update the bot details
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|
@UpdateUserData
Scenario Outline: update the user information
Given the api to update the user details
Then  validate the "<statusCode>"
Examples: 
|statusCode|
|200|



