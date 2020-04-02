package stepDefn;

import java.util.Map;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dataProvider.ConfigFileReader;

public class Steps extends BDDStyleMethod
{
	ConfigFileReader configs = ConfigFileReader.getInstance();
	int id = -1;
	
	@Given("user sets the endPoint to {string}")
	public void user_sets_the_endPoint_to(String string) 
	{
		setBaseURI(configs.getConfigPropProperty(string));
		newRequest();
	}
	
	@When("the user wants to get page {int}")
	public void the_user_wants_to_get_page(Integer int1) {
		setPage(int1);
	}
	
	@When("the user makes a get request to {string}")
	public void the_user_makes_a_get_request_to(String path) {
		if(id==-1){
			sendGet(configs.getEndPointPropProperties(path));
		}
		else{
			sendGet(configs.getEndPointPropProperties(path),id);
		}
	
	}
	
	@Then("the response should have status code {int}")
	public void the_response_should_have_status_code(Integer code) {
		 checkCode(code);
	}
	
	@Then("the response should contain {string} field as {string}")
	public void the_response_should_contain_field_as(String path, String value) {
		bodyContainsStrict(path,value);
	}
	
	@When("the user creates the below data")
	public void the_user_creates_the_below_data(Map<String,String> dataTable)
	{
		jsonBuilder(dataTable);
	}
	
	@When("the user makes a post request to {string}")
	public void the_user_makes_a_post_request_to(String key) 
	{
		sendPost(configs.getEndPointPropProperties(key));
	}
	
	@Then("show the response")
	public void show_the_response() {
		System.out.println(bodyAsString());
	}
}
