Feature: login

  Scenario: User login with unregistered email
    Given User navigate to login or signup page
    When User input "bebebeb@beb.beb"
    And User click login button
    And User input login password "abcabcabc"
    And User click login button
    Then User see popup account not found

  Scenario: User login with unregistered phone number
    Given User navigate to login or signup page
    When User input "088888899988"
    And User click login button
    Then User see popup phone number is not registered

  Scenario: User login with registered email
    Given User navigate to login or signup page
    When User input "theodoraclara@gmail.com"
    And User click login button
    And User input password "januari"
    And User click login button
    Then User redirect to home page
    And User logout

  Scenario: User login with registered phone number
    Given User navigate to login or signup page
    When User input "0895342404946"
    And User click login button
    And User fill login OTP "111111"
    And Click confirm login button
    Then User redirect to home page
    And User logout

  Scenario: User login with registered username
    Given User navigate to login or signup page
    When User input "claratheodora"
    And User click login button
    And User input password "januari"
    And User click login button
    Then User redirect to home page
    And User logout
