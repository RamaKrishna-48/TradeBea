package com.tb.qa.comman;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tradebea.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class getMenusId extends TestBase{
	@BeforeClass
	void getMenus() throws InterruptedException {
		logger.info("****Strarted TC002_GET-MENUS****");
		RestAssured.baseURI="http://apticks.in/tradebea/";
		httpRequest = RestAssured.given();
		response=httpRequest.request(Method.GET, "catalogue/api/catalogue/menus/menus_id");
		Thread.sleep(5000);
	}

	@Test
	void chesckResponseBody() {
		logger.info("**checking Response Body**");
		String responseBody =response.getBody().asString();
		logger.info("response body==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
		System.out.println(responseBody);
	}
	@Test
	void checkStatuscode() {
		logger.info("***Checking Status Code***");
		int statusCode=response.getStatusCode();
		logger.info("Status code is ==>"+ statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println(statusCode);
	}
}
