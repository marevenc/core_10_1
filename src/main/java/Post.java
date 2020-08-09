import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    String _id, text, type;
    User user;
    int upvotes;
    String userUpvoted;

    public Post(
            @JsonProperty("_id") String _id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") User user,
            @JsonProperty("upvotes") int upvotes,
            @JsonProperty("userUpvoted") String userUpvoted
    ){
        this._id = _id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
        this.userUpvoted = userUpvoted;
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

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getUserUpvoted() {
        return userUpvoted;
    }

    public void setUserUpvoted(String userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    @Override
    public String toString() {
        return "Post" +
                "\n id='" + _id +
                "\n text='" + text +
                "\n type='" + type +
                "\n user=" + user +
                "\n upVotes=" + upvotes +
                "\n userUpVotes=" + userUpvoted;
    }
}
