package json;

import java.util.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String, Json> jsonPairs;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = new HashMap <>();
        for(JsonPair j: jsonPairs){
            this.jsonPairs.put(j.key, j.value);
        }
    }



    @Override
    public String toJson() {
        String s = "{";
        String e = "}";
        String m = "";
        for( String key : jsonPairs.keySet() ) {
             m += "'" + key+ "' :" + jsonPairs.get(key).toJson();
             m+= ",";
        }if(m.length() != 0){
            m = m.substring(0, m.length()-1);
        }
        System.out.println(s+m+e);
        return s + m + e;
    }


    public void add(JsonPair jsonPair) {
        this.jsonPairs.put(jsonPair.key, jsonPair.value);

    }

    public Json find(String name) {
        if(this.jsonPairs.containsKey(name)){
            return this.jsonPairs.get(name);
        }else{
            return null;
        }
    }

    public JsonObject projection(String... names) {
        JsonObject j = new JsonObject();
        for(String i: names){
            if(this.jsonPairs.containsKey(i)){
                j.add(new JsonPair(i , this.jsonPairs.get(i)));
            }
        }
        return j;
    }

    public boolean contains(String name){
        return (this.jsonPairs.containsKey(name));
    }
}
