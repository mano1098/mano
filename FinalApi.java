package restassuredtestcases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;;

public class FinalApi {
	@Test (priority =1)
	public void testpostRegisterunsuccesfull() {
		
		baseURI ="https://gorest.co.in/public/v1/users"; 
		
		JSONObject reqData = new JSONObject();
		reqData.put("daniel","password");		
		System.out.println(reqData.toJSONString());
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)		
		.body(reqData.toJSONString())
		.when()
		.post("/login")
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
	
	
  @Test(priority =2)
	public void testpostUsersLoginUnsucessfull() {
		baseURI ="https://gorest.co.in/"; 
				
		JSONObject reqData = new JSONObject();
		reqData.put("email","xyz.");                 
		System.out.println(reqData.toJSONString());
		given()
		.header("Content-Type", "application/json")
		.header("connection", "keep-alive")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)		
		.body(reqData.toJSONString())
		.when()
		.post("/login")
		.then()
		.statusCode(400)
		.log().all();
		}
	
	@Test (priority =3)
	public void testpostUsersRegsitersucessfull() {
		baseURI ="https://reqres.in/api/register"; 
				
		JSONObject reqData = new JSONObject();
		reqData.put("email","eve.holt@reqres.in");
		reqData.put("password", "pistol");
		System.out.println(reqData.toJSONString());
		given()
		.header("Content-Type", "application/json")
		.header("connection", "keep-alive")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)		
	    .body(reqData.toJSONString())
		.when()
		.post("/register")
		.then()
		.statusCode(201)
		.log().all();
		
		
	}
	
	   
@Test(priority =4)
	
	public void testpostloginsucessfull() {
	baseURI ="https://reqres.in/api/register"; 
	
	JSONObject reqData = new JSONObject();
	reqData.put("email","eve.holt@reqres.in");
	reqData.put("password", "cityslicka");
	System.out.println(reqData.toJSONString());
	given()
	.header("Content-Type", "application/json")
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)		
    .body(reqData.toJSONString())
	.when()
	.post("/login")
	.then()
	.statusCode(201)
	.log().all();	
	}
@Test
public void testGetSingleResourcesNotFound() {
	baseURI= "https://reqres.in/api";
	given()
	.get("/unknown/23")
	.then()
	.statusCode(404)
	.log().all();
}
@Test
public void Get_SingleResource() {
baseURI = "https://reqres.in/api";
given()
.get("/unknown/2")
.then()
.statusCode(200)
.body("data.name", equalTo("fuchsia rose"))
.log().all();



}
@Test
public void ResourceListData() {
	baseURI= "https://reqres.in/api";
	given()
	.get("/unknown")
	.then()
	.statusCode(200)
	.body("data[0].name",equalTo("cerulean"))
	.body("data.pantone_value", hasItems("15-4020"))
		.log().all();
}

@Test
public void GetRequest_singleusernotfound()
{ baseURI = "https://reqres.in/api"; 
given()
.get("/users/23")
.then()
.statusCode(404)
.log()
.status();



}

}