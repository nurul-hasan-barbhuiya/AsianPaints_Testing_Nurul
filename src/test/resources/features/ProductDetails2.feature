Feature: ProductDetails

  Scenario Outline: Verify Pincode functionality with valid data
    Given Chrome is opened and Asianpaints app is opened
    When User searches the product
    And User clicks on the product
    Then User navigates onto the ProductList page
    And User clicks on any listed item
    Then ProductDetails page is launched and fields are visible to the user
    When User enters Pincode "<pincode>"
    And User clicks on check button
    Then It shows Pincode is serviceable

    Examples: 
      | pincode |
      |  788001 |
      |  700146 |

  Scenario Outline: Verify Pincode functionality with invalid data
    Given Chrome is opened and Asianpaints app is opened
    When User searches the product
    And User clicks on the product
    Then User navigates onto the ProductList page
    And User clicks on any listed item
    Then ProductDetails page is launched and fields are visible to the user
    When User enters Pincode "<pincode>"
    And User clicks on check button
    Then It shows Pincode is not serviceable

    Examples: 
      | pincode |
      |  000000 |
      |  000001 |
