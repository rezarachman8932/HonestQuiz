package com.assingment.android.view.share

class SharedUseCase(private val sharedViewRepository: SharedViewRepository) {

    fun setName(name: String) {
        sharedViewRepository.name = name
    }

}