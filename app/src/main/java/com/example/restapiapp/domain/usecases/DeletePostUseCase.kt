package com.example.restapiapp.domain.usecases

import com.example.restapiapp.data.PostRepository
import com.example.restapiapp.data.api.model.PostResponse
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke(id: String) = postRepository.deletePost(id = id)
}