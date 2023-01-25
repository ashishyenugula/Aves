package com.ashish.aves.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashish.aves.model.ImageResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val data = MutableLiveData<List<ImageResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllImages() {

        val response = repository.getAllImages()
        response.enqueue(object : Callback<List<ImageResponse>> {
            override fun onResponse(call: Call<List<ImageResponse>>, response: Response<List<ImageResponse>>) {
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<List<ImageResponse>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}