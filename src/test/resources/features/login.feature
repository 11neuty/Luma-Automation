@test
Feature: Login
  Scenario: User login by valid data
    Given User open luma website
    When  User click login menu
    And   User fill username as "asdawd@gmail.com" and password as "qf6f7jfQ#.emN5D"
    And   User click login button
    Then  User can login