package com.assingment.android.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assingment.android.view.rank.RankUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val rankUseCase: RankUseCase): ViewModel() {

    private val _isNameExists = MutableLiveData<Boolean>()
    val isNameExists : LiveData<Boolean> = _isNameExists

    fun isNameExists(name: String) {
        viewModelScope.launch {
            val existedName = rankUseCase.getUserByName(name)?.name

            if (existedName.isNullOrEmpty()) {
                _isNameExists.postValue(false)
            } else {
                _isNameExists.postValue(existedName == name)
            }
        }
    }

}