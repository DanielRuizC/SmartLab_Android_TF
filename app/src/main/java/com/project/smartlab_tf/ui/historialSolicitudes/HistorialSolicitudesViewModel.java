package com.project.smartlab_tf.ui.historialSolicitudes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistorialSolicitudesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HistorialSolicitudesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}