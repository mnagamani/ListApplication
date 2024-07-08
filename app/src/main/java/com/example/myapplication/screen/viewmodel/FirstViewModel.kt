package com.example.myapplication.screen.viewmodel


import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.data.Item
import com.example.myapplication.repository.interfaces.Repository
import com.example.myapplication.service.utils.NetworkResult
import com.example.myapplication.util.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for FirstFragment
 */
class FirstViewModel @Inject constructor(private val weatherRepository: Repository) :
    ViewModel() {

    //details
    private val _details = MutableLiveData<List<Item>?>()
    val details: LiveData<List<Item>?>
        get() = _details

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    //snack bar text
    private val _snackbarText = MutableLiveData<Event<String>>()
    val snackbarText: LiveData<Event<String>> = _snackbarText
    val itemAdapter = RecyclerViewAdapter()

    init {
        fetchDetails()
    }

    /**
     * function to fetch and display  details
     */
    internal fun fetchDetails() {
        setProgress(true)
        viewModelScope.launch {
            weatherRepository.fetchDetails()?.let { result ->
                setProgress(false)
                when (result) {
                    is NetworkResult.Success -> {
                        _details.postValue(result.data)
                    }

                    is NetworkResult.Error -> {
                        //TODO had more time, would handle different network error code
                        setSnackBarText(result.message)
                    }

                    is NetworkResult.Exception -> {
                        //TODO had more time,would handle different kind of exceptions
                        setSnackBarText(result.e.toString())
                    }
                }
            }
        }
    }

    /**
     * function to set value for showing progress
     */
    internal fun setProgress(isLoading: Boolean) {
        _dataLoading.postValue(isLoading)
    }

    /**
     * function that sets snack bar test
     */
    internal fun setSnackBarText(text: String?) {
        if (!text.isNullOrEmpty()) {
            _snackbarText.value = Event(text)
        }
    }


}
