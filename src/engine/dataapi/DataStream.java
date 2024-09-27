package engine.dataapi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Data stream passed to and from the controller and data storage.
 */
public class DataStream implements ProtoDataStream{

    private List<String> data = new ArrayList<>();
    private String id = UUID.randomUUID().toString();

    /**
     * Pass in a list of data to be stored.
     * @param data
     */
    public DataStream(List<String> data) {
        this.data = data;

    }

    public List<String> getData() {
        return this.data;
    }
    
    public void setData(List<String> data) {
        this.data = data;
    }

}
