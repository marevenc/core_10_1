import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class User {
    public String _id;
    public Map<String, String> name;

    public User(
            @JsonProperty("_id") String _id,
            @JsonProperty("name") Map<String, String> name){
        this._id = _id;
        this.name = name;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "User" +
                "\n id='" + _id +
                "\n name=" + name;
    }
}
