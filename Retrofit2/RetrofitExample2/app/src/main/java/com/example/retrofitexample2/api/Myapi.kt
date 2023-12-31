package com.example.retrofitexample2.api

import com.example.retrofitexample2.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface Myapi {


    @GET("posts/1")
    suspend fun getPost1() : Post

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number : Int
    ) : Post


    @GET("posts")
    suspend fun getPostAll() : List<Post>

}