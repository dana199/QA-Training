package Rainbow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Login {
	public String baseUrl="https://web.openrainbow.com/rb/2.100.16/index.html#/login";
	String driverPath="/RainbowLogin/Driver/chromedriver.exe";
	public WebDriver driver;
	
  @BeforeTest
  public void launchBrowser()
  {
	  System.out.println("launching chrome browser");
	  System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
      driver.manage().window().maximize();
  }
@SuppressWarnings("deprecation")
@Test
public void login ()
  {  
	  driver.findElement(By.id("username")).sendKeys("dhmooda@asaltech.com"); //To fill Email
	  
	  //driver.findElement(By.xpath("//button[text()='Continue']")).click();//"I try This Method But  it doesn’t working"
	 //driver.findElement(By.className("c-button__label")).click();//"I try This Method But  it doesn’t working"
	//driver.findElement(By.xpath("//button[starts-with(@role,'button')]")).click(); //"I try This Method But  it doesn’t working"
	  
     driver.findElement(By.id("username")).sendKeys(Keys.ENTER); //So I use this method(Use of sendKeys) because the button has dynamic ID 
      
	  //driver.findElement(By.xpath("//*[@id=\"authPwd\"]")).sendKeys("Asal@123");	//"I try This Method But  it doesn’t working"
	 
	  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"authPwd\"]"))).sendKeys("Asal@123");//So I use this method to fill pass
	  driver.findElement(By.xpath("//*[@id=\"authPwd\"]")).sendKeys(Keys.ENTER);
	 
	 // driver.findElement(By.className("c-button--icon")).click();
	 //driver.findElement(By.linkText("assets/svg_dist/sprite.svg#clear")).click();
	 //driver.findElement(By.xpath("/html/body/div[1]/popups[2]/div/whatsnew/userwindow/userwindow-footer/square-button/button")).click();
	  new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.c-button--icon:nth-child(3) > svg-img:nth-child(1) > svg:nth-child(1)"))).click();
  }
@SuppressWarnings("deprecation")
@Test
public void search ()                                  
{ 
	 new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"leftArea\"]/conversations/conversations-search/div/input"))).sendKeys("Maysam Mahmoud");
	 System.out.println(( driver.findElements(By.className("conversation-cell__name"))).get(0).getText());
}
  @AfterTest
  public void terminateBrowser()
  {
      driver.close();
  }
}
