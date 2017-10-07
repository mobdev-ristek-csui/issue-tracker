package id.ac.ui.cs.ristek.issuetracker.model;

/**
 * Created by - on 07/10/2017.
 */

public class CommentPlaceHolder {
    public String userId;
    public String content;

    public CommentPlaceHolder(String userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
