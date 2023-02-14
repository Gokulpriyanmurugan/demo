package Util;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class jiraserviceproviders {
	
	public JiraClient jira;
	public String project;
	
	public jiraserviceproviders(String jiraurl,String username,String password,String project) {
		
	BasicCredentials cred=new BasicCredentials(username,password);
	jira=new JiraClient(jiraurl,cred);
	this.project=project;
		
		
	}
	public void createJiraTickect(String issuetype,String summary,String description,String reportername) throws JiraException {
		FluentCreate create=jira.createIssue(project, issuetype); 
		create.field(Field.SUMMARY, summary);
		create.field(Field.DESCRIPTION,description);
		Issue newIssue=create.execute();
		System.out.println("new issue"+newIssue);
		
	}

}
