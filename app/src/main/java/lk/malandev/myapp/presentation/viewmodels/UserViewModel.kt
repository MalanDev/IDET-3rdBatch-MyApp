package lk.malandev.myapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import lk.malandev.myapp.domain.models.User
import lk.malandev.myapp.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) :ViewModel() {

    fun addUser(user: User) = viewModelScope.launch {
        repository.insert(user)
    }


    fun deleteUser(user: User) = viewModelScope.launch {
        repository.delete(user)
    }
}