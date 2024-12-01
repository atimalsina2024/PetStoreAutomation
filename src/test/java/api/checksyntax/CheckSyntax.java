package api.checksyntax;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;

import com.github.javafaker.Faker;

import api.endpoints.PetEndpoint;
import api.endpoints.Routes;
import api.endpoints.UserEndPoint;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tags;
import api.payload.User;
import io.restassured.response.Response;

public class CheckSyntax {

	static Faker fake = new Faker();
	static User payload = new User();
	static Pet petData = new Pet();

	public static void createTestData() {

		payload.setId(fake.idNumber().hashCode());
		payload.setUsername(fake.name().username());
		payload.setFirstName(fake.name().firstName());
		payload.setLastName(fake.name().lastName());
		payload.setEmail(fake.internet().safeEmailAddress());
		payload.setPassword(fake.internet().password(5, 10));
		payload.setPhone(fake.phoneNumber().cellPhone());
	}

	public static void testPostUser() {

		Response resp = UserEndPoint.createUser(payload);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().asString());

	}

	public static void createPetData() {

		Category category = new Category();
		category.setId(1);
		category.setName("category-name");
		Tags tagsData = new Tags();
		tagsData.setId(1);
		tagsData.setName("tag-name");
		ArrayList<Tags> tags = new ArrayList<Tags>();
		tags.add(tagsData);
		petData.setCategory(category);
		petData.setId(100);
		petData.setName("pet-name");
		petData.setTags(tags);
		ArrayList<String> testUrls = new ArrayList<String>();
		testUrls.add("test-url");
		petData.setPhotoUrls(testUrls);
		petData.setStatus("avalable");
	}

	public static void testPostPet() {
		PetEndpoint pe = new PetEndpoint();
		Response resp = pe.createPet(petData);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().asString());

	}

	public static void main(String[] args) {
		createPetData();
		testPostPet();
	}

}
