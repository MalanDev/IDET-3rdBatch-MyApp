package lk.malandev.myapp.data.repository

import lk.malandev.myapp.domain.repository.UserNetworkRepository
import lk.malandev.myapp.data.remote.ApiService
import lk.malandev.myapp.domain.models.UserModel
import javax.inject.Inject

class UserNetworkRepositoryImpl @Inject constructor(private val apiService: ApiService):
    UserNetworkRepository {
    override suspend fun getUsers(page:Int): UserModel {
        return apiService.getUsers(page)
    }
}