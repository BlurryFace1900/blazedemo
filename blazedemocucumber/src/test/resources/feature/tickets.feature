#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Booking
Feature: To test Ticket Booking Functionality

  @BookTicket
  Scenario Outline: Book Ticket from <from> to <to>
    Given Launch <browser> Browser
    When Navigate to Website
    Then Choose from Destination as <from>
    And Choose to Destination as <to>
    Then Click Submit
    Then Choose Cheapest Airline
    Then Verify Total Amount
    And Click Purchase
    Then Verify Comfirmation URL
    Then Save ID

    Examples: 
      | from        |     to     | browser  |
      | Mexico City |     London | Chrome   |
      #| name2 |     7 | Fail    |
