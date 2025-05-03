package lk.malandev.myapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import lk.malandev.myapp.domain.usecase.GetUserUseCase
import lk.malandev.myapp.domain.models.User
import lk.malandev.myapp.domain.models.UserModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase):ViewModel() {

    private val _userData = MutableLiveData<User>()
    val userData: LiveData<User> = _userData

    private val _userListData = MutableLiveData<UserModel?>()
    val userListData: LiveData<UserModel?> = _userListData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun setData(user: User) {
        _userData.postValue(user)
    }

    fun getData() {
        viewModelScope.launch {
            try {
                _userListData.value = getUserUseCase.getUserByPage(2)

            } catch (ex: Exception) {
                _error.value = ex.message
            }
        }


    }
}