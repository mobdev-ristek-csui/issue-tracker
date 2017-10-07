package id.ac.ui.cs.ristek.issuetracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vasun on 10/7/2017.
 */

public class ResponseIssue {
    @SerializedName("totalIssues")
    @Expose
    public int totalIssues;
    @SerializedName("issues")
    @Expose
    public List<Issue> issues = null;
    @SerializedName("total")
    @Expose
    public int total;
}
