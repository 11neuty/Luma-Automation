@wish
Feature: cart
  Scenario: Add to cart item while not login
    Given User open luma website
    When  User add to cart item
    And   User check cart
    Then  Added item shown

  Scenario: Add to cart item by search item while not login
    Given User open luma website
    When  User search item "Radiant Tee"
    Then  Search result has shown "Radiant T"

  Scenario: Add to cart while login
    Given User open luma website
    When  User click login menu
    And   User fill username as "asdawd@gmail.com" and password as "qf6f7jfQ#.emN5D"
    And   User click login button
    Then  User can login
    When  User add to cart item
    And   User check cart
    Then  Added item shown
