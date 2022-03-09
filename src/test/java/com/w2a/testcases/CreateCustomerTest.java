package com.w2a.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.w2a.APITestingFramework.APIs.stripe.CreateCustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.SetUp.BaseTest;
import com.w2a.utilities.DataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest {
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
	  //  ExtentListeners.testReport.get().info(data.toString());
		//ExtentListeners.testReport.get().log(Status.INFO, data.toString());
		
		
		response.prettyPrint();

		System.out.println(response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);

	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data) {
		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
		
		/*Response response=given().auth().basic(config.getProperty("inValidSecretKey"),"")
		.formParam("email","trainer@way2automation.com").formParam("description","Adding the first customer in framework")
		.post(config.getProperty("customerAPIEndPoint"));*/
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),200);
		
		}

	}
