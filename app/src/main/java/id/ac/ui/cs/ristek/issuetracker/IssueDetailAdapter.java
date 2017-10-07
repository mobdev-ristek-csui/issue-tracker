package id.ac.ui.cs.ristek.issuetracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.model.Comment;
import id.ac.ui.cs.ristek.issuetracker.model.CommentPlaceHolder;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.model.IssueDetailPlaceHolder;

/**
 * Created by - on 07/10/2017.
 */

public class IssueDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CONTENT_CARD = 0;
    private static final int COMMENT_CARD = 1;
    private Context context;
    private IssueDetailPlaceHolder issue;
    private List<CommentPlaceHolder> commentList;

    public IssueDetailAdapter(Context context, IssueDetailPlaceHolder issue) {
        this.context = context;
        this.issue = issue;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == CONTENT_CARD) {
            return new IssueDetailContentViewHolder(LayoutInflater.from(context).inflate(R.layout.issue_detail_content_viewholder, parent, false));
        } else {
            return new IssueDetailCommentViewHolder(LayoutInflater.from(context).inflate(R.layout.issue_detail_comment_viewholder, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == CONTENT_CARD) {
            IssueDetailContentViewHolder contentHolder = (IssueDetailContentViewHolder) holder;
            contentHolder.textViewIssueName.setText(issue.title);
            contentHolder.textViewIssuer.setText(issue.user_id);
            contentHolder.textViewContent.setText(issue.content);
            Glide.with(context).load("https://nationalzoo.si.edu/sites/default/files/animals/redpanda-001.jpg").into(contentHolder.imageViewProfilePic);
            Glide.with(context).load("https://nationalzoo.si.edu/sites/default/files/animals/redpanda-001.jpg").into(contentHolder.imageViewContent);
        } else {
            commentList = issue.comments;
            CommentPlaceHolder comment = commentList.get(position);
            IssueDetailCommentViewHolder commentHolder = (IssueDetailCommentViewHolder) holder;
            commentHolder.textViewCommenter.setText(comment.userId);
            commentHolder.textViewComment.setText(comment.content);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return CONTENT_CARD;
        } else {
            return COMMENT_CARD;
        }
    }
}
