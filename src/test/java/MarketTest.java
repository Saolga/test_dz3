import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import other.Stash;
import pages.MainPage;

public class MarketTest {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Stash.put("driver", driver);
        driver.get("https://www.yandex.ru/");
    }

    @After
    public void shutDown(){
        Stash.getDriver().quit();
    }

    @Test
    public void testYandex_TV() {
        new MainPage()
                .MainPageGoToMarket()
                .chooseSectionTV()
                .goToFilter()
                .inputMoney("20000")
                .inputProdsTV()
                .rememberElementAndFindIt()
                .proveItem();
    }

    @Test
    public void testYandex_Headphones() {
        new MainPage()
                .MainPageGoToMarket()
                .chooseSectionHP()
                .goToFilter()
                .inputMoney("5000")
                .inputProdsHP()
                .rememberElementAndFindIt()
                .proveItem();
    }


}
