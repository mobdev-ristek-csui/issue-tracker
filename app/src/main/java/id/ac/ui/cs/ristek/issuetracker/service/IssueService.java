package id.ac.ui.cs.ristek.issuetracker.service;

/**
 * Created by vasun on 10/7/2017.
 */

import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.model.IssueListResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IssueService {
    @GET("reports/{id}")
    Call<IssueListResponse> getIssueDetail(@Path("id") String id);

    @GET("reports")
    Call<IssueListResponse> getIssues();

    @FormUrlEncoded
    @POST("reports")
    Call<Issue> createIssue(@Field("category_id") int categoryId,
                            @Field("title") String title,
                            @Field("content") String content,
                            @Field("is_anonymous") boolean isAnonymous);
}
