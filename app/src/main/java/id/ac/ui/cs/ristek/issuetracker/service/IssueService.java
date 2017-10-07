package id.ac.ui.cs.ristek.issuetracker.service;

/**
 * Created by vasun on 10/7/2017.
 */
import id.ac.ui.cs.ristek.issuetracker.model.ResponseIssue;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IssueService {
    @GET("https://bem.cs.ui.ac.id/issue/api/v1/reports/{id}")
    Call<ResponseIssue> getIssues(@Path("id") String id);
}
