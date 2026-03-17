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
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class smimeCorrectDifEmailTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test //Верный email, но регистр не соответствует записи в БД
  public void smimeCorrectDifEmail() {
    driver.get("***");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("***");
    driver.findElement(By.cssSelector(".getaccess")).click();
    driver.findElement(By.linkText("Вернуться на стартовую страницу")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By successIndicator = By.xpath("//p[@class='info' and contains(text(),'Указанный e-mail не входит в список адресов')]");
    boolean isSuccess = wait.until(
            ExpectedConditions.presenceOfElementLocated(successIndicator)
    ).isDisplayed();

    assertTrue("Сообщение об успешной отправке появилось", isSuccess);

    System.out.println("✓ Указанный e-mail не входит в список адресов");
  }
}