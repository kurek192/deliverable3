import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HomepageTest
{
    static WebDriver driver = new HtmlUnitDriver();


    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    
   //Tests for the 5 header links specified in the requirements
    @Test
    public void testHeader()
    {
        try
        {
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    //Test to make sure the string 'Welcome, friend, to a land of pure calculation' is displayed on the homepage,
    //as specified in the requirements.
    @Test
    public void testWelcomeText()
    {
        try
        {
            driver.findElement(By.xpath("//*[text()[contains(.,'Welcome, friend, to a land of pure calculation')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    //Test to make sure the string 'Used for CS1632 Software Quality Assurance, taught by Bill Laboon' is displayed on the homepage,
    //as specified in the requirements.
    @Test
    public void testUseText()
    {
        try
        {
            driver.findElement(By.xpath("//*[text()[contains(.,'Used for CS1632 Software Quality Assurance, taught by Bill Laboon')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
    
}