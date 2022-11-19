@BRT-787
  Feature: Upgenix app sales functionality feature

# @BRT-805
    Background: For the scenarios in the sales feature file, user has logged in
      Given user has logged in

    @BRT-806
    Scenario: User can reach new customer form
      When user clicks the sales button
      And user clicks the customers button
      And user clicks the create button
      Then user is on the new customer form page

    @BRT-807
    Scenario: Verify that if customer name field leaves blank, an error message is appeared
      When user clicks the sales button
      And user clicks the customers button
      And user clicks the create button
      And user does not type anything into name box and click the save button
      Then user should see an error message

    @BRT-808
    Scenario: Verify that after creating a new customer, the page title includes the customer name
      When user clicks the sales button
      And user clicks the customers button
      And user clicks the create button
      And user types a random name into name box
      And user clicks the save button
      Then the page title includes that random name

    @BRT-809
    Scenario: Verify that the user should be able to see created customer is listed after clicking the Customers module
      When user clicks the sales button
      And user clicks the customers button
      And user clicks the create button
      And user types a random name into name box
      And user clicks the save button
      And user clicks the customers button
      And user types that name into search box
      And user pushes the enter key
      Then user should see his or her name

