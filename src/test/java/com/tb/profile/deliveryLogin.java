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

public class deliveryLogin extends TestBase {
	@BeforeClass
	void profileSeller() throws InterruptedException {
		logger.info("****Strarted TC001_POST-lLOGIN****");
		RestAssured.baseURI = "http://apticks.in/tradebea/";
		httpRequest = RestAssured.given();
		Thread.sleep(5000);
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "empdataprovider")
	void addRegistration(String Identity, String Password) {

		RequestSpecification httpRequest = RestAssured.given();

		// Here we created data which we can send along with the Get request
		JSONObject requestParams = new JSONObject();
		requestParams.put("identity", Identity);
		requestParams.put("password", Password);

		// add header starting the request body is a json
		httpRequest.header("Content-Type", ContentType);
		httpRequest.header("userID", DeliveryAppID);

		// add the json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		// Get request
		response = httpRequest.request(Method.POST, "auth/api/auth/login");

		// capture response body perform validations

		String responseBody = response.getBody().asString();

		System.out.println("Response Body is:" + responseBody);
		try {
			int statuscode = response.getStatusCode();
			Assert.assertEquals(statuscode, 200);
		} catch (Exception e) {
			System.out.println("Test Case is Failed");

		}
	}

	@DataProvider(name = "empdataprovider")
	String[][] postProfileSellerData() throws IOException {

		// Read data from excell
		String path = System.getProperty("user.dir") + "/tradeBeaExcell/TradeBeaApiTest.xlsx";

		int rownum = XLUtils.getRowCount(path, "deliveryAppLogin");
		int colcount = XLUtils.getCellCount(path, "deliveryAppLogin", 1);

		String empdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empdata[i - 1][j] = XLUtils.getCellData(path, "deliveryAppLogin", i, j);
			}
		}

		return (empdata);
	}
}
