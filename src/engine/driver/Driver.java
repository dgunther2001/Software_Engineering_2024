package engine.driver;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import engine.controller.Controller;
import engine.dataapi.DataStore;
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
		String filePathIn = args[0];
		String filePathOut = args[1];
		
		DataStore dataStore = new DataStore();
		Controller systemControl = new Controller(dataStore);
		
		User mainUser = new User(systemControl);
		mainUser.run(filePathOut, delim, filePathIn);
		//UserDataStream userInData = dataStore.readInputData(filePathIn, delim, filePathOut); // grabs the input data
		
		// dispatch the userInData to the controller
		//systemControl.receiveUserRequest(userInData);
		
	}
}
