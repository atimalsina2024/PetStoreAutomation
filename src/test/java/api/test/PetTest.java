package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;


import api.endpoints.PetEndpoint;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tags;
import api.utilities.PetDataProvider;
import io.restassured.response.Response;

public class PetTest {

	@Test(priority=1, dataProvider="allData", dataProviderClass=PetDataProvider.class)
	public void testCreatePet(String id, String category_id, String category_name, String name, String photoUrls, String tag_id, String tag_name, String status) {
		//create pet object
		Pet petPayload = new Pet();
		//create Category object and setting data
		Category category = new Category();
		category.setId(Integer.parseInt(category_id));
		category.setName(category_name);
		
		//create Tags object and set data
		Tags tags = new Tags();
		tags.setId(Integer.parseInt(tag_id));
		tags.setName(tag_name);
		//request  expects list of Tag object as pload
		ArrayList<Tags> tag = new ArrayList<Tags>();
		tag.add(tags);
		// request expects list of urls as plod
		ArrayList<String> urls = new ArrayList<String>();
		urls.add(photoUrls);
		//initializing Pet object
		petPayload.setCategory(category);
		petPayload.setId(Integer.parseInt(id));
		petPayload.setName(name);
		petPayload.setPhotoUrls(urls);
		petPayload.setTags(tag);
		petPayload.setStatus(status);
		
		PetEndpoint pe = new PetEndpoint();
		Response resp = pe.createPet(petPayload);
		resp.then().log().all();
		AssertJUnit.assertEquals(resp.getStatusCode(), 200);		
	}
	
	@Test(priority=2,dataProvider="idData", dataProviderClass=PetDataProvider.class)
	public void deletePet(String id) {		
		PetEndpoint pe = new PetEndpoint();
		Response resp = pe.deletePet(Integer.parseInt(id), "api_key");
		resp.then().log().all();
		AssertJUnit.assertEquals(resp.getStatusCode(), 200);
	}
	

}
