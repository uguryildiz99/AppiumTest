package testAppium;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import hbys.Login;

 
 public class SeleniumTest{
 
 	   private WebDriver driver = null;
 	    private String DRIVER_PATH;
 	    private String REPORT_PATH;
 	    private ExtentHtmlReporter htmlReporter;
 	    private ExtentReports extent;
 	    private ExtentTest logger;
 
 	    
 	    @Before
 	    public void testOncesiParametreleri() {
 	    	loadProperties();
 	        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
 	        new ChromeOptions();
 	        ChromeOptions options1 = new ChromeOptions();

 	        options1.addArguments("start-maximized"); // open Browser in maximized mode
 	        //options1.addArguments("--headless"); // open Browser in maximized mode
 	        options1.addArguments("disable-infobars"); // disabling infobars
 	        options1.addArguments("--disable-extensions"); // disabling extensions
 	        options1.addArguments("--disable-gpu"); // applicable to windows os only
 	        options1.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
 	        options1.addArguments("--no-sandbox"); // Bypass OS security model
 	        this.driver= new ChromeDriver(options1);
 	        this.htmlReporter = new ExtentHtmlReporter(REPORT_PATH + System.getProperty("file.separator") + "TestxSelenium.html");
 	        this.extent = new ExtentReports();
 	        this.extent.attachReporter(htmlReporter);
 	        this.extent.setSystemInfo("Host Name", "Akgun");
 	        this.extent.setSystemInfo("Environment", "Akgun HBYS WEB 4.0");
 	        this.extent.setSystemInfo("User Name", "ugur.yildiz");
 	        this.htmlReporter.config().setDocumentTitle("HBYS Giris");
 	        this.htmlReporter.config().setReportName("SeleniumTest");
 	        this.htmlReporter.config().setTheme(Theme.STANDARD);
 	    }
 	    
 	    
 		@Test
 	    public void Basla() throws Exception {
 			
 		   logger = extent.createTest("Giriş Ekranı.");
 		   logger.log(Status.INFO, "Test Başladı");
 		   
 			try {
 				Login login = new Login(this.driver,"https://testuft.akgunyazilim.com.tr/hbys-web/gen/anasayfa.htm", "Admin", "1");	
 				this.driver = login.getDriver();
 				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
 				logger.log(Status.PASS, "Sisteme Giriş Yapıldı.");
 				
 			}catch (Exception e){
 				 logger.log(Status.FAIL, "Sisteme Giriş yapılamadı.");
 		 	     logger.fail(e);
 		 	     junit.framework.Assert.fail();
 		 	     extent.flush();
				}
 			
 			
 			
 			logger.log(Status.INFO, "Test Bitti");
 			driver.quit();	
 			
 			
 		}
 		
 	
 	         public void loadProperties() {
 	             String fileName = System.getProperty("user.home") + System.getProperty("file.separator") + "jazz-selenium" + System.getProperty("file.separator") + "jazz.properties";
 	             Properties prop = new Properties();
 	             try {
 	                 prop.load(new FileInputStream(fileName));
 	                 DRIVER_PATH = prop.getProperty("DRIVER_PATH");
 	                 REPORT_PATH = prop.getProperty("REPORT_PATH");
 	             } catch (IOException ex) {
 	                 System.exit(1);
 	             }
 	         }
 	     }
 	          
 			 
 	        
 		
 		
 		













