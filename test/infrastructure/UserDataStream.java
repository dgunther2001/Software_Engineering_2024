package infrastructure;

import java.util.ArrayList;
import java.util.List;

import engine.userapi.ProtoUserDataStream;

public class UserDataStream implements ProtoUserDataStream {
	
	List<String> output = new ArrayList<String>();
	
	public UserDataStream(List<String> output) {
		
		this.output = output;
	}
	
	public String toString() {
		String retStr= "";
		for(String listElement : output) {
			retStr = retStr + listElement +"\n";
		}
		return retStr;
	}
}
