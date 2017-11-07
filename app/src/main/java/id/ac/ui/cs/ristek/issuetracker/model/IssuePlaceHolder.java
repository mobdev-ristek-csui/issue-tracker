package id.ac.ui.cs.ristek.issuetracker.model;

/**
 * Created by vasun on 10/7/2017.
 */

public class IssuePlaceHolder {
    public String title;
    public String user_id;
    public String content;
    public int num_of_upvotes;
    public int num_of_comments;

    public IssuePlaceHolder(String title, String user_id, String content, int num_of_upvotes, int num_of_comments) {
        this.title = title;
        this.user_id = "by " + user_id;
        this.content = content;
        this.num_of_upvotes = num_of_upvotes;
        this.num_of_comments = num_of_comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum_of_upvotes() {
        return num_of_upvotes;
    }

    public void setNum_of_upvotes(int num_of_upvotes) {
        this.num_of_upvotes = num_of_upvotes;
    }

    public int getNum_of_comments() {
        return num_of_comments;
    }

    public void setNum_of_comments(int num_of_comments) {
        this.num_of_comments = num_of_comments;
    }
}
