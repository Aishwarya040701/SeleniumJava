package com.restassured;

import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.util.Properties;

import com.apitesting.Posts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {
	RequestSpecification requestSpecification;
	public static Properties properties = new Properties();
	ObjectMapper objectMapper = new ObjectMapper();
	
	

	public APIHelper(String urlKey) {
		loadProperties();
		requestSpecification = new RequestSpecBuilder().setBaseUri(properties.getProperty(urlKey))
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", properties.getProperty("token")).build();

	}

	public Response getUser() {
		return given(requestSpecification).when().get();

	}

	public Response getUserById(String userId) {
		return given(requestSpecification).when().basePath(userId).get();

	}

	public Response create(String jsonData) {
		return given(requestSpecification).body(jsonData).when().post();

	}

	public Response update(String userId, String jsonData) {
		return given(requestSpecification).when().basePath(userId).body(jsonData).put();

	}

	public Response delete(String userId) {
		return given(requestSpecification).when().basePath(userId).delete();

	}

	public static void loadProperties() {
		try {
			FileInputStream file = new FileInputStream("src/test/resources/Utilities/ApiUtility.properties");
			properties.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Users getUsers(String jsonData) {

		Users users = null;

		try {
			users = objectMapper.readValue(jsonData, Users.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return users;

	}

	public String getJson(Users userData) {

		String jsonData = null;
		try {
			jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonData;

	}
	
	public Posts getPosts(String jsonData) {

		Posts posts = null;

		try {
			posts = objectMapper.readValue(jsonData, Posts.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return posts;

	}

	public String getPostJson(Posts postData) {

		String jsonData = null;
		try {
			jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(postData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonData;

	}

}
