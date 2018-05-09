package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import other.Stash;

import java.util.List;

public class ItemsPage extends Base{

    @FindBy(xpath=".//a[contains(text(),'Перейти ко всем фильтрам')]")
    public WebElement filterBut;          //расширенный поиск


    public ItemsPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public FilterPage goToFilter (){
        filterBut.click();
        return new FilterPage();
    }

    @FindBy(xpath = ".//span[contains(text(),'Показывать по')]")        //&&&
    public WebElement showx;      //показывать по выбор

    @FindBy(xpath = ".//span[contains(text(),'Показывать по')]/parent::button")
    public WebElement showxButton;

    @FindBy(xpath = ".//option[contains(text(),'Показывать по 12')]/parent::select")
    public WebElement show12;

    @FindBy(xpath = ".//span[contains(text(),'Показывать по')]/ancestor::button/following-sibling::select")
    public WebElement numberShown;

    @FindBy(xpath = ".//span[contains(text(),'Показывать по')]/parent::button/parent::span")
    public WebElement tr100;

    @FindBy(xpath = ".//div[contains(@class,'n-snippet-card2__title')]/a | .//div[contains(@class,'n-snippet-cell2__header')]/div/a")
    List<WebElement> results;


    @FindBy(xpath = ".//input[@id='header-search']")
    public WebElement headerSearch;

    public ChosenItemPage rememberElementAndFindIt(){        //and select number of items shown
        showxButton.click();
      //  waitVisibilityOf(show12);
      //  Select numbOfElems = new Select(show12);
      //  numbOfElems.selectByValue("12");
        WebElement firstItem=results.get(0);
        String name=firstItem.getText();        //name of the product in the first item
     //   waitVisibilityOf(firstItem);
      //  Assert.assertEquals("Показывать по 12 не установлено",
       //        "Показывать по 12", showx.getText());

        Stash.put(Stash.firstItemName, name);       //remeber first item
        fillField(name,headerSearch);
        headerSearch.sendKeys(Keys.ENTER);
        return new ChosenItemPage();
    }
}
