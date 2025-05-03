package lk.malandev.myapp.domain.repository

import lk.malandev.myapp.domain.models.UserModel

interface UserNetworkRepository {

    suspend fun getUsers(page:Int): UserModel
}