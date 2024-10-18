Feature: Validate the new features of new application

  @appiumAutomation
  Scenario Outline: Validate option of mydemoapp
    Given User open the application
    When User select the handburger to open menu
    Then User tap on login
    Then User try login attempts from "<SheetName>" and <RowNumber>
    And User tap on login button

    Examples: 
      | SheetName         | RowNumber |
      | appiumapplication |         0 |
      | appiumapplication |         1 |
      | appiumapplication |         2 |
      | appiumapplication |         3 |
