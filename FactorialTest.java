import static org.junit.Assert.fail;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FactorialTest {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    //Test that the application accept negative factorial input
    @Test
    public void testNegative() {
        try {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("-1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of -1 is 1!')]]"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    //Test that the application accept upper bounds factorial values
    @Test
    public void testUpperEdge() {
        try {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("101");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            BigInteger i = BigIntegerMath.factorial(100);
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 100 is " + i + "!')]]"));
        } catch (NoSuchElementException nseex) {
            fail();
        }

    }

    //Test that the application accept lower bounds factorial values
    @Test
    public void testLowerEdge() {
        try {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 0 is 1!')]]"));
        } catch (NoSuchElementException nseex) {
            fail();
        }

    }

    //Test that the application accept decimal factorial values
    @Test
    public void testDecimal() {
        try {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0.2");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 0.2 is 1!')]]"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    //Test that the application accept string text values
    @Test
    public void testText() {
        try {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("Foo");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of Foo is 1!')]]"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    //Test that the application accept integer values
    @Test
    public void testInteger() {
        try {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("10");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            BigInteger i = BigIntegerMath.factorial(10);
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 10 is " + i + "!')]]"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    //Test that the application accept input properly
    @Test
    public void testInput() {
        try {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

}
