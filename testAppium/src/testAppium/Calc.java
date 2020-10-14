package testAppium;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;





	public class Calc extends Report{
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("VERSION", "9"); 
		capabilities.setCapability("deviceName","HUAWEI P20 lite");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("udid","9WV4C19306011158");   
	    capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); 
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	
	}
	
	@Test
	public void testCal() throws Exception {

		ExtentTest calc1 = extent.createTest("Hesap Makinesi", "Çarpma İşlemi");
		calc1.log(Status.INFO, "Hesap makinesi açıldı");
		
		driver.findElement(By.xpath("//android.widget.Button[@text='7']")).click();
		calc1.log(Status.PASS, "7'ye basıldı");
		
		
		driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.android.calculator2:id/op_mul']")).click();
		calc1.log(Status.PASS, "+ ' ya basıldı. ");
		
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		calc1.log(Status.PASS, "2'ye basıldı.");
		
		driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.android.calculator2:id/eq']")).click();
		calc1.log(Status.PASS, "Eşittir'e basıldı");
		
		calc1.log(Status.INFO, "İşlem bitti.");
	}
	
	
	@AfterClass
	public void teardown(){
		
		driver.quit();
	}
	}