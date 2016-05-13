package com.donkamillo.gojimoqualification.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donkamillo.gojimoqualification.R;
import com.donkamillo.gojimoqualification.ui.model.QualificationModel;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class QualificationDetailsFragment extends Fragment {
    private static final String QUALIFICATION_ARG = "qualification_arg";
    private QualificationModel qualification;
    private RecyclerView mRecyclerView;
    private SubjectCardsAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qualification = (QualificationModel) getArguments().getSerializable(QUALIFICATION_ARG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qualification_details_fragment, parent, false);
        TextView tvName = (TextView) view.findViewById(R.id.name);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new SubjectCardsAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.swapItems(qualification.getSubjects());

        tvName.setText(qualification.getName());
        return view;
    }


    public static QualificationDetailsFragment newInstance(QualificationModel qualification) {
        QualificationDetailsFragment detailsFragment = new QualificationDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(QUALIFICATION_ARG, qualification);
        detailsFragment.setArguments(args);
        return detailsFragment;
    }


}