package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extents;
	public ExtentTest test;
	String repname;
	
	
	public void onStart(ITestContext context)
	{
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //this will exetcute before
		                                           //thetest
		 repname ="Test-Report-"+timeStamp+".html"; 
		 sparkReporter = new ExtentSparkReporter(".\\report\\"+repname);
		 sparkReporter.config().setDocumentTitle("APIAutomationProject");
		 sparkReporter.config().setReportName("Pet store Users API");
		 sparkReporter.config().setTheme(Theme.STANDARD);
		 
		 extents = new ExtentReports();
		 extents.attachReporter(sparkReporter);
		 extents.setSystemInfo("Application","Pet store Users API");
		 extents.setSystemInfo("Operating System",System.getProperty("os.name"));
		 extents.setSystemInfo("User Name", System.getProperty("user.name"));
		 extents.setSystemInfo("Enviornment","QA");
		 extents.setSystemInfo("user","omkar");
	    }
	
		public void onTestSucess(ITestResult result) {
			test = extents.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.createNode(result.getName());
			test.log(Status.PASS, "Test Passed");
			test.log(Status.PASS,result.getThrowable().getMessage());
		}
		 
		public void onTestFailure(ITestResult result) {
			test = extents.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.createNode(result.getName());
			test.log(Status.FAIL, "Test Failed");
			test.log(Status.FAIL,result.getThrowable().getMessage());
		}
		
		public void onTestSkipped(ITestResult result) {
			test = extents.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.createNode(result.getName());
			test.log(Status.SKIP, "Test Skipped");
			test.log(Status.SKIP,result.getThrowable().getMessage());
		}
		
		
		//if  we don't call this flush method it will not generate the report
		public void onFinish(ITestContext context)
		{
				
			extents.flush();
		}
		 
		 
	     
	}

