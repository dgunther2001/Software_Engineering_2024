package engine.dataapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Data stream passed to and from the controller and data storage.
 */
public class DataStream implements ProtoDataStream, Serializable{

    private List<String> data = new ArrayList<>();
    private String id;

    /**
     * Pass in a list of data to be stored.
     * @param data
     */
    public DataStream(List<String> data) {
        this.data = data;
        id = UUID.randomUUID().toString();
    }
    
    /**
     * Append Data To List
     */
    @Override
    public void append(ProtoDataStream newNum) {
    	for(String str : newNum.getData()) {
    		data.add(str);
    	}
    }

    /**
     * Data Getter
     * @return
     */
    public List<String> getData() {
        return this.data;
    }
    
    /**
     * get id
     */
    public String getId(){
    	return this.id;
    }
    
    /**
     * DataSetter
     * @param data
     */
    public void setData(List<String> data) {
        this.data = data;
    }

}
