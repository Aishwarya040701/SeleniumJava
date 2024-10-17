package com.restassured;

import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiRestAssured {
	
	Response response;

	@Test
	public void Http() {
		APIHelper apiHelper = new APIHelper("PostbaseURI");
		File file = new File("src/test/resources/Utilities/PostApiJsonData.json");
		String jsonData = null;
		try {
			jsonData = FileUtils.readFileToString(file, "UTF-8");

			System.out.println("Request Data " + jsonData);

			response = apiHelper.create(jsonData);
			System.out.println("Response Data " + response.body().asPrettyString());
			Assert.assertEquals(response.statusCode(), 201);

			Users users = apiHelper.getUsers(response.getBody().asPrettyString());
			System.out.println("User data");
			System.out.println(users.getId());
			System.out.println(users.getName());
			System.out.println(users.getEmail());
			System.out.println(users.getGender());
			System.out.println(users.getStatus());

			users.setName("Ziya modified");

			response = apiHelper.update(users.getId(), apiHelper.getJson(users));
			System.out.println("Update " + response.getBody().asPrettyString());
			Assert.assertEquals(response.statusCode(), 200);

			response = apiHelper.delete(users.getId());
			Assert.assertEquals(response.statusCode(), 204);

			response = apiHelper.getUserById(users.getId());
			Assert.assertEquals(response.statusCode(), 404);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
