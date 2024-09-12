package Tests;

import com.sauceDemo.pages.ProductsPage;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class ProductsTests extends BaseTest{
    String username = "standard_user";
    String password = "secret_sauce";
    @Test
    public void testProductsHeaderIsDisplayed(){
      ProductsPage productsPage = loginPage.logIntoApplication(username,password);
        assertTrue(productsPage.isProductsHeaderDisplayed(), "\n Products Header Is Displayed");
    }
}
