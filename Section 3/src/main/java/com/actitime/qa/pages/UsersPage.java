package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends TestBase {

    @FindBy(xpath = "//div[text()='New User']")
    WebElement newUserButton;
    @FindBy(xpath = "//input[@id='createUserPanel_firstNameField']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='createUserPanel_lastNameField']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='createUserPanel_emailField']")
    WebElement emailField;
    @FindBy(xpath = "//div[text()='Save & Send Invitation']")
    WebElement saveAndSendInvitationButton;
    @FindBy(xpath = "//span[text()='Close']")
    WebElement closeButton;
    @FindBy(xpath = "//div[@class='createUserPanel_accountCreatedContainer']/div[@class='invitationInfoHeader']")
    WebElement confirmationMessageField;
    WebDriverWait wait;
    Logger log;

    public UsersPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        log = Logger.getLogger(this.getClass());
    }

    public void clickOnNewUserButton() {
        newUserButton.click();
    }

    public void setFirstName(String firstName) {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        element.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        element.sendKeys(lastName);
    }

    public void setEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        element.sendKeys(email);
    }

    public void clickOnSaveAndSendInvitationButton() {
        saveAndSendInvitationButton.click();
    }

    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.elementToBeClickable(confirmationMessageField)).getText();
    }
}
