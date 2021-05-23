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

public class sellerProfile extends TestBase {
	@BeforeClass
	void profileSeller() throws InterruptedException {
		logger.info("****Strarted TC001_POST-SellerProfile****");
		RestAssured.baseURI = "http://apticks.in/tradebea/";
		httpRequest = RestAssured.given();
		// response = httpRequest.request(Method.POST,
		// "auth/api/users/profile/u/seller");
		Thread.sleep(5000);
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "empdataprovider")
	void addRegistration(String shop_name, String ownership_type, String designation, String pan, String gst,
			String mobile, String email, String signature_image, String electricity_bill_image, String pan_card_image,
			String shop_image, String lattitude, String langitude, String geo_location_address) {

		RequestSpecification httpRequest = RestAssured.given();

		// Here we created data which we can send along with the post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("shop_name", shop_name);
		requestParams.put("ownershipType", ownership_type);
		requestParams.put("designation", designation);
		requestParams.put("pan", pan);
		requestParams.put("gst", gst);
		requestParams.put("mobile", mobile);
		requestParams.put("email", email);
		requestParams.put("signature_image", signature_image);
		requestParams.put("electricity_bill_image", electricity_bill_image);
		requestParams.put("pan_card_image", pan_card_image);
		requestParams.put("shop_image", shop_image);
		requestParams.put("lattitude", lattitude);
		requestParams.put("langitude", langitude);
		requestParams.put("geo_location_address", geo_location_address);

		// add header starting the request body is a json
		httpRequest.header("Content-Type", ContentType);
		httpRequest.header("X_AUTH_TOKEN", X_AUTH_TOKEN);

		// add the json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		// post request
		response = httpRequest.request(Method.POST, "auth/api/users/profile/u/seller");

		// capture response body perform validations

		String responseBody = response.getBody().asString();

		System.out.println("Response Body is:" + responseBody);

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@DataProvider(name = "empdataprovider")
	String[][] postProfileSellerData() throws IOException {

		// Read data from excell
		String path = System.getProperty("user.dir") + "/ExcellData/TradeBeaApiTest.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet3");
		int colcount = XLUtils.getCellCount(path, "Sheet3", 1);

		String empdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet3", i, j);
			}
		}

		return (empdata);
	}

}
