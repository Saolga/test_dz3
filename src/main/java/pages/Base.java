package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    WebDriver driver;

    public void waitVisibilityOf(WebElement loc, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(loc));
    }

    public void waitVisibilityOf(WebElement loc){
        waitVisibilityOf(loc,25);
    }

    public void fillField(String var,WebElement loc){
        loc.sendKeys(var);
    }


}
