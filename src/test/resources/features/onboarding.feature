@test
Feature: Onboarding
  #ganti email terlebih dahulu
  Scenario: Create new user by valid data
    Given User open luma website
    When  User click Create an account
    Then  Redirect to onboarding page
    When  Fill form data firstname as "luki" lastname as "hermawan" email as "lukifhrma1022883@gmail.com" password as "Ardian08!" confirm pass as "Ardian08!"
    Then  User can see "Thank you for registering with Main Website Store."