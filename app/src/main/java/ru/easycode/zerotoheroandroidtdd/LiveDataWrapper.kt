package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


interface LiveDataWrapper {

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Update {
        fun update(value: UiState)
    }

    interface ProvideLiveData {

        fun liveData(): LiveData<UiState>
    }

    interface Mutable : Save, Update, ProvideLiveData

    class Base : Mutable {

        private val liveData: MutableLiveData<UiState> = SingleLiveEvent<UiState>()

        override fun save(bundleWrapper: BundleWrapper.Save) {
            bundleWrapper.save(liveData.value!!)
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}
