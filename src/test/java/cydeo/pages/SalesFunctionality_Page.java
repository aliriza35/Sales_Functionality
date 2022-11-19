package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalesFunctionality_Page {

    public SalesFunctionality_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu='445']")
    public WebElement salesButton;

    @FindBy(xpath = "//a[@data-menu='447']")
    public WebElement customersButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(css= "[placeholder='Name']")
    public WebElement nameBox;

    @FindBy(xpath = "//title")
    public WebElement usernameTitle;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "//img[@class='img img-responsive']")
    public WebElement img;

    @FindBy(xpath = "//div[@class='o_notification_manager']/div")
    public WebElement errorMessage;

    @FindBy(css = ".o_kanban_image")
    public WebElement customersImg;

    @FindBy(xpath = "(//div[@class='oe_kanban_details']//span)[1]")
    public WebElement nameOfCustomer;








}
