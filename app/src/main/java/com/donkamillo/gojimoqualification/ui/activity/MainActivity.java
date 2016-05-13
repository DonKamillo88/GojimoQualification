package com.donkamillo.gojimoqualification.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.donkamillo.gojimoqualification.R;
import com.donkamillo.gojimoqualification.ui.fragment.QualificationsListFragment;
import com.donkamillo.gojimoqualification.ui.model.QualificationModel;
import com.donkamillo.gojimoqualification.ui.presenter.QualificationsListPresenter;


public class MainActivity extends AppCompatActivity implements MainView, QualificationsListFragment.OnItemSelectedListener {
    private final static String TAG = "MainActivity";
    private QualificationsListPresenter qualificationsListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        Log.e(TAG, errorMessage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        qualificationsListPresenter.getQualificationsData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        qualificationsListPresenter.onStop();
    }

    private void initPresenter() {
        qualificationsListPresenter = new QualificationsListPresenter();

        FragmentManager fm = getSupportFragmentManager();
        QualificationsListFragment qualificationsListFragment = (QualificationsListFragment) fm.findFragmentById(R.id.qualifications_fragment);

        qualificationsListPresenter.attachView(this, this, qualificationsListFragment);
    }


    @Override
    public void onItemSelected(QualificationModel item) {
        Intent i = new Intent(this, QualificationDetailsActivity.class);
        i.putExtra("item", item);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh_data:
                qualificationsListPresenter.callForQualifications();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}



