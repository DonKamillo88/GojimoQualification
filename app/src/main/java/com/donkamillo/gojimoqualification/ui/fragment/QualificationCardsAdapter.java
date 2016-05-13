package com.donkamillo.gojimoqualification.ui.fragment;

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
public class QualificationCardsAdapter extends RecyclerView.Adapter<QualificationCardsAdapter.ListViewHolder> {

    public interface QualificationCardsInterface {
        void onItemClick(QualificationModel qualification);
    }

    private QualificationCardsInterface qualificationCardsInterface;
    private List<QualificationModel> qualifications;

    public QualificationCardsAdapter(QualificationCardsInterface qualificationCardsInterface) {
        this.qualificationCardsInterface = qualificationCardsInterface;
    }

    public void swapItems(List<QualificationModel> qualifications) {
        this.qualifications = qualifications;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (qualifications == null) return 0;
        return qualifications.size();
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int i) {
        QualificationModel qualification = qualifications.get(i);

        holder.name.setText(qualification.getName());
        holder.country.setText(qualification.getCountry() != null ? qualification.getCountry().getName() : "");
        holder.setOnClickListener(qualification);
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.qualifications_list_item, viewGroup, false);

        return new ListViewHolder(itemView);
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView name, country;
        LinearLayout mainLayout;

        public ListViewHolder(View v) {
            super(v);
            mainLayout = (LinearLayout) v.findViewById(R.id.main_layout);
            name = (TextView) v.findViewById(R.id.name);
            country = (TextView) v.findViewById(R.id.country);
        }

        private void setOnClickListener(final QualificationModel qualification) {
            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qualificationCardsInterface.onItemClick(qualification);
                }
            });

        }
    }
}
