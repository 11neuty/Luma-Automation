@test
Feature: Onboarding
  #ganti email terlebih dahulu
  Scenario: Create new user by valid data
    Given User open luma website
    When  User click Create an account
    Then  Redirect to onboarding page
<<<<<<< HEAD
    When  Fill form data firstname as "luki" lastname as "hermawan" email as "lukifhrma1022883@gmail.com" password as "Ardian08!" confirm pass as "Ardian08!"
=======
    When  Fill form data firstname as "luki" lastname as "hermawaan" email as "lukiifhrma1322883@gmail.com" password as "Ardian08!" confirm pass as "Ardian08!"
>>>>>>> 02dc93e63b9d84119414d174480605f01fb74bbe
    Then  User can see "Thank you for registering with Main Website Store."