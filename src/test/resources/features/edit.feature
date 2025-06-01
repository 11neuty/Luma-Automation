@test
  Feature: edit
    Scenario: Delete wishlist item by login item
      Given User click login menu
      When  User fill username as "asdawd@gmail.com" and password as "qf6f7jfQ#.emN5D"
      And   User click login button
      Then  User can login
      When  User click menu account
      And   User click my wishlist
      And   User delete wishlist item