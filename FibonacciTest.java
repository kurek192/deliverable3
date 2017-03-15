import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.fail;

public class FibonacciTest
{
    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    //Test the the application accepts an integer for fibonacci input
    @Test
    public void testInteger()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("5");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 5 is 8!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
    
    //Test the the application accepts a negative integer for fibonacci input
    @Test
    public void testNegative()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("-1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of -1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
    
    //Test the the application accepts a upper boundary integer for fibonacci input
    @Test
    public void testUpperEdge()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("100");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 100 is 573147844013817084101!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

    }


    //Test that the application accepts a lower boundary integer for fibonacci input
    @Test
    public void testLowerEdge()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 0 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

    }

    
    //Test that the application accepts a decimal value
    @Test
    public void testDecimal()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0.1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 0.1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    //Test that the application accecpt a text string value
    @Test
    public void testText()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("Foo");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of Foo is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }


    
    //Test if fibonacci input, if it is not inputted correctly it shoulf fail
    @Test
    public void testInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
}