package restassured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MethodsRestAssured {

	static Response response;
	
	static Properties prop = new Properties();
	static FileInputStream input = null;
	private static Object obj = new Object();  
	
	public static Response getAll(String baseUri,String basePath) throws IOException  {	

		input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Datas.properties");	
		prop.load(input);
		RestAssured.baseURI=prop.getProperty(baseUri);
		RestAssured.basePath=prop.getProperty(basePath);
		response = RestAssured.given()
				//	.headers("Authorization",api.token)
				.headers("Accept","application/json")
				.headers("Content-Type","application/json")
				//	.headers("X-Infor-MongooseConfig","COINSTAR_TRN_"+site)
				.get();
		return response;
	}

	public static Response postResponse(String baseUri,String json,String site) {			

		response = RestAssured.given()
				//	.headers("Authorization",api.token)
				.headers("Accept","application/json")
				.headers("Content-Type","application/json")
				//	.headers("X-Infor-MongooseConfig","COINSTAR_TRN_"+site)	
				.body(json)
				.when()
				.post(baseUri);			

		return response;

	}

	public static Response putResponse(String baseUri,String json) {	

		response = RestAssured.given()
				//		.headers("Authorization",api.token)
				.headers("Accept","application/json")
				.headers("Content-Type","application/json")
				//	.headers("X-Infor-MongooseConfig","COINSTAR_DEM_DALS")	
				.body(json)
				.when()
				.put(baseUri);

		return response;

	}

	public static Response delResponse(String baseUri,String json) {	


		response = RestAssured.given()
				//	.headers("Authorization",api.token)
				.headers("Accept","application/json")
				.headers("Content-Type","application/json")
				//		.headers("X-Infor-MongooseConfig","COINSTAR_DEM_DALS")	
				.body(json)
				.when()
				.delete(baseUri);

		return response;
	}

	public static void waitFor(int waitTime) {

		synchronized (obj)    	        {   
			//use wailt() method to set obj in waiting state for two seconds  
			try {
				obj.wait(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}   	  
			System.out.println(obj + " Object is in waiting state and woken after "+waitTime+" seconds");   
		}   
	}

}
