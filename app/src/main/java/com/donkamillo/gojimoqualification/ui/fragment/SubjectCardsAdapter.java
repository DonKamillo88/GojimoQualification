package com.donkamillo.gojimoqualification.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.donkamillo.gojimoqualification.R;
import com.donkamillo.gojimoqualification.ui.model.QualificationModel;

import java.util.List;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class SubjectCardsAdapter extends RecyclerView.Adapter<SubjectCardsAdapter.ListViewHolder> {

    private List<QualificationModel.Subject> subjects;

    public SubjectCardsAdapter( ) {    }

    public void swapItems(List<QualificationModel.Subject> subjects) {
        this.subjects = subjects;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (subjects == null) return 0;
        return subjects.size();
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int i) {
        QualificationModel.Subject subject = subjects.get(i);


        holder.title.setText(subject != null ? subject.getTitle() : "");
        if (subject != null && subject.getColour() != null && !subject.getColour().isEmpty()) {
            holder.mainLayout.setBackgroundColor(Color.parseColor(subject.getColour()));
        }
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.subject_list_item, viewGroup, false);

        return new ListViewHolder(itemView);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        LinearLayout mainLayout;

        public ListViewHolder(View v) {
            super(v);
            mainLayout = (LinearLayout) v.findViewById(R.id.main_layout);
            title = (TextView) v.findViewById(R.id.title);
        }
    }
}
