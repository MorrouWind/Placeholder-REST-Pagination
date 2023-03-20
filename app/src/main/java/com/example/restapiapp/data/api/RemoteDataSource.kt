package com.example.restapiapp.data.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.restapiapp.data.api.model.PostResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val postService: PostService) {
    suspend fun getAllPosts() = postService.getAllPosts()

    fun getPagingAllPosts() = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = {PostPagingDataSource(postService = postService)}
    ).flow

    suspend fun postPost( body: PostResponse) = postService.postPost(body = body)

    suspend fun putPost(id: String, body: PostResponse) = postService.putPost(id = id, body = body)

    suspend fun patchPost(id: String, body: PostResponse) = postService.patchPost(id = id, body = body)

    suspend fun deletePost(id: String) = postService.deletePost(id = id)
}