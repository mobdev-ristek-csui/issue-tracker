package id.ac.ui.cs.ristek.issuetracker.adapter;

/**
 * Created by vasun on 10/7/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.ViewById;

import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.R;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.model.IssuePlaceHolder;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.IssueHolder> {
    List<IssuePlaceHolder> issueList;

    public IssueAdapter(List<IssuePlaceHolder> issueList) {
        this.issueList = issueList;
    }

    public class IssueHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView user_id;
        public TextView content;
        public TextView num_of_upvotes;
        public TextView num_of_comments;

        public IssueHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            user_id = (TextView) view.findViewById(R.id.user_id);
            content = (TextView) view.findViewById(R.id.content);
            num_of_upvotes = (TextView) view.findViewById(R.id.num_of_upvotes);
            num_of_comments = (TextView) view.findViewById(R.id.num_of_comments);
        }
    }

    @Override
    public IssueHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issue_view, parent, false);

        return new IssueHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IssueHolder holder, int position) {
        IssuePlaceHolder issue = issueList.get(position);
        holder.title.setText(issue.title);
        holder.user_id.setText(issue.user_id);
        holder.content.setText(issue.content);
        holder.num_of_upvotes.setText(issue.num_of_upvotes + "");
        holder.num_of_comments.setText(issue.num_of_comments + "");
    }

    @Override
    public int getItemCount() {
        return issueList.size();
    }

}
