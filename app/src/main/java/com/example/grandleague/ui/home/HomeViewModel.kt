package com.example.grandleague.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grandleague.data.model.MatchesResponse
import com.example.grandleague.repository.MatchesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class HomeViewModel @Inject constructor(
    private val matchesRepo: MatchesRepo
):ViewModel(){
    private val _resp= MutableLiveData<MatchesResponse>()
    val matchesresp: LiveData<MatchesResponse>
        get()= _resp
    init {
        getMatches()
     }

    private fun getMatches() =viewModelScope.launch{
        matchesRepo.getFromDao().let {
            _resp.postValue(it)
        }
             }

}