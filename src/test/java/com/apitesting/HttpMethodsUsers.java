package com.apitesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HttpMethodsUsers {
	APIHelper apiHelper = new APIHelper("UsersbaseURI");
	File file = new File("src/test/resources/Utilities/UserApiJsonData.json");
	Response response;

	@Test
	public void GetTest() {

		response = apiHelper.getUser();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getBody().asPrettyString());
	}

	@Test
	public void postTest() {

		String jsonData = null;
		try {
			jsonData = FileUtils.readFileToString(file, "UTF-8");

			System.out.println("Request Data " + jsonData);

			response = apiHelper.create(jsonData);
			System.out.println("Response Data " + response.body().asPrettyString());
			Assert.assertEquals(response.statusCode(), 201);

			Users users = (Users) apiHelper.getUsersGeneric("UsersApi", response.getBody().asPrettyString());
			System.out.println("User data");
			System.out.println(users.getId());
			System.out.println(users.getName());
			System.out.println(users.getEmail());
			System.out.println(users.getGender());
			System.out.println(users.getStatus());

			// Response verification
			Assert.assertEquals(users.getName(), "Ziva");
			Assert.assertEquals(users.getEmail(), "Ziva43@gmail.com.example");
			Assert.assertEquals(users.getGender(), "female");
			Assert.assertEquals(users.getStatus(), "active");

			apiHelper.delete(users.getId());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void putTest() {
		String jsonData = null;
		try {
			jsonData = FileUtils.readFileToString(file, "UTF-8");

			System.out.println("Request Data " + jsonData);

			response = apiHelper.create(jsonData);
			System.out.println("Response Data " + response.body().asPrettyString());
			Assert.assertEquals(response.statusCode(), 201);

			Users users = (Users) apiHelper.getUsersGeneric("UsersApi", response.getBody().asPrettyString());
			users.setName("Ziva Modifiied");

			response = apiHelper.update(users.getId(), apiHelper.getJsonDataGeneric(users));
			System.out.println("Update " + response.getBody().asPrettyString());
			Assert.assertEquals(response.statusCode(), 200);

			// Response verification
			Assert.assertEquals(users.getName(), "Ziva Modifiied");
			Assert.assertEquals(users.getEmail(), "Ziva43@gmail.com.example");
			Assert.assertEquals(users.getGender(), "female");
			Assert.assertEquals(users.getStatus(), "active");

			apiHelper.delete(users.getId());

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void deleteTest() {

		String jsonData = null;
		try {
			jsonData = FileUtils.readFileToString(file, "UTF-8");

			System.out.println("Request Data " + jsonData);

			response = apiHelper.create(jsonData);
			System.out.println("Response Data " + response.body().asPrettyString());
			Assert.assertEquals(response.statusCode(), 201);

			Users users = (Users) apiHelper.getUsersGeneric("UsersApi", response.getBody().asPrettyString());

			response = apiHelper.delete(users.getId());
			Assert.assertEquals(response.statusCode(), 204);

			response = apiHelper.getUserById(users.getId());
			Assert.assertEquals(response.statusCode(), 404);

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}