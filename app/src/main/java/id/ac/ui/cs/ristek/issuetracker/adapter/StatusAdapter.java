package id.ac.ui.cs.ristek.issuetracker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.R;
import id.ac.ui.cs.ristek.issuetracker.model.Status;

/**
 * Created by wahyu on 09 November 2017.
 */

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {

    Context context;
    List<Status> statuses;

    public StatusAdapter(Context context, List<Status> statuses) {
        this.context = context;
        this.statuses = statuses;
    }

    @Override
    public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.status_view, parent, false);
        return new StatusViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StatusViewHolder holder, int position) {
        Status status = statuses.get(position);
        holder.bind(status);
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }

    class StatusViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView content;
        public TextView date;

        public StatusViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            date = itemView.findViewById(R.id.date);
        }

        public void bind(Status status) {
            title.setText(String.valueOf(status.id));
            content.setText(String.valueOf(status.additionalInformation));
            date.setText(String.valueOf(status.createdAt.toString()));
        }
    }
}
