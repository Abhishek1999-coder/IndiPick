package com.system.indipick;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class ProdsearchViewModel {
    private MutableLiveData<String> mText;

    public ProdsearchViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.mText = mutableLiveData;
        mutableLiveData.setValue("This is Product Search fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
