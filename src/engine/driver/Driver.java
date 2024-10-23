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
		char delim = args[3].charAt(0);
		String filePathIn = args[1];
		String filePathOut = args[2];
		
		DataStore dataStore = new DataStore();
		Controller systemControl = new Controller(dataStore);
		
		
		UserDataStream userInData = dataStore.readInputData(filePathIn, delim, filePathOut); // grabs the input data
		
		// dispatch the userInData to the controller
		systemControl.receiveUserRequest(userInData);
		
	}
}
