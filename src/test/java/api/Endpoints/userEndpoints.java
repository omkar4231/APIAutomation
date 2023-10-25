package api.Endpoints;

import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoints {

	//create for performing create , read , update and deleting operation 
	
	public static Response createUser(User payload){
		
	Response response =	RestAssured.given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   .when()
		   .post(Routes.post_url);
	  return response ;
	}
	
	public static Response getUser(String username) {
		Response response =	RestAssured.given()
			   .pathParam("username", username)
			   .when()
			   .get(Routes.get_url);
		  return response ;
		}
	
	public static Response updateUser(String username , User payload) {
		Response response =	RestAssured.given()
			   .contentType(ContentType.JSON)
			   .accept(ContentType.JSON)
			   .pathParam("username",username)
			   .body(payload)
			   .when()
			   .put(Routes.get_url);
		  return response ;
		}
	
	public static Response deleteUser(String username ) {
	   	Response response =	RestAssured.given()
			   .pathParam("username",username)
			   .when()
			   .delete(Routes.get_url);
		  return response ;
		}
	
}
