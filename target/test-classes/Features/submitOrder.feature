#Author: twarita.choudhury93@gmail.com
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
@Regression
Feature: Submitting Order
  Submitting different orders

  Background: 
    Given I am on landing page of an ecommerce website

  @Sanity @PlacingOrder
  Scenario Outline: Positive Scenarios for submitting order
    Given I login with username <username> and password <password>
    When I add product <productName> to cart
    And I go to Cart Page and verify product <productName> added to cart
    And I click on Submit Order with country name <countryName>
    Then "Thankyou for the order." success message displayed on order confirmation page

    Examples: 
      | username        | password   | productName | countryName |
      | testT@mail.com  | Password1! | Zara Coat   | India       |
      | testTC@mail.com | Password1! | Adidas      | Australia   |

  @OrderVerification
  Scenario Outline: Verify order placed
    Given I login with username <username> and password <password>
    When I go to Orders page
    Then Verify <productName> displayed in orders table

    Examples: 
      | username       | password   | productName | 
      | testT@mail.com | Password1! | Zara Coat   | 