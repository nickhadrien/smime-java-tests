import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
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
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.linkText("Вернуться на стартовую страницу")).click();
  }
}
