package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import other.Stash;

public class FilterPage extends Base{
    @FindBy(xpath=".//input[@name='glf-pricefrom-var']")
    public WebElement lowLimitMoney;        // вводим 20000 сюда

    @FindBy(xpath=".//*[contains(text(),'Samsung')]/parent::span")
    public WebElement samsungProd;      //выбираем производителей
    @FindBy(xpath=".//*[contains(text(),'LG')]/parent::span")
    public WebElement lgProd;

    @FindBy(xpath = ".//span[contains(text(),'Показать подходящие')]/parent::a")
    public WebElement applChanges;      //показать подходящие

    @FindBy(xpath=".//*[contains(text(),'Sennheiser')]/parent::span")
    public WebElement sennProd;



    public FilterPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public FilterPage inputMoney (String money){
        fillField(money,lowLimitMoney);
        return this;
    }
    public ItemsPage inputProdsTV(){
        waitVisibilityOf(samsungProd);
        samsungProd.click();
        lgProd.click();
        applChanges.click();
        return new ItemsPage();
    }
    public ItemsPage inputProdsHP(){
        waitVisibilityOf(samsungProd);
        sennProd.click();
        applChanges.click();
        return new ItemsPage();
    }

}
