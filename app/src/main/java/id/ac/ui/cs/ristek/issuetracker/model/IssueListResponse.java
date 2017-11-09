package id.ac.ui.cs.ristek.issuetracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasun on 10/7/2017.
 */

public class IssueListResponse {
    @SerializedName("data")
    @Expose
    public List<Issue> issues = new ArrayList<>();
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;

    class Metadata {
        @SerializedName("num_of_items")
        @Expose
        public int totalIssues;
        @SerializedName("offset")
        @Expose
        public int offset;
        @SerializedName("limit")
        @Expose
        public int limit;

    }
}
