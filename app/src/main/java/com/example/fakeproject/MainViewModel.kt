package com.example.fakeproject

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeproject.Api.RetrofitInstance
import com.example.fakeproject.Model.Post
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){

    private val _post : MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get()= _post

    fun getPosts(){
        viewModelScope.launch {  // coroutine
            val fetchedPost = RetrofitInstance.api.getPosts()
            Log.i(TAG,"Your Post: $fetchedPost")
            _post.value = fetchedPost
        }
    }
}