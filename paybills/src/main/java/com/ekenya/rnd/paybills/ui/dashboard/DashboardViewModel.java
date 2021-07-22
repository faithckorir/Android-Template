package com.ekenya.rnd.paybills.ui.dashboard;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

public class DashboardViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;

    @Inject
    public DashboardViewModel(Application app) {
        super(app);
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}