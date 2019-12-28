import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * NestedHashMap
 */
public class NestedHashMap {

    public static Map<String, Object> getData(){
        Map<String, Object> root = new HashMap<>();
        Map<String, Object> dataMap1 = new HashMap<>();
        Map<String, Object> dataMap2 = new HashMap<>();
        Map<String, Object> dataMap3 = new HashMap<>();
        Map<String, Object> dataMap4 = new HashMap<>();
        List<Map<String, Object>> dataList = new ArrayList<>();

        

        dataMap3.put("_type", "value3");
        dataMap3.put("field1", "value4");
        dataMap3.put("field2", "value5");
        dataMap3.put("field3", "value6");
        dataMap3.put("filed4", "value7");

        dataMap4.put("_type", "priyash");
        dataMap4.put("field1", "value4");
        dataMap4.put("field2", "value5");
        dataMap4.put("field3", "value6");
        dataMap4.put("filed4", "value7");

        dataList.add(dataMap3);
        dataList.add(dataMap4);
        dataMap2.put("dataList2", dataList);
        dataMap1.put("dataList1", dataMap2);
        root.put("dataMap1", dataMap1);
        
        return root;
    }
    
    public static void updateHashMap(Map<String, Object> valueMap, Map<String, Object> responseMap){

        Iterator<Map.Entry<String, Object>> itr = valueMap.entrySet().iterator();
        
        while(itr.hasNext()){
            Map.Entry<String, Object> entry = itr.next();
            String key = entry.getKey();
            Object value = entry.getValue();

            if(key.equals("_type")){
                String updatedKey = "type";
                itr.remove();
                responseMap.put(updatedKey, value);
            }
            if(value instanceof List){
                for(Map<String, Object> listEntry : (List<Map<String, Object>>)value){
                    if(listEntry instanceof Map){
                        updateHashMap((Map<String, Object>)listEntry, responseMap);
                        listEntry.putAll(responseMap);
                        responseMap.clear();
                    }
                    
                }
                
            }
            
            if(value instanceof Map){
                updateHashMap((Map<String, Object>) value, responseMap);
                value.putAll(responseMap);
                responseMap.clear();
            }
        }
        valueMap.putAll(responseMap);
        responseMap.clear();
    }



    public static void main(String[] args) {
        Map<String, Object> result = getData();
        Map<String, Object> responseMap = new HashMap<>();
        updateHashMap(result, responseMap);
        System.out.println(result);
    }
}