Feature: ProductDetails

  Scenario: Validate User navigates onto ProductList page
    Given Chrome is opened and Asianpaints app is opened
    When User searches the product
    And User clicks on the product
    Then User navigates onto the ProductList page

  Scenario: Validate ProductDetails page UI
    Given Chrome is opened and Asianpaints app is opened
    When User searches the product
    And User clicks on the product
    Then User navigates onto the ProductList page
    And User clicks on any listed item
    Then ProductDetails page is launched and fields are visible to the user

  Scenario: Validate quantity field on ProductDetails page
    Given Chrome is opened and Asianpaints app is opened
    When User searches the product
    And User clicks on the product
    Then User navigates onto the ProductList page
    And User clicks on any listed item
    Then ProductDetails page is launched and fields are visible to the user
    When User changes the quantity of the product
    Then Application selects the correct quantity
