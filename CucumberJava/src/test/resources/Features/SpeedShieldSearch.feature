Feature: Search functionality in Operator Management Page

  Scenario Outline: Verify Grid applies filters for entered user name and password
    Given user is on Operator Management Page
    When user enter <firstname> and <lastname>
    Then the grid applies the filters

    Examples: 
      | username         | password | firstname | lastname |
      | test_141@sst.com | Pass123! | Operator  | Card1236 |

  Scenario Outline: Verify user is able to update Personnel Number successfully for a particular operator with provided first name and last name
    Given user is on Operator Management Page
    When user enter <firstname> and <lastname>
    And update <PersonnelNumber> and click Update Operator details
    Then update success notification is received

    Examples: 
      | username         | password |  | firstname | lastname | PersonnelNumber |
      | test_141@sst.com | Pass123! |  | Operator  | Card1236 |            1236 |
