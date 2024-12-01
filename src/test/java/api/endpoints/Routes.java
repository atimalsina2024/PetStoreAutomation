package api.endpoints;

/**
 * user
 * 
 * POST https://petstore.swagger.io/v2/user/createWithList Creates list of users
 * with given input array
 * 
 * GET https://petstore.swagger.io/v2/user/{username} Get user by user name
 * 
 * PUT https://petstore.swagger.io/v2/user/{username} Updated user
 * 
 * DELETE https://petstore.swagger.io/v2/user/{username} Delete user
 * 
 * GET https://petstore.swagger.io/v2/user/login Logs user into the system
 * 
 * GET https://petstore.swagger.io/v2/user/logout Logs out current logged in
 * user session
 * 
 * POST https://petstore.swagger.io/v2/user/createWithArray Creates list of
 * users with given input array
 * 
 * POST https://petstore.swagger.io/user Create user
 **/
public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";

	// User module
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
	//Pet module
	public static String pet_post_url = base_url+"/pet";
	public static String pet_put_url = base_url+"/pet";
	public static String pet_get_url = base_url+"/pet/{petId}";
	public static String pet_delete_url = base_url+"/pet/{petId}";



}
