package com.payload;

public class Payload {
	

	
	
	public static String loginBody() {
		String response ="{ \"username\": \"Athirad\", \"password\": \"jira@123\" }";
		
		return response;

	}

	public static String CreateIssuueBody() {
		String response="{\r\n" + 
				"    \"fields\":{\r\n" + 
				"        \"project\":\r\n" + 
				"        {\r\n" + 
				"            \"key\":\"JIR\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\":\"Rest assured\",\r\n" + 
				"        \"description\":\"first issue\",\r\n" + 
				"        \"issuetype\":{\r\n" + 
				"            \"name\":\"Bug\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
       
		return response;
	}
	
	
	
	public static  String AddCommentBody() {
		String response= "{\r\n" + 
				"    \"body\": \"Comment added\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
 
		return response;
	}
	
	
	
	public static String UpdateCommentBody() {
		String response="{\r\n" + 
				"    \"body\": \"Comment Updated\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		       return response;

	}
	
	
	
}
