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

public class smimeNotEmailTest {
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

  @Test //Ввод в поле произвольного буквенно-числового значения, не адреса электронной почты
  public void smimeNotEmail() {
    driver.get("***");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("***");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By successIndicator = By.xpath("//span[@class='formerror' and contains(text(),'Укажите корректный e-mail адрес')]");
    boolean isSuccess = wait.until(
            ExpectedConditions.presenceOfElementLocated(successIndicator)
    ).isDisplayed();

    assertTrue("Сообщение об вводе данных появилось", isSuccess);

    System.out.println("✓ Укажите корректный email");
  }
}