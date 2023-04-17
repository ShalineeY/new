package testClass;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;

import commonMethod.CommonMethod;
import commonMethod.CommonMethodUtility;
import io.restassured.path.json.JsonPath;
import requestRepository.RequestRepository;

public class PutTestCases {
	
	public static void orchestrator() throws IOException {
		
		String baseURI=RequestRepository.baseURI();
		String resource=RequestRepository.resource();
		String requestBody=RequestRepository.requestBody();
		int statusCode=0;
		String responseBody="";
		
		for(int i=0;i<5;i++)
		{
			statusCode=CommonMethod.statusCodeExtrator(baseURI, resource, requestBody);
			if(statusCode==200)
			{
				responseBody = CommonMethod.responseBodyExtrator(baseURI, resource, requestBody);
				responseBodyValidator(responseBody);
				break;
			}
			else
			{
				System.out.println("status code validation failed hence retry" + i);
			}
		}
		Assert.assertEquals(statusCode, 200);
		CommonMethodUtility.evidenctSheetCreatror("putdata", requestBody, responseBody);
	}

	public static void responseBodyValidator(String responseBody) {
		// TODO Auto-generated method stub
		
		JsonPath resBody=new JsonPath(responseBody);
		
		String resName=resBody.getString("name");
		String resJob=resBody.getString("job");
		String resdate=resBody.getString("updatedAt");
		
		String date=resdate.substring(0,10);
		String newdate=LocalDate.now().toString();
		
		Assert.assertEquals(resName, "morpheus");
		Assert.assertEquals(resJob, "zion resident");
		Assert.assertEquals(date, newdate);
		
		System.out.println("Name : " + resName + " \nJOB : " + resJob + "\nsdate : " + newdate);
		
		
		
	}

}
