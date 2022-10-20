package com.noxo.evapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noxo.evapp.model.Credentials
import com.noxo.evapp.service.EvService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val evService: EvService) : ViewModel() {

    private val coroutineExceptionHanlder = CoroutineExceptionHandler { _, throwable ->
        currentCredentials.postValue(Result.failure(throwable))
    }

    private val coroutineScope = CoroutineScope(Dispatchers.IO + coroutineExceptionHanlder)

    val currentCredentials: MutableLiveData<Result<Credentials>> by lazy {
        MutableLiveData<Result<Credentials>>()
    }

    fun login(username : String, password : String)  {
        this.coroutineScope.launch {
            val credentials = evService.login(username, password)
            currentCredentials.postValue(Result.success(credentials))
        }
    }
}