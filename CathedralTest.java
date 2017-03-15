import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CathedralTest {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    //Test that there are three images inside the numbered list on the page
    @Test
    public void testNumberOfImages() {
        try {
            driver.findElement(By.linkText("Cathedral Pics")).click();
            WebElement numberedList = driver.findElement(By.tagName("ol"));
            List<WebElement> list = numberedList.findElements(By.tagName("img"));
            assertEquals(3, list.size());
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    //Test that the page has a numbered list
    @Test
    public void testNumberedList() {
        try {
            driver.findElement(By.linkText("Cathedral Pics")).click();
            List<WebElement> list = driver.findElements(By.tagName("ol"));
            assertEquals(1, list.size());
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

}
