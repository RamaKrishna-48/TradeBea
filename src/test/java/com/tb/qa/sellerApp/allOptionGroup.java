package com.tb.qa.sellerApp;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tradebea.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class allOptionGroup extends TestBase{
	
	@BeforeClass
	void getMenus() throws InterruptedException {
		logger.info("****Strarted TC001_POST-LOGIN****");
		RestAssured.baseURI = "http://apticks.in/tradebea/";
		httpRequest = RestAssured.given();
		// httpRequest.header("Content-Type", ContentType);
		// httpRequest.header("APP_ID", userAppID);
		response = httpRequest.request(Method.GET, "catalogue/api/catalogue/option_groups");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	void chesckResponseBody() {
		logger.info("**checking Response Body**");
		String responseBody = response.getBody().asString();
		logger.info("response body==>" + responseBody);
		Assert.assertTrue(responseBody != null);
		System.out.println(responseBody);
	}

	@Test(priority = 2)
	void checkStatuscode() {
		logger.info("***Checking Status Code***");
		int statusCode = response.getStatusCode();
		logger.info("Status code is ==>" + statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println(statusCode);
	}
	
	

}
