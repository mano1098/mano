package restassuredtestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class RestAssuredAssignment2 {
	@Test
	public void test() {
		 
			baseURI ="https://reqres.in/api/register"; 
			
			JSONObject reqData = new JSONObject();
			reqData.put("email","eve.holt@reqres.in");
			reqData.put("password", "cityslicka");
			System.out.println(reqData.toJSONString());
				given()
					.header("Content-Type","application/json")
					.header("charset", "utf-8")
					.header("Connection","Keep-alive")
					.accept(ContentType.JSON)
					.when()
					.post("/register")
					.then()
					.statusCode(200)
					.log().all();
	
	
	String tokeninfo = given()
                  .body(reqData.toJSONString())		
                  .contentType(ContentType.JSON)
                  .accept(ContentType.JSON)
                  .header("charset","utf-8")
                  .when()
                  .post("/register")
                  .then()
                  .extract().path("token");
	              System.out.println("TOKEN :"+ tokeninfo);
	              
	             String userID = given()
	             .body(reqData.toJSONString())
	             .contentType(ContentType.JSON)
	             .accept(ContentType.JSON)
	             .header("charset", "utf-8")
	             .when()
	             .post("/register")
	             .then()
	             .extract().path("id");
	             System.out.println("ID: +userID");
	             
	             given()
	             
	             .header("Content-Type","application/json")
					.header("Connection","Keep-alive")
					.accept(ContentType.JSON)
					.body(reqData.toJSONString())
					.when()
					.post("/login")
					.then()
					.statusCode(200)
					.log().all();
	             
	             String Logintoken = given()
	            		 .body(reqData.toJSONString())
	    	             .contentType(ContentType.JSON)
	    	             .accept(ContentType.JSON)
	    	             .header("charset", "utf-8")
	    	             .when()
	    	             .post("/login")
	    	             .then()
	    	             .extract().path("token");
	             System.out.println("TOKEN :" +Logintoken);
	             given()
	             .get("/users/" + userID)
	             .then()
	             .statusCode(200)
	             .body("data.id",equalTo(4))
	             
	             .body("data.first_name",equalTo("Eve"))
	             
	             .body("data.last_name", equalTo("Holt"))
	             .body("data.email", equalTo("Eve.Holt@resreq.in"))
	             .log().body();
	             
	             given()
	             .get("/unknown/" +userID)
	             .then()
	             .body("data.id",equalTo(4))
	             .body("data.name", equalTo("aqua sky"))
	             .log().everything();
	             
                 when()
                 .delete("/users/" + userID)
                 .then()
                 .statusCode(204)
                 .log().ifStatusCodeIsEqualTo(204);
                 System.out.println(userID = ":Deleted successfully");
                 given()
                 .get("/users/" + userID)
                 .then()
                 .statusCode(200)
                 .body("data.id",equalTo(4))
                 .log().body();
                 
	}

	}	 
	            		 
					
	             
	             
	             
	             
	  
	
			



