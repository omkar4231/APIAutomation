package api.Endpoints;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoints2 {

	static ResourceBundle getUrl() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response createUser(User payload) {

		String post_url = getUrl().getString("post_url");
		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.when().post(post_url);
		return response;
	}

	public static Response getUser(String username) {
		String get_url = getUrl().getString("get_url");
		Response response = RestAssured.given().pathParam("username", username).when().get(get_url);
		return response;
	}

	public static Response updateUser(String username, User payload) {

		String update_url = getUrl().getString("update_url");
		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", username).body(payload).when().put(update_url);
		return response;
	}

	public static Response deleteUser(String username) {

		String delete_url = getUrl().getString("delete_url");
		Response response = RestAssured.given().pathParam("username", username).when().delete(delete_url);
		return response;
	}

}
