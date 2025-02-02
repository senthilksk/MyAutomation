package restassured;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.devtools.v130.debugger.Debugger.RestartFrameMode;

public class restPgm extends MethodsRestAssured{
	
	JSONParser jsonParser = new JSONParser();
	JSONObject jsonObject = null;
	JSONArray jsonArray = null;

	@Test(enabled = true)
	public void getRest() {		

		RestAssured.baseURI ="https://reqres.in/api/users";

		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		Response response = get("?page=2");

		System.out.println(response.contentType());		
		System.out.println(response.getTime());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());	
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.asPrettyString());
		System.out.println("===================================================");
		ResponseBody responsebody = response.getBody();
		System.out.println(responsebody.asPrettyString());
		System.out.println("===================================================");
		ResponseBody body = response.body();
		System.out.println(body.asPrettyString());
	}

	@Test(enabled = false)
	public void valGetRest() {
		// then() is used for validation. so we cant use Response. so using ValidatableResponse
		ValidatableResponse resp = given().get("https://reqres.in/api/users?page=2").then().statusCode(200);

		//otherwise need to do type cast
		Response response = (Response) given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data[0].id",equalTo(7));
	}

	@Test(enabled = true)
	public void jsonPathGetRest() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		JsonPath jsonpath=response.jsonPath();
		int i=jsonpath.get("data[0].id");
		LinkedHashMap linkedHashMap=(jsonpath.get("data[0]"));
		System.out.println(linkedHashMap);
		System.out.println(i);

	}

	@Test(enabled = true)
	public void postRest() {

		baseURI ="https://reqres.in";
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("name", "senthil");
		jsonobject.put("job", "qa");		
		System.out.println(jsonobject.toString());

		Response response=	given()
				.header("Content.Type","application/json")
				.contentType(ContentType.JSON)
				.body(jsonobject.toString())
				.post("/api/users");

		System.out.println(response.asPrettyString());
	}

	@Test
	public void hamcrestMatchets() {
		get("https://reqres.in/api/users?page=2").then().time(lessThan(5L),TimeUnit.SECONDS);
		get("https://reqres.in/api/users?page=2").then().body("data", hasSize(6));
	}

	@Test()
	public void jsonSchemaVal() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("MyJson.json")).statusCode(200);
	}
	
	@Test(enabled = true)
	public void usingReqSpec() {
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users?page=2";
		RequestSpecification spec = RestAssured.given();
		Response response = spec.get();		
		JsonPath jsonpath=response.jsonPath();
		int i=jsonpath.get("data[0].id");
		LinkedHashMap linkedHashMap=(jsonpath.get("data[0]"));
		System.out.println(linkedHashMap);
		System.out.println(i);
		
		 response = spec.request(Method.GET,RestAssured.basePath);
		System.out.println(i=jsonpath.get("data[1].id"));
	}
	
	@Test(enabled = true)
	public void getRestFromCommon() throws IOException, ParseException, IllegalArgumentException, IllegalAccessException {			
		
		//Response response =getAll("https://reqres.in/api/users", "?page=2");
		Response response =getAll("BaseUri", "GetBasePath");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.asPrettyString());
		jsonObject = (JSONObject) jsonParser.parse(response.asString());	
		System.out.println(jsonObject.get("total"));
		 jsonArray = (JSONArray) jsonObject.get("data");
			System.out.println(jsonArray.size());	
			
			for(int i=0;i<jsonArray.size();i++)		{	{
				System.out.println(jsonArray.get(i));
				jsonObject = (JSONObject) jsonArray.get(i);					
			}
			jsonObject = (JSONObject) jsonArray.get(3);	
			System.out.println((String)jsonObject.get("email"));
			} 
	}	
				
	

}

// post  url + body  - create
// put   url with particular item + body  - create data/update particular field
// patch url with particular item + body  - create/update/delete particular field
