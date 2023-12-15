package com.loc.androiderroshandling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val userRepository: UserRepository = UserRepositoryImpl()

    fun getUser() {
        viewModelScope.launch {
            val user = userRepository.getUser()

        }
    }
}

