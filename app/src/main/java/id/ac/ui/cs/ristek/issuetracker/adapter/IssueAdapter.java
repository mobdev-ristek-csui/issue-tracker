package id.ac.ui.cs.ristek.issuetracker.adapter;

/**
 * Created by vasun on 10/7/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.IssueDetailActivity_;
import id.ac.ui.cs.ristek.issuetracker.R;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.IssueHolder> {
    List<Issue> issueList;
    Context context;

    public IssueAdapter(Context context, List<Issue> issueList) {
        this.issueList = issueList;
        this.context = context;
    }

    @Override
    public IssueHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issue_view, parent, false);

        return new IssueHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IssueHolder holder, int position) {
        final Issue issue = issueList.get(position);
        holder.title.setText(issue.title);
        holder.content.setText(issue.content);
        holder.num_of_upvotes.setText(String.valueOf(issue.numOfUpvotes));
        holder.num_of_comments.setText(String.valueOf(issue.numOfComments));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IssueDetailActivity_.intent(context).issueId(issue.id).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return issueList.size();
    }

    public class IssueHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView content;
        public TextView num_of_upvotes;
        public TextView num_of_comments;
        public LinearLayout linearLayout;

        public IssueHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
            num_of_upvotes = (TextView) view.findViewById(R.id.num_of_upvotes);
            num_of_comments = (TextView) view.findViewById(R.id.num_of_comments);
            linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        }
    }

}
