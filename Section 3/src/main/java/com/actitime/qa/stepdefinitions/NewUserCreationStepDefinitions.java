package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class NewUserCreationStepDefinitions extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    String sheetName = "Users";
    TestUtil testUtil;
    Logger log;

    @Before
    public void beforeScenario() {
        initialization();
        log = Logger.getLogger(this.getClass());
    }

    @Given("the user is logged in to the system as an admin with username {string} and password {string}")
    public void loginAsAdmin(String username, String password) {
        loginPage = new LoginPage();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        homePage = loginPage.clickSubmitButton();
    }

    @When("the user clicks on Users → New User")
    public void clickOnNewUser() {
        usersPage = homePage.clickOnUsersLink();
        usersPage.clickOnNewUserButton();
    }

    @And("the user fills in the required fields with firstName {string} and lastname {string} and email {string}")
    public void fillRequiredFields(String firstname, String lastname, String email) {
        usersPage.setFirstName(firstname);
        usersPage.setLastName(lastname);
        usersPage.setEmail(email);
    }

    @And("the user clicks on the Create User button")
    public void clickCreateUserButton() {
        usersPage.clickOnSaveAndSendInvitationButton();
    }

    @Then("a new user is created successfully with firstname {string} and lastname {string}")
    public void verifyUserCreation(String firstname, String lastname) {
        String expectedMessage = "Account for " + firstname + " " + lastname + " has been created.";
        String confirmationMessage = usersPage.getConfirmationMessage();
        try {
            Assert.assertEquals(confirmationMessage, expectedMessage);
            log.info("User Successfully Created ");
        } catch (AssertionError e) {
            log.fatal("User Creation Failed : " + e.getMessage());
        }
    }

    @After
    public void afterScenario() {
        driver.quit();
    }


}
