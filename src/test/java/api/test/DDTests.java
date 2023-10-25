package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints.userEndpoints;
import api.payload.User;
import api.utilities.dataProvider1;
import api.utilities.dataprovider;
import io.restassured.response.Response;

public class DDTests {

	@Test(dataProvider = "Data", dataProviderClass = dataprovider.class)
	public void testPostUser(String UserID, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone) {
		User payload = new User();
		payload.setId(Integer.parseInt(UserID));
		payload.setUsername(Username);
		payload.setFirstname(Firstname);
		payload.setLastname(Lastname);
		payload.setEmail(Email);
		payload.setPassword(Password);
		payload.setPhone(Phone);

		Response response = userEndpoints.createUser(payload);
		response.then().log().all();
	}
}
