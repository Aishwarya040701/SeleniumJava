package com.apitesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HttpMethodsPosts {
	APIHelper apiHelper = new APIHelper("PostbaseURI");
	File file = new File("src/test/resources/Utilities/PostApiJsonData.json");
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

			Posts posts = (Posts) apiHelper.getUsersGeneric("PostsApi", response.getBody().asPrettyString());
			System.out.println("User data");
			System.out.println(posts.getId());
			System.out.println(posts.getUser_id());
			System.out.println(posts.getTitle());
			System.out.println(posts.getBody());

			Assert.assertEquals(posts.getUser_id(), "3947456");
			Assert.assertEquals(posts.getTitle(), "Books");
			Assert.assertEquals(posts.getBody(), "Action");

			response = apiHelper.delete(posts.getId());

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

			Posts posts = (Posts) apiHelper.getUsersGeneric("PostsApi", response.getBody().asPrettyString());
			posts.setBody("Action Books Modified");

			response = apiHelper.update(posts.getId(), apiHelper.getJsonDataGeneric(posts));
			System.out.println("Update " + response.getBody().asPrettyString());

			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(posts.getBody(), "Action Books Modified");
			Assert.assertEquals(posts.getUser_id(), "3947456");
			Assert.assertEquals(posts.getTitle(), "Books");

			response = apiHelper.delete(posts.getId());

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

			Posts posts = (Posts) apiHelper.getUsersGeneric("PostsApi", response.getBody().asPrettyString());

			response = apiHelper.delete(posts.getId());
			Assert.assertEquals(response.statusCode(), 204);

			response = apiHelper.getUserById(posts.getId());
			Assert.assertEquals(response.statusCode(), 404);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}