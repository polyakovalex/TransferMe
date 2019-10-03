package ru.polyakov.transferme.ui.home;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

   // private MutableLiveData<String> mFrom;
   private String stateFrom;
   private String stateTo;
   private int adultCount;
   private String childCount;


    public HomeViewModel(String stateFrom, String stateTo, int adultCount, String childCount) {
        this.stateFrom = stateFrom;
        this.stateTo = stateTo;
        this.adultCount = adultCount;
        this.childCount = childCount;
    }

    public String getStateFrom() {
        return stateFrom;
    }

    public void setStateFrom(String stateFrom) {
        this.stateFrom = stateFrom;
    }

    public String getStateTo() {
        return stateTo;
    }

    public void setStateTo(String stateTo) {
        this.stateTo = stateTo;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public String getChildCount() {
        return childCount;
    }

    public void setChildCount(String childCount) {
        this.childCount = childCount;
    }
}