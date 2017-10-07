package id.ac.ui.cs.ristek.issuetracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by - on 07/10/2017.
 */

public class IssueDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CONTENT_CARD = 0;
    private static final int COMMENT_CARD = 1;
    private Context context;

    public IssueDetailAdapter(Context context) {
        this.context = context;
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

    }

    @Override
    public int getItemCount() {
        return 0;
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
