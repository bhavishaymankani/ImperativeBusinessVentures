package com.bhavishaymankani.imperativebusinessventuresmachinetest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bhavishaymankani.imperativebusinessventuresmachinetest.model.Data;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Data> data = new MutableLiveData<>();

    public LiveData<Data> getLiveData() {
        return data;
    }

    public void setData(Data data) {
        this.data.setValue(data);
    }
}