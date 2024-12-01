package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		Response resp = UserEndPoint.createUser(userPayload);
		resp.then().log().all();
		AssertJUnit.assertEquals(resp.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void getUserByName() {
		
		Response resp = UserEndPoint.readUser(this.userPayload.getUsername());
		resp.then().log().all();
		AssertJUnit.assertEquals(resp.getStatusCode(), 200);
		
	}

}
