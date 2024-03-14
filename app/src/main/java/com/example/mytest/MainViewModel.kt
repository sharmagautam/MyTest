package com.example.mytest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

       private val _imageResponseLiveData = MutableLiveData<ImageResponse>()
    val imageResponseLiveData : LiveData<ImageResponse> get() = _imageResponseLiveData

    fun getImages(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response =  repository.getImages()
                if (response.isSuccessful){
                    _imageResponseLiveData.postValue(response.body())
                    Log.e("MainViewModel", "${response.body()}")
                }else{
                    Log.e("MainViewModel", "${response.errorBody()}")
                }
            }
            catch (e:Exception){
                Log.e("MainViewModel", "${e.localizedMessage}")
            }

        }
    }
}