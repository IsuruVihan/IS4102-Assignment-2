Feature: New User Creation

  Scenario: Create a new user as admin
    Given the user is logged in to the system as an admin with username "2019is033@stu.ucsc.cmb.ac.lk" and password "Isuru@123"
    When the user clicks on Users → New User
    And the user fills in the required fields with firstName "John" and lastname "Doe" and email "john@example.com"
    And the user clicks on the Create User button
    Then a new user is created successfully with firstname "John" and lastname "Doe"
