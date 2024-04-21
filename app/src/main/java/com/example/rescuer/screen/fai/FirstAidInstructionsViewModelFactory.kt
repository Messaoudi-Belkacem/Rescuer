package com.example.rescuer.screen.fai

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rescuer.data.OffLineExpertSystem

class FirstAidInstructionsViewModelFactory(private val offLineExpertSystem: OffLineExpertSystem, private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FirstAidInstructionsViewModel(offLineExpertSystem, application) as T
    }
}