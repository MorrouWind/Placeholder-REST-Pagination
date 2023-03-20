package com.example.restapiapp.presentation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapiapp.data.api.model.PostResponse
import com.example.restapiapp.domain.usecases.*
import com.example.restapiapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val deletePostUseCase: DeletePostUseCase,
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val patchPostsUseCase: PatchPostUseCase,
    private val postPostUseCase: PostPostUseCase,
    private val putPostUseCase: PutPostUseCase
): ViewModel() {

    private val _allPostsResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostResponse: LiveData<NetworkResult<List<PostResponse>>>
    get() = _allPostsResponse

    init {
        getAllPosts()
    }

    fun getPagingAllPosts() = getAllPostsUseCase.invokePaging()

    private fun getAllPosts(){
        viewModelScope.launch {
            getAllPostsUseCase.invoke().let {
                _allPostsResponse.value = it
            }
        }
    }

    fun postPost() {
        viewModelScope.launch {
            postPostUseCase.invoke(body = PostResponse(title = "my test title", body = "my body")).let {
                _allPostsResponse.value = it
            }
        }
    }

    fun putPost() {
        viewModelScope.launch {
            putPostUseCase.invoke(id = "1", body = PostResponse(title = "my test title", body = "my body")).let {
                Log.d("Check data", "data: ${it.data}")
            }
        }
    }

    fun patchPost() {
        viewModelScope.launch {
            patchPostsUseCase.invoke(id = "1", body = PostResponse(title = "my test title", body = "my body")).let {
                Log.d("Check data", "data: ${it.data}")
            }
        }
    }

    fun deletePost() {
        viewModelScope.launch {
            deletePostUseCase.invoke(id = "1").let {
                Log.d("Check data", "data: ${it.data}")
            }
        }
    }
}