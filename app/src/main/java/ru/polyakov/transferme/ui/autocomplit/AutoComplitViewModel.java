package ru.polyakov.transferme.ui.autocomplit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.polyakov.transferme.ui.home.HomeViewModel;

public class AutoComplitViewModel extends ViewModel {
    public AutoComplitViewModel() {
    }


    public void onClickComplit (HomeViewModel homeViewModel){

        Log.d("df","dfdf");
    }

  /*  private MutableLiveData<String> mText;

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
    }*/
}
