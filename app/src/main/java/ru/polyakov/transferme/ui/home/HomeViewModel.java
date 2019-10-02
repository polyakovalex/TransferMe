package ru.polyakov.transferme.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mFrom;

    public HomeViewModel() {
        this.mFrom = mFrom;
        mFrom.setValue("fsd");
    }

    public LiveData<String> getFrom() {
        return mFrom;
    }

}