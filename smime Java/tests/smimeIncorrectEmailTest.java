import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.Map;

public class smimeIncorrectEmailTest {
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

  @Test //Ввод email, отсутствующего в БД
  public void smimeIncorrectEmail() {
    driver.get("***");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("***");
    driver.findElement(By.cssSelector(".getaccess")).click();
    driver.findElement(By.linkText("Вернуться на стартовую страницу")).click();
  }
}
