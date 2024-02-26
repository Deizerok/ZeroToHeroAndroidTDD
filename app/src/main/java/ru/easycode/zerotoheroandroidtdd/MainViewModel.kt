package ru.easycode.zerotoheroandroidtdd


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository
): LiveDataWrapper.ProvideLiveData {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    override fun liveData() = liveDataWrapper.liveData()

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }
    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        coroutineScope.launch {
            val result = repository.load()
           result.show(liveDataWrapper)
        }
    }


    fun restore(bundleWrapper: BundleWrapper.Restore) {
        liveDataWrapper.update(bundleWrapper.restore())
    }
}