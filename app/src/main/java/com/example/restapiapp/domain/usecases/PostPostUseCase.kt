package com.example.restapiapp.domain.usecases

import com.example.restapiapp.data.PostRepository
import com.example.restapiapp.data.api.model.PostResponse
import okhttp3.RequestBody
import okhttp3.Response
import javax.inject.Inject

class PostPostUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke(body: PostResponse) = postRepository.postPost(body = body)
}
