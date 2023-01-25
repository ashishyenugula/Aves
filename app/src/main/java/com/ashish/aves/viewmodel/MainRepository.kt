package com.ashish.aves.viewmodel

import com.ashish.aves.listners.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllImages() = retrofitService.getAllImages()
}