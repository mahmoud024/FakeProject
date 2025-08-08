package com.example.fakeproject.Api

import com.example.fakeproject.Model.Post
import com.example.fakeproject.Model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostApi {
// api
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path ("id") postId: Int): Post

    @GET("users/{id}")
    suspend fun getUser(@Path ("id") userId: Int): User


    @PUT("post/{id}")
    suspend fun updatePost(@Path("id") postId:Int,@Body post:Post):Post


    @DELETE("post/{id}")
    suspend fun deletePost(@Path("id") postId:Int)

}