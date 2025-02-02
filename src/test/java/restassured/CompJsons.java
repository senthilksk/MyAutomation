package restassured;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompJsons {

	String json1 = " {\r\n"
			+ "\"name\":\"John\",\r\n"
			+ "\"age\":30,\r\n"
			+ "\"cars\":[\"Ford\", \"BMW\", \"Fiat\"]\r\n"
			+ "}";

	String json2 = " {\r\n"
			+ "\"name\":\"Joh\",\r\n"
			+ "\"age\":30,\r\n"
			+ "\"cars\":[\"Ford\", \"BMW\", \"Fiat\"]\r\n"
			+ "}";


	String json3 = "{\r\n"
			+ "\"name\":\"John\",\r\n"
			+ "\"cars\":[\"Ford\", \"BMW\", \"Fiat\"],\r\n"
			+ "\"age\":30\r\n"		
			+ "}";

	String json4 = "{\r\n"
			+ "\"name\":\"John\",\r\n"
			+ "\"cars\":[\"BMW\", \"Ford\", \"Fiat\"],\r\n"
			+ "\"age\":30\r\n"		
			+ "}";
	
	String json5 = "{\r\n"
			+ "\"name\":\"John\",\r\n"
			+ "\"cars\":[\"Ford\", \"Bmw\", \"Fiat\"],\r\n"
			+ "\"age\":30\r\n"		
			+ "}";


	@Test
	public void cmpJsons() throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapping = new ObjectMapper();

		JsonNode node1 = mapping.readTree(json1);  	// Parent json
		JsonNode node2 = mapping.readTree(json2);	// Diff json
		JsonNode node3 = mapping.readTree(json3);	// key position json
		JsonNode node4 = mapping.readTree(json4);	// array value position  diff	
		JsonNode node5 = mapping.readTree(json5);	// array value case  diff	


		System.out.println("Compare 2 diff jsons euqal ? " + node1.equals(node2));		
		System.out.println("Compare same jsons key alignment diff euqal ? "+node1.equals(node3));
		System.out.println("Compare same jsons array values position diff "+node3.equals(node4)); 
		System.out.println("Compare same jsons array values position diff "+node3.equals(node5)); 
	}

}
