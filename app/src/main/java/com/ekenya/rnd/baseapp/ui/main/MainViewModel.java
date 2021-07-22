package com.ekenya.rnd.baseapp.ui.main;

import androidx.lifecycle.ViewModel;

import com.ekenya.rnd.common.repo.SampleRepository;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private final SampleRepository sampleRepository;

    public final String getData() {
        return this.sampleRepository.getData();
    }

    @Inject
    public MainViewModel(SampleRepository sampleRepository) {
        super();
        this.sampleRepository = sampleRepository;
    }
}