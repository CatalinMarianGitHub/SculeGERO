import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Tests extends SeleniumHelper {


//    @Test
//    public void registerTestwithMethodsClass() throws InterruptedException {
//        Methods meth = new Methods();
//        meth.registerMethod();
//
//    }

    @Test
    public void registerTestwithMethodFromSeleniumHelper() {
        driver.get(baseURl);
        registerMethodfromSeleniumHelper();
    }

    @Test
    public void loginTestWithMethodFromSeleniumHelper() {
        driver.get(baseURl);
        loginMethod();
    }

    @Test
    public void addProductToShoppingCartTestWithMethodFromSeleniumHelper() throws InterruptedException {
        driver.get(baseURl);
        loginMethod();
        Thread.sleep(2000);
        addProductToShoppingCart();


    }
    @Test
    public void makeAnOrderFromToShoppingCartTestWithMethodFromSeleniumHelper() throws InterruptedException {
        driver.get(baseURl);
        loginMethod();
        Thread.sleep(1000);
        addProductToShoppingCart();
        makeAnOrderFromShopingCart();

    }


}
