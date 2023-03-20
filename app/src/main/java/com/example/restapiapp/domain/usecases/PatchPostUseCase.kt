package com.example.restapiapp.domain.usecases

import com.example.restapiapp.data.PostRepository
import com.example.restapiapp.data.api.model.PostResponse
import javax.inject.Inject

class PatchPostUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke(id: String, body: PostResponse) = postRepository.patchPost(id = id, body = body)
}