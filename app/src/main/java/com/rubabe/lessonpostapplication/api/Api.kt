package com.rubabe.lessonpostapplication.api

import com.rubabe.lessonpostapplication.model.Comment
import com.rubabe.lessonpostapplication.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("comments")
    fun getComments(@Query("postId")postId : Int): Call<List<Comment>>


}