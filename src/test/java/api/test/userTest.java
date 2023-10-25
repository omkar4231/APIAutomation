package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.userEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class userTest {

	public Logger logger;
	Faker faker;
	User payload;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();
		payload = new User();
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPassword(faker.internet().password(5, 11));
		payload.setPhone(faker.phoneNumber().cellPhone());

		logger = LogManager.getLogger(this.getClass());
		logger.debug("debugging........");
	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("***********creating user***************");
		// it will create the user profile
		Response res = userEndpoints.createUser(payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("***********User Created***************");
	}

	@Test(priority = 2)
	public void testGetUser() {
		logger.info("***********Reading user info***************");
		// it will get the user data information
		Response res = userEndpoints.getUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("***********User info is displayed***************");
	}

	@Test(priority = 3)
	public void testUpdateUser() {

		// this will change the only data from payload body for updating the user
		// profile
		logger.info("***********Upadting User***************");
		payload.setUsername(faker.name().username());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());

		Response res = userEndpoints.updateUser(this.payload.getUsername(), payload);
		Assert.assertEquals(res.getStatusCode(), 200);

		Response resafterupdate = userEndpoints.getUser(this.payload.getUsername());
		resafterupdate.then().log().all();
		Assert.assertEquals(resafterupdate.getStatusCode(), 200);
		logger.info("***********User info is Updated***************");
	}

	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("***********Deleting the User info***************");
		// this will delete the user data based on username
		Response res = userEndpoints.updateUser(this.payload.getUsername(), payload);
		Assert.assertEquals(res.getStatusCode(), 200);

		Response resafterdeletion = userEndpoints.getUser(this.payload.getUsername());
		resafterdeletion.then().log().all();
		Assert.assertEquals(resafterdeletion.getStatusCode(), 200);
		logger.info("***********User info is Deleted***************");
	}

}
