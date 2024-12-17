@Regression
Feature: Error validations
  I want to use this template for validating different errors

  @LoginError
  Scenario Outline: Login error validation
    Given I am on landing page of an ecommerce website
    When I login with username <username> and password <password>
    Then "Incorrect email or password." error message displayed on login page
 
 Examples:   
    | username       | password   |
    | testT@mail.co  | Password1! |
    | testT@mail.com | Passwrd1!  |

  @AddProductFailure
  Scenario Outline: No product gets add if the product is not available in the website
    Given I am on landing page of an ecommerce website
    When I login with username <username> and password <password>
    Then On adding <productName> product no product gets added

    Examples: 
    | username        | password   | productName        |
    | testT@mail.com  | Password1! | invalidProductName |
