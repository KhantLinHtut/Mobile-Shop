package com.klh.mobileshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.klh.mobileshop.model.Specificate

class SelectedSpecViewModel : ViewModel() {
    private var selectedSpec : MutableLiveData<Specificate> = MutableLiveData()

    fun getSelectedSpec() : LiveData<Specificate> = selectedSpec

    fun selectedSpec(specificate: Specificate) {
        selectedSpec.value = specificate
    }
}