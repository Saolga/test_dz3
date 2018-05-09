package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import other.Stash;

import static other.Stash.firstItemName;

public class ChosenItemPage extends Base {

    @FindBy(xpath=".//div[@class='n-title__text']/h1")
    public WebElement title;          //выбранный товар - наименование



    public ChosenItemPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void proveItem (){
        waitVisibilityOf(title);
        Assert.assertEquals("Названия не совпадают",
                    Stash.get(firstItemName), title.getText());
    }
}
