package com.tb.profile;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tradebea.base.TestBase;
import com.trdaebea.utilities.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class sellerPageSignUp extends TestBase {

	@BeforeClass
	void registration() throws InterruptedException {
		logger.info("****Strarted TC001_POST-Register****");
		RestAssured.baseURI = "http://apticks.in/tradebea/";
		httpRequest = RestAssured.given();
		Thread.sleep(5000);
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "empdataprovider")
	void addRegistration(String first_name, String last_name, String gender, String mobile, String email,
			String password, String confirm_password, String group) {

		RequestSpecification httpRequest = RestAssured.given();

		// Here we created data which we can send along with the post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("first_name", first_name);
		requestParams.put("last_name", last_name);
		requestParams.put("gender", gender);
		requestParams.put("mobile", mobile);
		requestParams.put("email", email);
		requestParams.put("password", password);
		requestParams.put("confirm_password", confirm_password);
		requestParams.put("group", group);
		httpRequest.header("Content-Type", ContentType);
		//httpRequest.header("APP_ID", sellerAppID);

		// add the json to the body of the requestcc
		httpRequest.body(requestParams.toJSONString());

		// post request
		response = httpRequest.request(Method.POST, "auth/api/auth/create_user/seller");

		// capture response body perform validations

		String responseBody = response.getBody().asString();

		System.out.println("Response Body is:" + responseBody);

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}

	@DataProvider(name = "empdataprovider")
	String[][] getRegData() throws IOException {

		// Read data from excell
		String path = System.getProperty("user.dir") + "/ExcellData/TradeBeaApiTest.xlsx";

		int rownum = XLUtils.getRowCount(path, "SellerPageSignUp");
		int colcount = XLUtils.getCellCount(path, "SellerPageSignUp", 1);

		String empdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empdata[i - 1][j] = XLUtils.getCellData(path, "SellerPageSignUp", i, j);
			}
		}

		return (empdata);
	}
}
