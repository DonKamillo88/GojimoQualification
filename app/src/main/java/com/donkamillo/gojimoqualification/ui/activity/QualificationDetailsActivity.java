package com.donkamillo.gojimoqualification.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.donkamillo.gojimoqualification.R;
import com.donkamillo.gojimoqualification.ui.fragment.QualificationDetailsFragment;
import com.donkamillo.gojimoqualification.ui.model.QualificationModel;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class QualificationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qualification_details_activity);
        QualificationModel item = (QualificationModel) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null) {
            QualificationDetailsFragment qualificationDetailsFragment = QualificationDetailsFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, qualificationDetailsFragment);
            ft.commit();
        }
    }

}
