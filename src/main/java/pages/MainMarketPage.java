package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import other.Stash;

public class MainMarketPage extends Base{
    @FindBy(xpath=".//li[contains(@class,'topmenu__item i-bem')]//a[contains(text(),'Электроника')]")
    public WebElement electrBut;        // электроника

    @FindBy(xpath="//div[@class='catalog-menu__list']/a[contains(text(),'Телевизоры')]")
    public WebElement teleBut;          //телевизоры

    @FindBy(xpath = "//div[@class='catalog-menu__list']/a[contains(text(),'Наушники')]")
    public WebElement headphonesBut;       //наушники



    public MainMarketPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public ItemsPage chooseSectionTV (){
        waitVisibilityOf(electrBut);
        electrBut.click();
        waitVisibilityOf(teleBut);
        teleBut.click();
        return new ItemsPage();
    }
    public ItemsPage chooseSectionHP (){
        waitVisibilityOf(electrBut);
        electrBut.click();
        waitVisibilityOf(headphonesBut);
        headphonesBut.click();
        return new ItemsPage();
    }

}
