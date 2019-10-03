package ru.polyakov.transferme.ui.home;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

   // private MutableLiveData<String> mFrom;
   public ObservableField<String> stateFrom = new ObservableField<>();
   public ObservableField<String> stateTo = new ObservableField<>();
   public ObservableInt adultCount = new ObservableInt();
   public ObservableInt childCount = new ObservableInt();

    public HomeViewModel(ObservableField<String> stateFrom, ObservableField<String> stateTo) {
        this.stateFrom = stateFrom;
        this.stateTo = stateTo;
    }
}