package com.donkamillo.gojimoqualification.ui.fragment;

import com.donkamillo.gojimoqualification.ui.model.QualificationModel;

import java.util.List;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public interface QualificationView {

    void showQualification(List<QualificationModel> qualifications);

    void showProgressBar(boolean show);

}
