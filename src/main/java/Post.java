import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    String _id, text, type;
    User user;
    String upvotes, userUpvotes;

    public Post(
            @JsonProperty("_id") String _id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") User user,
            @JsonProperty("upvotes") String upvotes,
            @JsonProperty("userUpvotes") String userUpvotes
    ){
        this._id = _id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
        this.userUpvotes = userUpvotes;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    public String getUserUpvotes() {
        return userUpvotes;
    }

    public void setUserUpvotes(String userUpvotes) {
        this.userUpvotes = userUpvotes;
    }

    @Override
    public String toString() {
        return "Post" +
                "\n id='" + _id +
                "\n text='" + text +
                "\n type='" + type +
                "\n user=" + user +
                "\n upVotes=" + upvotes +
                "\n userUpVotes=" + userUpvotes;
    }
}
