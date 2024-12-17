Feature: Onboarding
  Scenario: Create new user by valid data
    Given User open luma website
    When  User click Create an account
    Then  Redirect to onboarding page
    When  Fill form data firstname as "asd" lastname as "sad" email as "sad" password as "asd" confirm pass as "asda"
    And   User click Create an account
    Then  User can see "Thank you for registering with Main Website Store"