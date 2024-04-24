package com.example.rescuer.screen.fai

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rescuer.data.OffLineExpertSystem
import com.example.rescuer.data.repository.Repository

class FirstAidInstructionsViewModelFactory(private val repository: Repository, private val offLineExpertSystem: OffLineExpertSystem, private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FirstAidInstructionsViewModel(repository, offLineExpertSystem, application) as T
    }
}