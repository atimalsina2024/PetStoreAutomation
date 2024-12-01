package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

//1. create pet
//2. get pet
//3. update pet
//4. delete pet

public class PetEndpoint {

	//create pet
	public Response createPet(Pet payload) {
		Response resp = 
				given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		.when().post(Routes.pet_post_url);
		return resp;
	}
	//get pet with petId
	public Response getPet(int petId) {
		Response resp = given().accept(ContentType.JSON).pathParam("petId", petId)
		.when().get(Routes.pet_get_url);
		return resp;
	}
	//update pet
	public Response updatePet(Pet payload) {
		Response resp = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)
		.when().put(Routes.pet_put_url);
		return resp;
	}
	//delete pet
	public Response deletePet(int petId, String api_key) {
		Response resp = given().header("api_key", api_key).accept(ContentType.JSON).pathParam("petId", petId)
		.when().delete(Routes.pet_delete_url);
		return resp;
	}

}
