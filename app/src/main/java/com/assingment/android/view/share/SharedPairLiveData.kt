package com.assingment.android.view.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class SharedPairLiveData<F, S>(firstLiveData: LiveData<F>, secondLiveData: LiveData<S>) : MediatorLiveData<Pair<F?, S?>>() {
    init {
        addSource(firstLiveData) { firstLiveDataValue: F -> value = firstLiveDataValue to secondLiveData.value }
        addSource(secondLiveData) { secondLiveDataValue: S -> value = firstLiveData.value to secondLiveDataValue }
    }
}