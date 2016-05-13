package com.donkamillo.gojimoqualification.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.donkamillo.gojimoqualification.R;
import com.donkamillo.gojimoqualification.ui.model.QualificationModel;

import java.util.List;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class QualificationsListFragment extends Fragment implements QualificationView {

    public interface OnItemSelectedListener {
        void onItemSelected(QualificationModel i);
    }

    private OnItemSelectedListener listener;
    private RecyclerView mRecyclerView;
    private QualificationCardsAdapter mAdapter;
    private ProgressBar progressBar;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString());
        }
    }


    @Override
    public void showQualification(List<QualificationModel> qualification) {
        mAdapter.swapItems(qualification);
    }

    @Override
    public void showProgressBar(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.qualifications_list_fragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);


        mAdapter = new QualificationCardsAdapter(new QualificationCardsAdapter.QualificationCardsInterface() {
            @Override
            public void onItemClick(QualificationModel qualification) {
                listener.onItemSelected(qualification);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


}
