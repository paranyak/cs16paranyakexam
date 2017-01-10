package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    private final Boolean bool;
    public JsonBoolean(Boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toJson() {
        if(this.bool == true){
            return "true";
        }else{
            return "false";
        }
    }
}
