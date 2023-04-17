package commonMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CommonMethodUtility {

	
	public static void evidenctSheetCreatror(String FileName,String request,String respones) throws IOException
	{
		File newTextFile =new File("D:\\restAssuredevidence\\" + FileName + ".txt");
		if(newTextFile.createNewFile())
		{
			FileWriter dataWriter = new FileWriter(newTextFile);
			dataWriter.write("request Body is " + request + "\n\n");
			dataWriter.write("response Body is " + respones );
			dataWriter.close();
			
			System.out.println("request body and respone bdoy save in" + newTextFile.getName());
		}
		else
		{
			System.out.println(newTextFile.getName() + "already exits take backup of it");
		}
		
	}
}
