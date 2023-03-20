package com.example.restapiapp.data.api

import com.example.restapiapp.data.api.model.PostResponse
import retrofit2.Response
import retrofit2.http.*

interface PostService {
    @GET("/posts")
    suspend fun getAllPosts(): Response<List<PostResponse>>

    @GET("/posts")
    suspend fun getPagingAllPosts(@Query("_start") pager: Int, @Query("_limit") limit: Int): Response<List<PostResponse>>

    @POST("/posts")
    suspend fun postPost(@Body body: PostResponse): Response<List<PostResponse>>

    @PUT("/posts/{id}")
    suspend fun putPost(@Path("id") id: String, @Body body: PostResponse): Response<List<PostResponse>>

    @PATCH("/posts/{id}")
    suspend fun patchPost(@Path("id") id: String, @Body body: PostResponse): Response<List<PostResponse>>

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") id: String): Response<List<PostResponse>>



}