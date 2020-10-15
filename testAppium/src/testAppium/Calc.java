package testAppium;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import oracle.jdbc.logging.annotations.Logging;




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
		
		try {
			WebElement seven = driver.findElement(By.xpath("//android.widget.Button[@text='7']"));
			seven.click();
			calc1.log(Status.PASS, "7'ye basıldı");
		}catch (Exception e) {
			calc1.log(Status.FAIL, "7'ye basılamadı");
			extent.flush();
			
		}
		
		try {
			WebElement plus = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.android.calculator2:id/op_mul']"));
			plus.click();
			calc1.log(Status.PASS, "+ ' ya basıldı. ");
		}catch (Exception e) {
			calc1.log(Status.FAIL, "+ ' ya basılamadı. ");
		}
		
		
		try {
			WebElement two = driver.findElement(By.xpath("//android.widget.Button[@text='2']"));
			two.click();
			calc1.log(Status.PASS, "2'ye basıldı.");
		}catch (Exception e) {
			calc1.log(Status.FAIL, "2'ye basılamadı. ");
			
		}
		
		
		try {
			WebElement equals = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.android.calculator2:id/eq']"));
			equals.click();
			calc1.log(Status.PASS, "Eşittir'e basıldı");
		}catch (Exception e) {
			calc1.log(Status.FAIL, "Eşittir'e basılamadı. ");
		}
		
		
		try {
			WebElement result = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.calculator2:id/formula']"));
			String a = result.getText();
			calc1.log(Status.PASS,"Sonuç: "+ a);
		}catch (Exception e) {
			calc1.log(Status.FAIL, "Sonuç alınamadı.");
		}
		
		
		calc1.log(Status.INFO, "İşlem bitti.");
		
		
	}
	
	
	@AfterClass
	public void teardown(){
		
		driver.quit();
	}
	}