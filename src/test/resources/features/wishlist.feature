@test
Feature: wishlist
  Scenario: Add item to wishlist while not login
    Given User open luma website
    When  User click login menu
    And   User fill username as "asdawd@gmail.com" and password as "qf6f7jfQ#.emN5D"
    And   User click login button
    Then  User can login
    When  User choose item
    And   User click add to wishlist
    Then  Item shown on my wishlist

