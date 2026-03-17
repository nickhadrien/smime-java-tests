import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class smimeCorrectEmailTest {
  private WebDriver driver;
    JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test //Email совпадает с записанным в бд
  public void smimeCorrectEmail() {
    driver.get("***");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("***");
    driver.findElement(By.cssSelector(".getaccess")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By successIndicator = By.xpath("//p[@class='info' and contains(text(),'Мы отправили вам письмо')]");
    boolean isSuccess = wait.until(
            ExpectedConditions.presenceOfElementLocated(successIndicator)
    ).isDisplayed();

    assertTrue("Сообщение об успешной отправке не появилось", isSuccess);

    System.out.println("✓ Письмо отправлено по указанному email");
  }
}