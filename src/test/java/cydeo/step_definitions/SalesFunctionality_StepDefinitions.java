package cydeo.step_definitions;

import cydeo.pages.LoginPage;
import cydeo.pages.SalesFunctionality_Page;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SalesFunctionality_StepDefinitions {

    SalesFunctionality_Page salesFunctionality_page = new SalesFunctionality_Page();
    LoginPage loginPage = new LoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    String randomName = "";

    @Given("user has logged in")
    public void user_has_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("upgenix.login.url"));
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("upgenix.email"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("upgenix.password"));
        loginPage.loginButton.click();
    }
    @When("user clicks the sales button")
    public void user_clicks_the_sales_button() {
        salesFunctionality_page.salesButton.click();
    }
    @And("user clicks the customers button")
    public void user_clicks_the_customers_button(){
        salesFunctionality_page.customersButton.click();
    }
    @And("user clicks the create button")
    public void user_clicks_the_create_button() {
        wait.until(ExpectedConditions.visibilityOf(salesFunctionality_page.customersImg));
        salesFunctionality_page.createButton.click();
    }

    @Then("user is on the new customer form page")
    public void user_is_on_the_new_customer_form_page() {
        Assert.assertTrue(salesFunctionality_page.nameBox.isDisplayed());
        Assert.assertTrue(salesFunctionality_page.img.isDisplayed());
        Assert.assertTrue(salesFunctionality_page.saveButton.isDisplayed());

    }
    @And("user does not type anything into name box and click the save button")
    public void user_does_not_type_anything_into_name_box_and_click_the_save_button() {
        salesFunctionality_page.saveButton.click();
    }
    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
      //  Assert.assertTrue("Error message was not displayed",salesFunctionality_page.errorMessages.size()>0);
        Assert.assertTrue("Error message was not displayed",salesFunctionality_page.errorMessage.getText().contains("invalid"));
    }
    @And("user types a random name into name box")
    public void user_types_into_name_box() {
        randomName =""+ System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(salesFunctionality_page.nameBox));
        salesFunctionality_page.nameBox.sendKeys(randomName);
    }
    @And("user clicks the save button")
    public void user_clicks_the_save_button() {
        salesFunctionality_page.saveButton.click();
        BrowserUtils.waitFor(3);
    }
    @Then("the page title includes that random name")
    public void the_page_title_includes_that_random_name() {

        Assert.assertTrue("Page title does not contain " + randomName, wait.until(ExpectedConditions.titleContains(randomName)));
    }

    @And("user types that name into search box")
    public void user_types_his_or_her_username_into_search_box() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o_searchview_input']")));
        salesFunctionality_page.searchBox.sendKeys(randomName);
    }
    @And("user pushes the enter key")
    public void user_pushes_the_enter_key() {

        salesFunctionality_page.searchBox.sendKeys(Keys.ENTER);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'o_kanban_view')]/div[not(contains(@class,'ghost'))]")));
        }catch (Throwable e){
            e.printStackTrace();
            Assert.fail("There are no results.");
        }
    }
    @Then("user should see his or her name")
    public void user_should_see_his_her_username() {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(salesFunctionality_page.nameOfCustomer, randomName));
            Assert.assertEquals(randomName, salesFunctionality_page.nameOfCustomer.getText());
        }catch (TimeoutException e){
            Assert.fail();
        }


    }





}
