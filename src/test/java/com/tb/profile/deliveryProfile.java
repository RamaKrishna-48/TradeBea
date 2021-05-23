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

public class deliveryProfile extends TestBase {
	@BeforeClass
	void deliverPrifile() throws InterruptedException {
		logger.info("****Strarted TC001_POST-Delivery****");
		RestAssured.baseURI = "http://apticks.in/tradebea/";
		httpRequest = RestAssured.given();
		Thread.sleep(5000);
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "empdataprovider")
	void addRegistration(String first_name, String last_name, String middle_name, String gender, String address,
			String aadhar_number, String driving_license_number, String mobile, String email, String aadhar_card_image,
			String driving_license_image, String electricity_bill_image, String profile_image, String group) {

		RequestSpecification httpRequest = RestAssured.given();

		// Here we created data which we can send along with the post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("first_name", first_name);
		requestParams.put("last_name", last_name);
		requestParams.put("middle_name", middle_name);
		requestParams.put("gender", gender);
		requestParams.put("address", address);
		requestParams.put("aadhar_number", aadhar_number);
		requestParams.put("driving_license_number", driving_license_number);
		requestParams.put("mobile", mobile);
		requestParams.put("email", email);
		requestParams.put("aadhar_card_image", aadhar_card_image);
		requestParams.put("driving_license_image", driving_license_image);
		requestParams.put("electricity_bill_image", electricity_bill_image);
		requestParams.put("profile_image", profile_image);
		requestParams.put("group", group);

		httpRequest.header("Content-Type", ContentType);
		httpRequest.header("X_AUTH_TOKEN", X_AUTH_TOKEN);

		// add the json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		// post request
		response = httpRequest.request(Method.POST, "auth/api/users/profile/u/delivery");

		// capture response body perform validations

		String responseBody = response.getBody().asString();

		System.out.println("Response Body is:" + responseBody);

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 203);
	}

	@DataProvider(name = "empdataprovider")
	String[][] getRegData() throws IOException {

		// Read data from excell
		String path = System.getProperty("user.dir") + "/ExcellData/TradeBeaApiTest.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet2");
		int colcount = XLUtils.getCellCount(path, "Sheet2", 1);

		String empdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
			}
		}

		return (empdata);

	}
}