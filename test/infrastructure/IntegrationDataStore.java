package infrastructure;

import java.util.ArrayList;
import java.util.List;

public class IntegrationDataStore {

    //couldn't implement ProtoDataStore bs methods don't use the same types of data

    public List<String> receiveDataRequest(List<Integer> data) {
        List<String> result = new ArrayList<String>();
        for(int i : data){
            result.add(Integer.toString(i));
        }
        return result;
    }

}
