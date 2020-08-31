import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

public class SeleniumHelper {

    protected String baseURl = "https://www.sculegero.ro/";
    WebDriver driver;

    public SeleniumHelper() {
        this.baseURl = baseURl;
        this.driver = driver;
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "D:/qa automation/Utils/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    public WebElement getElement(String locator) {
        if (locator.startsWith("/")) {
            return driver.findElement(By.xpath(locator));
        } else {
            return driver.findElement(By.id(locator));
        }
    }


    public void registerMethodfromSeleniumHelper() {
//        String expectedResult = "Contul dumneavoastra a fost creat!";
//        WebElement actualResult = driver.findElement(By.id("createAcctSuccessHeading"));
        getElement("//*[@id=\"logtop\"]/div[1]/a[2]/div").click();
        getElement("//*[@id=\"loginDefault\"]/fieldset[1]/form/div/input").click();
        WebElement checkBoxSuntDeAcordCuTermeniiSiConditiile = driver.findElement(By.id("privacy"));
        checkBoxSuntDeAcordCuTermeniiSiConditiile.click();
        getElement("firstname").sendKeys("Nicu");
        getElement("lastname").sendKeys("NICU");
        getElement("extrafield4").sendKeys("1952545841259");
        getElement("street-address").sendKeys("adresa sector 4");
        getElement("city").sendKeys("Bucuresti");
        Select dropdown = new Select(driver.findElement(By.id("stateZone")));
        dropdown.selectByVisibleText("Bucuresti");
        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
        dropdown2.selectByVisibleText("Romania");
        getElement("telephone").sendKeys("0543534554535");
        getElement("email-address").sendKeys("test@test.com");
        getElement("password-new").sendKeys("Password!");
        getElement("password-confirm").sendKeys("Password!");
//        getElement("//*[@id=\"createAcctDefault\"]/form/div/input").click();
//        assertTrue(actualResult.getText().contains(expectedResult));
    }

    public void loginMethod() {
        getElement("login-email-address").sendKeys("test@test.com");
        getElement("login-password").sendKeys("Password!");
        getElement("//*[@id=\"loginForm\"]/div[3]/input").click();
        ;

    }

    public void addProductToShoppingCart() {
        String expectedText = "Fierastrau sabie BOSCH GSA 1300 PCE";
        getElement("//*[@id=\"categoriesContent\"]/a[1]").click();
        getElement("//*[@id=\"cat2303Table\"]/tbody/tr[2]/td[5]/a/span").click();
        //user click on "Cosul meu"
        getElement("//*[@id=\"cosulmeu\"]/a/span").click();
        WebElement actualText = driver.findElement(By.xpath("//*[@id=\"cartProdTitle\"]"));
        assertTrue(actualText.getText().equals(expectedText));

    }


    public void makeAnOrderFromShopingCart() throws InterruptedException {
        WebElement checkOutButton = driver.findElement(By.xpath("//*[@id=\"shoppingCartDefault\"]/form/div[4]/a/span"));
        checkOutButton.click();
        Thread.sleep(1000);
        WebElement checkboxLivrare = driver.findElement(By.id("ship-flat4-flat4"));
        checkboxLivrare.click();
        getElement("//*[@id=\"checkoutShipping\"]/form/div[4]/input").click();
        Thread.sleep(1000);
        WebElement checkBoxModalitatePlata = driver.findElement(By.id("pmt-cod"));
        checkBoxModalitatePlata.click();
        getElement("//*[@id=\"checkoutPayment\"]/form/div[3]/input").click();
        Thread.sleep(1000);



    }

//    JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,400)", "");

}
