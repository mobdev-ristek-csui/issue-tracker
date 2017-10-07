package id.ac.ui.cs.ristek.issuetracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by - on 07/10/2017.
 */

public class IssueDetailContentViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageViewProfilePic;
    private ImageView imageViewContent;
    private TextView textViewIssueName;
    private TextView textViewIssuer;
    private TextView textViewContent;
    private Button buttonUpvote;
    private Button buttonComment;

    public IssueDetailContentViewHolder(View itemView) {
        super(itemView);

        imageViewProfilePic = (ImageView) itemView.findViewById(R.id.imageViewProfilePic);
        imageViewContent = (ImageView) itemView.findViewById(R.id.imageViewContent);
        textViewIssueName = (TextView) itemView.findViewById(R.id.textViewIssueName);
        textViewIssuer = (TextView) itemView.findViewById(R.id.textViewIssuer);
        textViewContent = (TextView) itemView.findViewById(R.id.textViewContent);
        buttonUpvote = (Button) itemView.findViewById(R.id.buttonUpvote);
        buttonComment = (Button) itemView.findViewById(R.id.buttonComment);
    }
}
