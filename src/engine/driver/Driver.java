package engine.driver;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import engine.userapi.ProtoUserDataStream;
import engine.userapi.User;
import engine.userapi.UserDataInput;
import engine.userapi.UserDataStream;

/**
 * 
 */
public class Driver {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char delim = args[2].charAt(0);
		String filePath = args[1];
		String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<String> inputIntegersAsString = Arrays.asList(content.split(","));
        
        List<Integer> inputIntegers = new ArrayList<>();
        
        for(String s : inputIntegersAsString) {
        	inputIntegers.add(Integer.valueOf(s));
        }
        
        UserDataInput data = new UserDataInput(delim, inputIntegers);
        
        User theUser = new User();
        
		ProtoUserDataStream outputData = theUser.sendUserRequest(data);
		
		for (String s : outputData.getOutput()) {
			System.out.print(s + delim);
		}
		
	}
}
