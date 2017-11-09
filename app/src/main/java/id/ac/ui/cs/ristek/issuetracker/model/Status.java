package id.ac.ui.cs.ristek.issuetracker.model;

/**
 * Created by vasun on 10/7/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Status {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("additional_information")
    @Expose
    public String additionalInformation;
    @SerializedName("created_at")
    @Expose
    public String createdAt;

}