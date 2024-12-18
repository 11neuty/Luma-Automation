@test
Feature: Login
  Scenario: User login by valid data
    Given User open luma website
    When  User click login menu
    And   User fill username as "asdawd@gmail.com" and password as "qf6f7jfQ#.emN5D"
    And   User click login button
    Then  User can login

    Scenario: User login by invalid password
      Given User open luma website
      When  User click login menu
      And   User fill username as "asdawd@gmail.com" and password as "qf6ffQ#.emN5D"
      And   User click login button
      Then  Error validation has appear

    Scenario: User login by unregistered user
      Given User open luma website
      When  User click login menu
      And   User fill username as "ajeng@gmail.com" and password as "qf6f7jfemN5D"
      And   User click login button
      Then  Error validation has appear

    Scenario: User login by invalid email
      Given User open luma website
      When  User click login menu
      And   User fill username as "asdawd" and password as "qf6f7jfQ#.emN5D"
      And   User click login button
      Then  Error email validation has appear