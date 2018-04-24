import java.io.BufferedReader;
import java.io.FileReader;

public class MessageReader {

	public String getMessage(String path){
		
		String message = "";
		
		try{
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String word = null;
		
			while((word = bufferedReader.readLine()) != null){
				message += word;
				message += "\n";
			}
			bufferedReader.close();
	    }
		catch(Exception e){
			e.printStackTrace();
		}
		
		return message;
	
	}
	
}
