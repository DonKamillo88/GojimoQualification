package com.donkamillo.gojimoqualification.ui.presenter;

import android.content.Context;

import com.donkamillo.gojimoqualification.ui.activity.MainView;
import com.donkamillo.gojimoqualification.ui.fragment.QualificationView;


/**
 * Created by DonKamillo on 13.05.2016.
 */
public interface Presenter {

    void attachView(Context context, MainView mainView, QualificationView qualificationView);

    void onStop();

}
