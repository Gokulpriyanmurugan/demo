package Listner;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Util.jirapolicy;
import Util.jiraserviceproviders;
import net.rcarz.jiraclient.JiraException;

public class TestJiraListner implements ITestListener {
	
	public void TestFailure(ITestResult result) throws JiraException {
		
		jirapolicy jira=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(jirapolicy.class);
		boolean isticketready=jira.loginTicketReady();
		if(isticketready) {
			System.out.println("ticket is ready"+isticketready);
			jiraserviceproviders jiraSp=new jiraserviceproviders("https://gokulpriyan.atlassian.net","gokulpriyan810@gmail.com","Gokul@1234","Pm");
			String summ=result.getMethod().getConstructorOrMethod().getMethod().getName()+"resulst get failed";
			String disc=result.getThrowable().getMessage();
			disc.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			jiraSp.createJiraTickect("Bug", summ, disc,"gokul");
			
			
		}
		
	}	
	
}
