Feature: Sysdig Login Page Scenarios
  Description: This feature file contains test scenarios that related to the Login Page

  Background:
    Given user navigates to Sysdig login page

  # search is not narrowed by typing AP into input box. It excepts AP with space and - symbol
  # but user can still select it with mause or keyboard events
  # AP region is not displayed as AP-AU in the pop-up menu.
  # AP-AU appears after AP region selected
  Scenario Outline: This scenario verifies the region selection functionality
    When user clicks on Region container
    And user selects "<region>"
    Then navigates to related "<URL>"
    Then selected "<region name>" displays on Region container

    Examples:
      | region  | URL                                 | region name |
      | EU      | https://eu1.app.sysdig.com/#/login  | EU Central  |
      | US East | https://app.sysdigcloud.com/#/login | US East     |
      | US West | https://us2.app.sysdig.com/#/login  | US West     |
      | AP -    | https://app.au1.sysdig.com/#/login  | AP - AU     |


  Scenario: This scenario verifies that unauthorized users can not be able to login
    When user enter wrong credentials to email filed "qateam@test.com" and password filed "A1b2!"
    And click to the log in button
    Then user see "Credentials are not valid" error message

  # Google OAuth is not enabled for AP region
  Scenario Outline: This scenario verifies user able to login with Google authentication
    When user selects "<region>"
    When user clicks on the Google button under the Log in with separator
    Then on the redirected page "Sign in - Google Accounts" title displays

    Examples:
      | region  |
      | EU      |
      | US East |
      | US West |
      | AP -    |

  Scenario Outline: This scenario verifies user able to login with SAML authentication
    When user selects "<region>"
    When user clicks on the SAML button under the Log in with separator
    Then on the redirected page "samlAuthentication" URI displays

    Examples:
      | region  |
      | EU      |
      | US East |
      | US West |
      | AP -    |

  Scenario Outline: This scenario verifies user able to login with OpenID authentication
    When user selects "<region>"
    When user clicks on the OpenID button under the Log in with separator
    Then on the redirected page "openIdAuthentication" URI displays

    Examples:
      | region  |
      | EU      |
      | US East |
      | US West |
      | AP -    |

  Scenario: This scenario verifies that "Log in with:" separator is display
    Then "Log in with:" separator displays

  Scenario: This scenario verifies that user can able to request password reset
    When user clicks on Forgot your password link
    Then navigates to forgot password page

  Scenario: This scenario verifies that user can Sign up for a free trial
    When user clicks on Sign up for a free trial link
    Then navigates to "Try Sysdig for Free" heading
