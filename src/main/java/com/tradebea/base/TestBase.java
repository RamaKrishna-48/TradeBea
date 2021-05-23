package com.tradebea.base;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	static String currrntDirectory= System.getProperty("user.dir");

	public static RequestSpecification httpRequest;
	public static Response response;
	public static Properties prop;
	public Logger logger;
	public static String X_AUTH_TOKEN="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEzIiwidXNlcmRldGFpbCI6eyJ1c2VybmFtZSI6Ijc5ODk2MzU4ODgiLCJlbWFpbCI6InBvbGF2ZW5rYXRhcmFtYWtyaXNobmFAZ21haWwuY29tIiwicGhvbmUiOiI3OTg5NjM1ODg4In0sInRpbWUiOjE1OTYzODkyODR9.4nI-3Sk4OaAQUf4b_N1EZmqhCEUXZte0ZHRPSIbIfYg";
	public static String ContentType="application/json";
	public static String userToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEyIiwidXNlcmRldGFpbCI6eyJ1c2VybmFtZSI6Ijc4OTMzNTA1MDkiLCJlbWFpbCI6InJhbWFrcmlzaG5hMTEyNEBnbWFpbC5jb20iLCJwaG9uZSI6IjcwOTMwMDM1OTUiLCJpZCI6IjEyIiwiZ3JvdXBzIjp7IjUiOnsiaWQiOiI1IiwidXNlcl9pZCI6IjEyIiwibmFtZSI6InVzZXIifX19LCJ0aW1lIjoxNTk5MjQ2MTQyfQ.ZSKCvaaUVO4BuK0BCqQKgOLI4K_NJPLc6CeLp170RwI";
	public static String userAppID="TVE9PQ==";
	public static String sellerAppID="TWc9PQ==";
	public static String DeliveryAppID="TXc9PQ==";
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("TradeBeaApi");
		PropertyConfigurator.configure(currrntDirectory+"\\src\\main\\reources\\log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}
