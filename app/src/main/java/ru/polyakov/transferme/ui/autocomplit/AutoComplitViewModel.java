package ru.polyakov.transferme.ui.autocomplit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AutoComplitViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AutoComplitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
