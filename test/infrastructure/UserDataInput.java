package infrastructure;
import engine.userapi.ProtoUserDataInput;

import java.util.ArrayList;
import java.util.List;

public class UserDataInput implements ProtoUserDataInput{
    
    List<Integer> input = new ArrayList<Integer>();
    
    public UserDataInput(int [] arr) {
    	for( int x : arr) {
    		input.add(x);
    	}
    }
}
