package com.jiraApi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;



import com.payload.Payload;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraApi {
	
	
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8080";

		// Login Scenario
		
		SessionFilter session = new SessionFilter();
				
		given().header("content-type","application/json").body(Payload.loginBody()).filter(session)
		.when().post("/rest/auth/1/session").then().assertThat().statusCode(200);
		
		// Add bug
		
//		String response = given().header("content-type","application/json").body(Payload.CreateIssuueBody()).filter(session).when().post("/rest/api/2/issue").then().assertThat()
//		.statusCode(201).extract().response().asString();
//		
		
	//	System.out.println(response);
		
		//JsonPath js = new JsonPath(response);
		//String id =js.getString("id");
		//System.out.println(id);
		
		// add comment
		
		
		String response2=given().header("content-type","application/json").body(Payload.AddCommentBody()).pathParam("Key","10122").filter(session).when().post("/rest/api/2/issue/{Key}/comment").
		then().assertThat().statusCode(201).extract().response().asString();
		
		System.out.println(response2);
		JsonPath js1= new JsonPath(response2);
		String id2=js1.getString("id");
		System.out.println(id2);
		
		
		// update comment
		
//		given().pathParam("issueId","10119").pathParam("id",id2).header("content-type","application/json ").body(Payload.UpdateCommentBody()).filter(session)
//		.when().put("/rest/api/2/issue/{issueId}/comment/{id}").then().assertThat().statusCode(200);
//		System.out.println("update completed");
//		
		// Add file
//		
//		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("issueId","10119").
//		header("Content-Type","multipart/form-data").multiPart("file",new File("C:\\Users\\user\\eclipse-workspace\\JiraProject\\jira.txt"))
//		.when().post("/rest/api/2/issue/{issueId}/attachments").then().assertThat().statusCode(200);
//		
		
		// Get issues
		
		String response3 =given().filter(session).pathParam("Key", "10122").queryParam("fields","comment").
				when().get("/rest/api/2/issue/{Key}").then()
		.log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response3);
		
	}
	
	

}
