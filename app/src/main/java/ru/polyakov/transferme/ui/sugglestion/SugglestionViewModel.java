package ru.polyakov.transferme.ui.sugglestion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.polyakov.transferme.network.dto.PrepareQuery;
import ru.polyakov.transferme.repo.SugglestionRepository;

public class SugglestionViewModel extends ViewModel {
    private MutableLiveData<PrepareQuery> mutableLiveData;
    private SugglestionRepository sugglestionRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        sugglestionRepository = SugglestionRepository.getInstance();
        mutableLiveData = sugglestionRepository.getSuggl("Ve","V");

    }

    public LiveData<PrepareQuery> getSugglestionRepository() {
        return mutableLiveData;
    }
}
