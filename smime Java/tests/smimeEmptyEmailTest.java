import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class smimeEmptyEmailTest {
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

  @Test //Пустое поле ввода email
  public void smimeEmptyEmail() {
    driver.get("***");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(Keys.ENTER);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    boolean isSuccess = wait.until(
            ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("p.info:nth-child(3)"))
    );

    assertTrue("Сообщение об успешной отправке появилось", isSuccess);

    WebElement submitButton = driver.findElement(By.cssSelector(".getaccess"));
    assertFalse("Кнопка должна быть неактивна при пустом поле", submitButton.isEnabled());

    System.out.println("✓ Кнопка 'Отправить' неактивна");
  }
}