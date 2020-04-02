package stepDefn;

import org.json.simple.JSONObject;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;

public class BDDStyleMethod 
{
	protected RequestSpecification request;
	protected Response response;
	protected void setBaseURI(String url)
	{
		baseURI=url;
	}
	protected void newRequest() {
		request = given();
	}
	protected void setPage(int page)
	{
		request = given().param("page",page);
	}
	protected void sendGet(String path)
	{
		response = request.when().get(path);
	}
	protected void sendGet(String path,int variable)
	{
		response = request.when().get(path,variable);
	}
	protected void checkCode(int code)
	{
		response.then().statusCode(code);
	}
	protected void bodyContainsStrict(String path, String value)
	{
		if(!path.equalsIgnoreCase("")&&!value.equalsIgnoreCase(""))
		{
			response.then().body(path,equalTo(parse(value)));
		}
	}
	private Object parse(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return value;
		}
	}
	protected void jsonBuilder(Map<String,String> dataTable)
	{
		JSONObject json = new JSONObject();
	    for(Map.Entry<String, String> entry:dataTable.entrySet())
	    {
	    	json.put(entry.getKey(),parse(entry.getValue()));
	    }
	    request.header("Content-Type","application/json");
	    request.body(json.toString());
	}
	protected void sendPost(String path)
	{
		response = request.post(path);
	}
	protected String bodyAsString()
	{
		return response.body().asString();
	}
	/*protected int getIntFromJson(String path)
	{
		return response.then().extract().jsonPath().getInt(path);
	}
	protected void sendPut(String path,int value)
	{
		response = request.when().put(path,value);
	}
	protected void sendPatch(String path,int value)
	{
		response = request.when().patch(path,value);
	}
	protected void sendDelete(String path, int value)
	{
	    response =request.when().delete(path,value);
	}
	protected void validateBodyWithMap(Map<String,String> dataTable)
	{
		for(Map.Entry<String,String> entry: dataTable.entrySet())
	    {
			response.then().body(entry.getKey(),equalTo(parse(entry.getValue())));
	    }
	}*/

}
