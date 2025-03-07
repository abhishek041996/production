@EmcUiTest
Feature: Api testing Framework

@login
Scenario Outline: login to the account
Given user given the url to launch the dashboard
When user provides the "<userId>" and "<password>" to login
Then user validates the login is successful
And user validates "<username>"
Examples: 
|userId|password|username|
|abhiamilkanthwar96@gmail.com|India@12345|myCompany|




