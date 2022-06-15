Feature: signup

  Scenario: User redirect to signup page by click signup button
    Given User navigate to login or signup page
    When User click signup button
    Then User see create new account

  Scenario: Signup with new phone number
    Given User navigate to signup page
    When User fill phone number with "random_phone_number"
    And User click sign up button
    And User fill OTP "111111"
    And Click confirm button
    Then User will see completing profile page
    When User fill email with "random_email"
    And User fill username with "random_username"
    And User fill password with "random_password"
    And User input date of birth "02/22/2000"
    And User click submit button
    Then Register successfully user redirect to homepage
    And User see button verify now
    And User logout

  Scenario: Signup with incorrect phone number format
    Given User navigate to signup page
    When User fill phone number "088888"
    Then Error message please enter your correct phone number appear

  Scenario: Signup with existing phone number
    Given User navigate to signup page
    When User fill phone number "0895342404946"
    And User click sign up button
    Then User see popup phone number has been registered

  Scenario: User signup with already used email
    Given User navigate to signup page
    When User fill phone number with "random_phone_number"
    And User click sign up button
    And User fill OTP "111111"
    And Click confirm button
    Then User will see completing profile page
    When User fill email with "theodoraclara@gmail.com"
    And User fill username with "random_username"
    And User fill password with "random_password"
    And User input date of birth "02/22/2000"
    And User click submit button
    Then Error message email has been registered appear

  Scenario: User signup with already used username
    Given User navigate to signup page
    When User fill phone number with "random_phone_number"
    And User click sign up button
    And User fill OTP "111111"
    And Click confirm button
    Then User will see completing profile page
    When User fill email with "random_email"
    And User fill username with "claratheodora"
    And User fill password with "random_password"
    And User input date of birth "02/22/2000"
    And User click submit button
    Then Error message username has been taken appear
