package pages.automationExercisePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;
import pages.thyPages.DatePage;

public class FileDownLoadPage extends BasePage {
    public FileDownLoadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-qa='login-email']") private WebElement emailBox;
    @FindBy(xpath = "//*[@data-qa='login-password']") private WebElement passwordBox;
    @FindBy(xpath = "//*[@data-qa='login-button']") private WebElement loginButton;
    ////*[@href='/product_details/1']
    @FindBy(xpath = "//img[@src='/get_product_picture/1']/following-sibling::a//i") private WebElement addToCart;
    @FindBy(xpath = "//*[text()='View Cart']") private WebElement viewCartButton;
    @FindBy(xpath = "//*[text()='Proceed To Checkout']") private WebElement checkoutButton;
    @FindBy(xpath = "//*[text()='Place Order']") private WebElement placeOrderButton;
    @FindBy(name = "name_on_card") private WebElement nameCardBox;
    @FindBy(name = "card_number") private WebElement cardNumberBox;
    @FindBy(name = "cvc") private WebElement cvcBox;
    @FindBy(name = "expiry_month") private WebElement monthBox;
    @FindBy(name = "expiry_year") private WebElement yearBox;
    @FindBy(id= "submit") private WebElement submitButton;
    @FindBy(xpath = "//*[text()='Download Invoice']") private WebElement invoiceButton;




    public FileDownLoadPage loadPage(){
        navigateTo_URL("https://automationexercise.com/login");
        return this;
    }
    public FileDownLoadPage login(String email,String password){
        enterText(emailBox,email);
        enterText(passwordBox,password);
        click(loginButton);
        return this;
    }
    public FileDownLoadPage addProductGoToCart(){
        scrollIntoViewJS(addToCart);
        actions.moveToElement(addToCart).perform();
        jsScrollClick(addToCart);
        click(viewCartButton);
        click(checkoutButton);
        jsScrollClick(placeOrderButton);
        return this;
    }
    public FileDownLoadPage cratePAymentVeify(){
        enterText(nameCardBox,"salih gül");
        enterText(cardNumberBox,"4242424242424242");
        enterText(cvcBox,"311");
        enterText(monthBox,"12");
        enterText(yearBox,"2026");
        click(submitButton);
        return this;
    }
    public FileDownLoadPage verifyFileDownLoadPaper(){
        click(invoiceButton);
        waitFor(5);

        String path="C:\\Users\\LENOVO\\Downloads";
        String fileName="invoice.txt";
        Assert.assertTrue(verifyFileDownload(path,fileName));

        return this;
    }

}
