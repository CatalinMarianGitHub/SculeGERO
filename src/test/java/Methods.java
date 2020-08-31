import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Methods {


    protected String baseURl = "https://www.sculegero.ro/";
    WebDriver driver;


    public Methods(String baseURl, WebDriver driver) {
        this.baseURl = baseURl;
        this.driver = driver;
    }

    public Methods() {

    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/MarianP/Desktop/New folder (4)/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public void registerMethod() throws InterruptedException {

        WebElement el = driver.findElement(By.xpath("//*[@id=\"logtop\"]/div[1]/a[2]/div"));
        Thread.sleep(2000);
        el.click();

    }
}





