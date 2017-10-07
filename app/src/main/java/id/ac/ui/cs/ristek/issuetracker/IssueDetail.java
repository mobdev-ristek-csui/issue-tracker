package id.ac.ui.cs.ristek.issuetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.model.Comment;
import id.ac.ui.cs.ristek.issuetracker.model.CommentPlaceHolder;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.model.IssueDetailPlaceHolder;

public class IssueDetail extends AppCompatActivity {
    private RecyclerView recyclerViewIssueDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_detail);
        recyclerViewIssueDetail = (RecyclerView) findViewById(R.id.issueDetailRecyclerView);

        final List<CommentPlaceHolder> comments = new ArrayList<>();
        comments.add(new CommentPlaceHolder("User 1", "Kotor banget"));
        comments.add(new CommentPlaceHolder("User 2", "Kantin kotor ya"));

        IssueDetailPlaceHolder issue = new IssueDetailPlaceHolder("Kantin Kotor", "UserBaru", "Ini content", 2, comments);
        IssueDetailAdapter adapter = new IssueDetailAdapter(getApplicationContext(), issue);
        recyclerViewIssueDetail.setAdapter(adapter);

    }
}
