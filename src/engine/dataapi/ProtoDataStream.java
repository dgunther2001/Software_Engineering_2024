package engine.dataapi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Prototype for data stream passing to the data storage
 */
public interface ProtoDataStream {


    /**
     * Append Data To List
     */
    public void append(ProtoDataStream newNum);

    /**
     * Data Getter
     * @return
     */
    public List<String> getData();
    
    /**
     * get id
     */
    public String getId();
    
    /**
     * DataSetter
     * @param data
     */
    public void setData(List<String> data);

}
