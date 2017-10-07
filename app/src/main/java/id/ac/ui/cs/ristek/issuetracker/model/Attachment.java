package id.ac.ui.cs.ristek.issuetracker.model;

/**
 * Created by vasun on 10/7/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("url")
    @Expose
    public String url;

}