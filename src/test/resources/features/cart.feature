@cart
Feature: Add To Cart
  Scenario: Add to cart item while not login
    Given User open luma website
    When  User add to cart item
    And   User check cart
    Then  Added item shown

  Scenario: Add to cart item by search item
    Given User open luma website
    When  User search item "Radiant Tee"
    Then  Search result has shown "Radiant T"

