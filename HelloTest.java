import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HelloTest
{
    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }
    
    //Test trailing value
    @Test
    public void testTrailingValues()
    {
        try
        {
            driver.findElement(By.linkText("Hello")).click();

            String url = driver.getCurrentUrl();
            String temp = url+"/William Kurek";
            driver.get(temp);
            driver.findElement(By.xpath("//*[text()[contains(.,'Hello CS1632, from William Kurek!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    //Test no trailing value
    @Test
    public void testNoTrailingValues()
    {
        try
        {
            driver.findElement(By.linkText("Hello")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Hello CS1632, from Prof. Laboon!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    

}