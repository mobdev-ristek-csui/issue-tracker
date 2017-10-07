package id.ac.ui.cs.ristek.issuetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.model.CommentPlaceHolder;
import id.ac.ui.cs.ristek.issuetracker.model.IssuePlaceHolder;

public class IssueDetail extends AppCompatActivity {
    private RecyclerView recyclerViewIssueDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_detail);
        recyclerViewIssueDetail = (RecyclerView) findViewById(R.id.issueDetailRecyclerView);

        final List<Object> issue = new ArrayList<>();
        issue.add(new IssuePlaceHolder("Kantin Kotor", "UserBaru", "Ini content coba nih ya panjang banget. Ini content coba nih ya panjang banget. " +
                "Ini content coba nih ya panjang banget. Ini content coba nih ya panjang banget.", 2, 2));
        issue.add(new CommentPlaceHolder("User 1", "Kotor banget"));
        issue.add(new CommentPlaceHolder("User 300", "Kantin kotor banget sih"));
        issue.add(new CommentPlaceHolder("User 12", "Kotor banget lah"));
        issue.add(new CommentPlaceHolder("User 13", "Kotor banget kayak apa tau"));
        issue.add(new CommentPlaceHolder("User 14", "Kotor banget nggak sih?"));
        issue.add(new CommentPlaceHolder("User 15", "Kotor banget sih"));
        issue.add(new CommentPlaceHolder("User 16", "Kotor banget, liat aja"));
        issue.add(new CommentPlaceHolder("User 17", "Kotor banget, bersihin dong"));

        setTitle(((IssuePlaceHolder) issue.get(0)).getTitle());

        IssueDetailAdapter adapter = new IssueDetailAdapter(this, issue);

        recyclerViewIssueDetail.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewIssueDetail.setAdapter(adapter);

    }
}
