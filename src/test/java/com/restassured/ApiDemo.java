////package com.restassured;
////
////import io.restassured.response.Response;
////import static io.restassured.RestAssured.*;
////import static org.testng.Assert.assertEquals;
////import java.io.File;
////import java.io.IOException;
////
////import org.apache.commons.io.FileUtils;
////import org.json.simple.JSONObject;
////import org.testng.Assert;
////import org.testng.annotations.Test;
////
////public class ApiDemo {
////	APIHelper apiHelper = new APIHelper();
////	Response response;
////
//	@Test
//	public void Get() {
////		RestAssured.get("https://reqres.in/api/users?page=2");
//		Response response = get("https://reqres.in/api/users?page=2");
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.getContentType());
//		
//////		
//////	}
//////	

//	@Test
//	public void Get2() {
//		baseURI="https://gorest.co.in/public/v2";
//		given().get("/users")
//		.then()
//	}
		
		
	
//	@Test
//	public void post() {
////		JSONObject param=new JSONObject();
////		param.put("name", "morpheus");
////		param.put("job", "leader");
//		given().body(param.toJSONString())
////		.when().post("https://reqres.in/api/users").then().statusCode(201);
////		given().header("Autorization", "bearer f3c81051676ab022e6f81380fa8c2910b9dfdebe73a993fa6736320cecb26aea");
//		JSONObject param = new JSONObject();
//		param.put("name", "Arya");
//		param.put("email", "Arya23@gmail.com");
//		param.put("gender", "Female");
//		param.put("status", "active");
//
//		Response response = given().header("Content-Type", "application/json")
//				.header("Authorization", "Bearer f3c81051676ab022e6f81380fa8c2910b9dfdebe73a993fa6736320cecb26aea")
//	
//
//				.when().body(param.toJSONString()).post("https://gorest.co.in/public/v2/users").then().extract().response();
//
//		assertEquals(response.statusCode(), 201);
//		System.out.println(response.body().asPrettyString());
////		
//		}
////	}
////
////	@Test
//	public void postQueryParam() {
//
//		Response response = given().header("Content-Type", "application/json")
//				.header("Authorization", "Bearer f3c81051676ab022e6f81380fa8c2910b9dfdebe73a993fa6736320cecb26aea")
//				.queryParam("name", "Arya").queryParam("email", "Arya45@gmail.com").queryParam("gender", "Female")
//				.queryParam("status", "active").when().post("https://gorest.co.in/public/v2/users").then().extract()
//				.response();
////
////		assertEquals(response.statusCode(), 201);
////		System.out.println(response.body().asPrettyString());
////
////	}
////
////	@Test
////	public void HttpMethod() throws IOException {
////		Response response;
////		APIHelper apiHelper = new APIHelper();
////		JSONObject param = new JSONObject();
////		param.put("name", "Arya Arj");
////		param.put("email", "Ar@gmail.com");
////		param.put("gender", "Female");
////		param.put("status", "active");
////
////		JSONObject param2 = new JSONObject();
////		param.put("id", "3950312");
////		param.put("name", "Zara");
////		param.put("email", "Zara@example");
////		param.put("gender", "Female");
////		param.put("status", "active");
//////		 response = apiHelper.getUser();
//////		 System.out.println(response.body().asPrettyString());
//////		 Assert.assertEquals(response.statusCode(), 200);
////////		 
//////		 response=apiHelper.getUserById("3944147");
//////		 Assert.assertEquals(response.statusCode(), 200);
//////		 System.out.println(response.body().asPrettyString());
//////		 
//////		 File file=new File("propertiesFile//JsonData.json");
//////			
//////			String JsonData=FileUtils.readFileToString(file,"UTF-8");
////
//////		System.out.println(param.toJSONString());
//////		 response=apiHelper.create(JsonData);
//////		 Assert.assertEquals(response.statusCode(), 201);
//////		// System.out.println(response.statusCode());
//////		 System.out.println(response.body().asPrettyString());
////
//////		 response=apiHelper.update("3950312",param2.toJSONString());
//////		 System.out.println(response.body().asPrettyString());
////
////		response = apiHelper.delete("3950312");
////		System.out.println(response.statusCode());
////		Assert.assertEquals(response.statusCode(), 204);
////
////		response = apiHelper.getUserById("3950312");
////		Assert.assertEquals(response.statusCode(), 404);
////	}
////
////	@Test
////	public void Http() throws IOException {
////
////		File file = new File("propertiesFile//JsonData.json");
////		String jsonData = FileUtils.readFileToString(file, "UTF-8");
////		System.out.println("Request Data " + jsonData);
////
////		response = apiHelper.create(jsonData);
////		System.out.println("Response Data " + response.body().asPrettyString());
////		Assert.assertEquals(response.statusCode(), 201);
////
////		Users users = apiHelper.getUsers(response.getBody().asPrettyString());
////		System.out.println("User data");
////		System.out.println(users.getId());
////		System.out.println(users.getName());
////		System.out.println(users.getEmail());
////		System.out.println(users.getGender());
////		System.out.println(users.getStatus());
////
////		users.setName("Zoya modified");
////		response = apiHelper.update(users.getId(), apiHelper.getJson(users));
////		System.out.println("Update " + response.getBody().asPrettyString());
////		Assert.assertEquals(response.statusCode(), 200);
////
////		response = apiHelper.delete(users.getId());
////		Assert.assertEquals(response.statusCode(), 204);
////
////	}
////
////}
