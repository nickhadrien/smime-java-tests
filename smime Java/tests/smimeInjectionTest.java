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

public class smimeInjectionTest {
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

  @Test //Проверка на запуск простого скрипта, инъекцию
  public void smimeInjection() {
    driver.get("***");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("***");
    driver.findElement(By.id("email")).sendKeys(Keys.ENTER);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By successIndicator = By.xpath("//span[@class='formerror' and contains(text(),'Укажите корректный e-mail адрес')]");
    boolean isSuccess = wait.until(
            ExpectedConditions.presenceOfElementLocated(successIndicator)
    ).isDisplayed();

    assertTrue("Сообщение об успешной отправке появилось", isSuccess);

    System.out.println("✓ Приложение требует ввод email");
  }
}