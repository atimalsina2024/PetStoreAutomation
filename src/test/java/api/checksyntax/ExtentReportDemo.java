package api.checksyntax;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	public static void main(String[] args) {
		
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		
	}

}
