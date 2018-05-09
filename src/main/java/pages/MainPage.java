package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import other.Stash;

public class MainPage extends Base {        //Главная страница яндекса
    @FindBy(xpath = ".//*[@data-id='market']")
    public WebElement marketBut;

    public MainPage (){         //конструктор
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public MainMarketPage MainPageGoToMarket (){
        marketBut.click();
        return new MainMarketPage();
    }
}
