Feature: Login and reset Functionalities on FleetOnline Login Page

  Scenario Outline: Check Login is successfull with valid user name and password
    Given user is on login page
    When user enters <username> and <password>
    And click on login button
    Then user is navigated to FleetOnline Operator Management page

    Examples: 
      | username         | password |
      | test_141@sst.com | Pass123! |

      Scenario: Verify forgot password link is taking user to Reset Password Page
      
      Given user is on login page
      When user click on Reset Password link
      Then user is navigated to Reset password page
      
      