package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.net.URL;

public class Checks {

  public static final String USERNAME = "julietafoglia1";
  public static final String AUTOMATE_KEY = "kqz8bEzr4pD5gdhKSSoM";
  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
  private static WebDriver driver;
  
  @BeforeClass
  @org.testng.annotations.Parameters(value={"browser","version","platform"})
  
  public void setUp(String browser, String version, String platform) throws Exception {
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability("platform",platform);
    capability.setCapability("browserName", browser);
    capability.setCapability("browserVersion", version);
    capability.setCapability("project", "P1");
    capability.setCapability("build", "1.0");
    driver = new RemoteWebDriver(new URL(URL), capability);
  }

  public static void main(String[] args) throws Exception{
    
    /*DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "Firefox");
    caps.setCapability("browser_version", "43.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("browserstack.debug", "true");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);*/
    
    driver.get("https://s3-eu-west-1.amazonaws.com/gtm-data-layer/qa/0.0.2/test.html");
    
    WebElement link = driver.findElement(By.linkText("Go to test"));
    link.click();
    
    WebElement e = driver.findElement(By.id("e"));
    WebElement tna = driver.findElement(By.id("tna"));
    WebElement p = driver.findElement(By.id("p"));
    WebElement aid = driver.findElement(By.id("aid"));
    WebElement duid = driver.findElement(By.id("duid"));
    WebElement sid = driver.findElement(By.id("sid"));
    WebElement tv = driver.findElement(By.id("tv"));;
    WebElement url = driver.findElement(By.id("url"));
    WebElement refr = driver.findElement(By.id("refr"));
    WebElement page = driver.findElement(By.id("page"));
    WebElement after = driver.findElement(By.id("after"));
    
    Assert.assertEquals(e.getText(), "pv");
    Assert.assertEquals(tna.getText(), "test");
    Assert.assertEquals(p.getText(), "web");
    Assert.assertEquals(aid.getText(), "publisher1");
    Assert.assertEquals(duid.getText(), "");
    Assert.assertEquals(sid.getText(), "");
    Assert.assertEquals(tv.getText(), "pub-0.0.2");
    Assert.assertEquals(url.getText(), "http://cdn.mojn.com/spp/loadsnowplow.html");
    Assert.assertEquals(refr.getText(), "http://cdn.mojn.com/spp/test.html");
    Assert.assertEquals(page.getText(), "Browser Test");
    Assert.assertEquals(after.getText(), "OK");
    
    driver.quit();
  }
}