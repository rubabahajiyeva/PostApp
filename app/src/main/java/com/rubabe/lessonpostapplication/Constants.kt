package com.rubabe.lessonpostapplication

import com.rubabe.lessonpostapplication.api.Api
import com.rubabe.lessonpostapplication.network.RetrofitClient

class Constants {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun getApi(): Api {
            return RetrofitClient.getClient(BASE_URL).create(Api::class.java)
        }
    }
}