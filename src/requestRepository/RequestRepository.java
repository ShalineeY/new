package requestRepository;

import java.io.IOException;
import java.util.ArrayList;

import commonMethod.DataDrivern;

public class RequestRepository {
	
	public static String baseURI()
	{
	
		String baseURI="https://reqres.in/";
		
		return baseURI;
		
	}
	
	public static String resource()
	{
		String resource="api/users/2";
		return resource;
		
	}
	
	public static String requestBody() throws IOException
	{
		ArrayList<String> data =DataDrivern.getdata("put_data", "tc1");
		
		String name=data.get(2);
		String job=data.get(3);
		String requestBody="{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		
		return requestBody;
	}
}
