package id.ac.ui.cs.ristek.issuetracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by - on 07/10/2017.
 */

public class IssueDetailCommentViewHolder  extends RecyclerView.ViewHolder{
    private TextView textViewCommenter;
    private TextView textViewComment;

    public IssueDetailCommentViewHolder(View itemView) {
        super(itemView);

        textViewCommenter = (TextView) itemView.findViewById(R.id.textViewCommenter);
        textViewComment = (TextView) itemView.findViewById(R.id.textViewComment);
    }
}
