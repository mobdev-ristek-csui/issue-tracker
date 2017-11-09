package id.ac.ui.cs.ristek.issuetracker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import id.ac.ui.cs.ristek.issuetracker.adapter.StatusAdapter;
import id.ac.ui.cs.ristek.issuetracker.api.ApiAdapter;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.service.IssueService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EActivity(R.layout.activity_issue_detail)
public class IssueDetailActivity extends AppCompatActivity {
    public static final String LOADING = "Loading...";
    public static final String DIALOG_TITLE = "Issue Tracker";
    public static final String TITLE = "Detail Issue";

    @ViewById
    TextView title;
    @ViewById
    TextView content;
    @ViewById
    TextView num_of_upvotes;
    @ViewById
    TextView num_of_comments;
    @ViewById
    ImageView image;
    @ViewById
    TextView user;
    @ViewById
    RecyclerView rv;

    @Bean
    ApiAdapter apiAdapter;

    @Extra
    int issueId;

    ProgressDialog progressDialog;

    @AfterViews
    void init() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(TITLE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(DIALOG_TITLE);
        progressDialog.setMessage(LOADING);
        progressDialog.setCancelable(true);
        progressDialog.show();
        apiAdapter.service(IssueService.class).getIssueDetail(issueId).enqueue(new Callback<Issue>() {
            @Override
            public void onResponse(Call<Issue> call, Response<Issue> response) {
                Issue issue = response.body();
                progressDialog.dismiss();
                if (response.isSuccessful() && issue != null) {
                    title.setText(issue.title);
                    getSupportActionBar().setTitle(issue.title);
                    content.setText(issue.content);
                    num_of_upvotes.setText(String.valueOf(issue.numOfUpvotes));
                    num_of_comments.setText(String.valueOf(issue.numOfComments));
                    user.setText(issue.userId);
                    if (issue.attachments != null && !issue.attachments.isEmpty()) {
                        Glide.with(getApplicationContext()).load(issue.attachments.get(0).url).into(image);
                    } else {
                        image.setVisibility(View.GONE);
                    }
                    StatusAdapter adapter = new StatusAdapter(getApplicationContext(), issue.statuses);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setAdapter(adapter);
                } else {
                    Toast.makeText(IssueDetailActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                    Log.d("wahyu", response.message());
                    Log.d("wahyu", response.raw().toString());
                    Log.d("wahyu", response.raw().request().toString());
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Issue> call, Throwable t) {
                Toast.makeText(IssueDetailActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                Log.d("wahyu", t.getMessage());
                Log.d("wahyu", call.request().toString());
                progressDialog.dismiss();
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
