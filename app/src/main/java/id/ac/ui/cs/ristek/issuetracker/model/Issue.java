package id.ac.ui.cs.ristek.issuetracker.model;

/**
 * Created by vasun on 10/7/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Issue {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("user_id")
    @Expose
    public String userId;
    @SerializedName("category_id")
    @Expose
    public int categoryId;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("comments")
    @Expose
    public List<Comment> comments = null;
    @SerializedName("statuses")
    @Expose
    public List<Status> statuses = null;
    @SerializedName("upvotes")
    @Expose
    public List<Upvote> upvotes = null;
    @SerializedName("attachments")
    @Expose
    public List<Attachment> attachments = null;

}