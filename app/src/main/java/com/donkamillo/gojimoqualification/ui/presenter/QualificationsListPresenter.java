package com.donkamillo.gojimoqualification.ui.presenter;

import android.content.Context;

import com.donkamillo.gojimoqualification.R;
import com.donkamillo.gojimoqualification.services.Gojimo;
import com.donkamillo.gojimoqualification.services.GojimoResponse;
import com.donkamillo.gojimoqualification.services.GojimoService;
import com.donkamillo.gojimoqualification.storage.SharedPreferencesManager;
import com.donkamillo.gojimoqualification.ui.activity.MainView;
import com.donkamillo.gojimoqualification.ui.fragment.QualificationView;
import com.donkamillo.gojimoqualification.ui.model.QualificationModel;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class QualificationsListPresenter implements Presenter, Callback<List<GojimoResponse>> {
    private Call<List<GojimoResponse>> call;
    private MainView mainView;
    private Gojimo gojimo;
    private Context context;
    private QualificationView qualificationView;

    @Override
    public void onResponse(Response<List<GojimoResponse>> response, Retrofit retrofit) {

        if (response == null || response.body() == null) {
            mainView.showError(context.getString(R.string.error_response_null));
            qualificationView.showProgressBar(false);
            return;
        }

        List<QualificationModel> qualifications = new ArrayList<>();
        for (GojimoResponse res : response.body()) {

            QualificationModel.Country country = null;
            if (res.getCountry() != null)
                country = new QualificationModel().new Country(res.getCountry().getCode(), res.getCountry().getName(), res.getCountry().getCreated_at(), res.getCountry().getUpdated_at(), res.getCountry().getLink());
            List<QualificationModel.Subject> subjects = new ArrayList<>();

            for (GojimoResponse.Subject sub : res.getSubjects()) {
                if (sub != null)
                    subjects.add(new QualificationModel().new Subject(sub.getId(), sub.getTitle(), sub.getLink(), sub.getColour()));
            }

            qualifications.add(new QualificationModel(res.getId(), res.getName(), res.getLink(), country, subjects));

        }

        SharedPreferencesManager.saveHistoryData(qualifications, context);

        qualificationView.showQualification(qualifications);
        qualificationView.showProgressBar(false);
    }

    @Override
    public void onFailure(Throwable t) {
        qualificationView.showProgressBar(false);
        mainView.showError(t.getLocalizedMessage());
    }

    @Override
    public void attachView(Context context, MainView mainView, QualificationView qualificationView) {
        this.mainView = mainView;
        this.context = context;
        this.qualificationView = qualificationView;
    }

    @Override
    public void onStop() {
        if (call != null)
            call.cancel();
    }

    public void getQualificationsData() {
        List<QualificationModel> historyData = SharedPreferencesManager.loadHistoryData(context);
        if (historyData == null) {
            callForQualifications();
        } else {
            qualificationView.showQualification(historyData);
            qualificationView.showProgressBar(false);
        }
    }

    public void callForQualifications() {
        qualificationView.showProgressBar(true);
        call = getQualifications().getData();
        call.enqueue(this);
    }

    private Gojimo getQualifications() {
        if (gojimo == null)
            gojimo = GojimoService.getService();
        return gojimo;
    }
}
