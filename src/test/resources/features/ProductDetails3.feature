Feature: ProductDetails

  Scenario Outline: Verify Pincode functionality with valid data
    Given Chrome is opened and Asianpaints app is opened
    When User searches the product
    And User clicks on the product
    Then User navigates onto the ProductList page
    And User clicks on any listed item
    Then ProductDetails page is launched and fields are visible to the user
    When User enters Pincode from sheetname "<SheetName>" and rownumber <RowNumber>
    And User clicks on check button
    Then It shows Pincode is serviceable

    Examples: 
      | SheetName | RowNumber |
      | Sheet1    |         0 |
      | Sheet1    |         1 |

  Scenario Outline: Verify Pincode functionality with invalid data
    Given Chrome is opened and Asianpaints app is opened
    When User searches the product
    And User clicks on the product
    Then User navigates onto the ProductList page
    And User clicks on any listed item
    Then ProductDetails page is launched and fields are visible to the user
    When User enters Pincode from sheetname "<SheetName>" and rownumber <RowNumber>
    And User clicks on check button
    Then It shows Pincode is not serviceable

    Examples: 
      | SheetName | RowNumber |
      | Sheet2    |         0 |
      | Sheet2    |         1 |
