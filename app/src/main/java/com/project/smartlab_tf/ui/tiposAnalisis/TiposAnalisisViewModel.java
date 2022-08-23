package com.project.smartlab_tf.ui.tiposAnalisis;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TiposAnalisisViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TiposAnalisisViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}