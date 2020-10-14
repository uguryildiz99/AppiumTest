package testAppium;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report{

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;


	@BeforeSuite
	public void reportSetup() throws Exception {

		htmlReporter = new ExtentHtmlReporter("Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Android");
	    extent.setSystemInfo("Environment", "Software Testing ");
	    extent.setSystemInfo("User Name", "Uğur Yıldız");
	    htmlReporter.config().setDocumentTitle("Hesap Makinesi");
	    htmlReporter.config().setReportName("Çarpma İşlemi");
	    htmlReporter.config().setTheme(Theme.STANDARD);
	/*   
	    extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
	    ExtentTest suite = extent.createTest("Suite");
	    ExtentTest clazz = suite.createNode("Class");
	    clazz.createNode("Regression").pass("pass");
	    clazz.createNode("Unit").pass("fail");
	    clazz.createNode("Integration").pass("pass");
	*/
	    
	}


	public void addScreenShot(ExtentTest extentTest, String imagePath) throws IOException {
			 extentTest.addScreenCaptureFromPath("test-output/Hesap.png");
			}

	@AfterSuite
	public void reportTearDown() {
		extent.flush();
	}



}
