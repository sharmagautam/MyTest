package com.example.mytest

import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {
    @GET("/photos")
    suspend fun getImages() : Response<ImageResponse>
}