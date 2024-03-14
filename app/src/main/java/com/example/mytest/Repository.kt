package com.example.mytest

import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val photoService: PhotoService) {
    suspend fun getImages() : Response<ImageResponse> {
       return photoService.getImages()
    }
}